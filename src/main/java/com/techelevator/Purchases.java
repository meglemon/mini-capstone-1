package com.techelevator;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Purchases {
    //  F I E L D S  //
    private static final DecimalFormat df = new DecimalFormat("0.00");
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
    String formattedDate = now.format(dtf);  //17-02-2022
    static List<String> transactionLog = new ArrayList<>();
    static List<Item> dailySalesReport = new ArrayList<>();
    private final Scanner userInput = new Scanner(System.in);
    private final Inventory inventory = new Inventory();
    private double totalBalance;
    private int index;


    //  C O N S T R U C T O R S  //
    public Purchases() {
    }

    //  GETTERS & SETTERS  //
    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Inventory getInventory() {
        return inventory;
    }



    public void runPurchaseMenu () {

        boolean isThree = false;

        while (!isThree) {
            String currentChoice = choice();
            int option = Integer.parseInt(currentChoice);

            switch (option) {
                case 1:
                    feedMoney();
                    break;

                case 2:
                    selectItem();
                    break;

                case 3:
                    finishTransaction();
                    isThree = true;
                    break;

                default:
                    System.out.println("Please select 1, 2 or 3!");
            }
        }

    }

    public String choice () {

        System.out.println();
        System.out.println("Get some yummies!");
        System.out.println();
        System.out.println("Choose one of the following:");
        System.out.println("[1] Feed Money");
        System.out.println("[2] Select a yum yum");
        System.out.println("[3] Finish up & getcha change");

        return userInput.nextLine();
    }

    public void feedMoney() {

        do {
            System.out.println("How much money would you like to load?");
            String moneyFed = userInput.nextLine();
            double currentMoneyProvided = Double.parseDouble(moneyFed);
            setTotalBalance(getTotalBalance() + currentMoneyProvided);

            String transactionLogLine = formattedDate + " FEED MONEY: $" + df.format(currentMoneyProvided) + " $" + df.format(totalBalance);
            transactionLog.add(getIndex(), transactionLogLine);
            setIndex(getIndex() + 1);

            System.out.println("You added $" + df.format(currentMoneyProvided));
            System.out.println("Current Balance is now $" + df.format(totalBalance));
            System.out.println("Would you like to add more money? [Y/N]");

        } while (!userInput.nextLine().equalsIgnoreCase("n"));

    }

    public void selectItem() {

        System.out.println("Select an item from the list!");
        System.out.println();
        inventory.displayItems(inventory); // display inventory
        String itemSelected = userInput.nextLine(); // customer selects an item
        boolean isItemValid = false;
        while (true) {

            for (int i = 0; i < inventory.getInventoryList().size(); i++) {

                if (inventory.getInventoryList().get(i).getLocation().equalsIgnoreCase(itemSelected)) {
                    isItemValid = true;

                    int quantity = inventory.getInventoryList().get(i).getQuantity();
                    double price = inventory.getInventoryList().get(i).getPrice();
                    String name = inventory.getInventoryList().get(i).getName();
                    String type = inventory.getInventoryList().get(i).getType();

                    if (price > getTotalBalance()) {
                        System.out.println("Insufficient funds for that item. Sorry!");
                        System.out.println("Select another item or return to purchase menu to deposit more money.");

                    } else if (quantity == 0) {
                        System.out.println("Sorry! " + name + " is all sold out! Pick another yummy option!");

                    } else if (quantity > 0) {
                        inventory.getInventoryList().get(i).setQuantity(quantity - 1);

                        System.out.println(name + " " + price);
                        System.out.println();

                        switch (type) {
                            case "Chips":
                                System.out.println(inventory.getInventoryList().get(i).getCHIP_MESSAGE());
                                break;
                            case "Candy":
                                System.out.println(inventory.getInventoryList().get(i).getCANDY_MESSAGE());
                                break;
                            case "Drink":
                                System.out.println(inventory.getInventoryList().get(i).getDRINK_MESSAGE());
                                break;
                            case "Gum":
                                System.out.println(inventory.getInventoryList().get(i).getGUM_MESSAGE());
                                break;
                        }

                            System.out.println();
                            totalBalance -= price;
                            System.out.println("You have a remaining balance of: $" + totalBalance);

                            String transactionLogLine = formattedDate + " " + name + " " + inventory.getInventoryList().get(i).getLocation() + " $" + df.format(price) + " $" + df.format(totalBalance);
                            transactionLog.add(getIndex(), transactionLogLine);
                            setIndex(getIndex() + 1);


                            Item item = new Item(inventory.getInventoryList().get(i).getName(), price);
                            dailySalesReport.add(item);

                        }
                }
            }

            if (!isItemValid) {
                System.out.println("Sorry! That code is invalid!");
            } else {
                break;
            }
        }
    }


    public void finishTransaction () {

        System.out.println("Thank you for choosing the yummy vending machine today!");
        System.out.println("Your change is $" + df.format(totalBalance));


        // save to transaction Log
        String transactionLogLine = formattedDate + " GIVE CHANGE: $" + df.format(totalBalance) + " $" + df.format(totalBalance - totalBalance);
        transactionLog.add(index, transactionLogLine);
        index += 1;

        int changeDollars = (int)(totalBalance);
        System.out.print("Your change is " + changeDollars + "dollars ");

        double QUARTER = .25;
        if (totalBalance % changeDollars != 0) {
            totalBalance -= changeDollars;
            int quarterChange = (int) (totalBalance / QUARTER);
            totalBalance -= (quarterChange * QUARTER);
            if (quarterChange != 0) {
                if (quarterChange == 1){
                    System.out.print(" & " + quarterChange + " quarter");
                } else {
                    System.out.print(" & " + quarterChange + " quarters");
                }
            }
        }

        double DIME = .1;
        if (totalBalance % QUARTER != 0) {
            int dimeChange = (int) (totalBalance / DIME);
            totalBalance -= (dimeChange * DIME);
            if (dimeChange != 0) {
                if (dimeChange == 1){
                    System.out.print(" & " + dimeChange + " dime");
                } else {
                    System.out.print(" & " + dimeChange + " dimes");
                }
            }
        }

        if (totalBalance % DIME != 0) {
            double NICKLE = .05;
            int nickelChange = (int) (totalBalance / NICKLE);
            totalBalance -= (nickelChange * DIME);
            if (nickelChange != 0) {
                if (nickelChange == 1) {
                    System.out.print(" & " + nickelChange + " nickel");
                } else {
                    System.out.print(" & " + nickelChange + " nickels");
                }
            }
        }
        System.out.println();
        System.out.println("Balance is now $0.00");

        System.out.println();
    }

}
