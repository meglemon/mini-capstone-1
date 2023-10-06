package com.techelevator;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class Purchases {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    static List<String> transactionLog = new ArrayList<>();
    static List<Item> dailySalesReport = new ArrayList<>();
    private final Scanner userInput = new Scanner(System.in);
    private final Inventory inventory = new Inventory();
    private double totalBalance = 0;
    private int index;

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

    public Purchases() {
    }

    public void runPurchaseMenu () {

        Purchases run = new Purchases();
        run.choice();
        String currentChoice = run.choice();
        int option = Integer.parseInt(currentChoice);
        int transIndex = 0;


        switch (option) {
            case 1:
                run.feedMoney();
                break;

            case 2:
                run.selectItem();
                break;

            case 3:
                finishTransaction();
                break;

            default:
                System.out.println("Please select 1, 2 or 3!");
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

        int index = 0;

        do {
            System.out.println("How much money would you like to load?");
            String moneyFed = userInput.nextLine();
            double currentMoneyProvided = Double.parseDouble(moneyFed);
            totalBalance += currentMoneyProvided;

//            String transactionLogLine = LocalDateTime.now() + "FEED MONEY: $" + currentMoneyProvided + "$" + (totalBalance);
//             transactionLog.add(transIndex, transactionLogLine);
//             transIndex += 1;

            System.out.println("You added $" + df.format(currentMoneyProvided));
            System.out.println("Current Balance is now $" + df.format(totalBalance));
            System.out.println("Would you like to add more money? [Y/N]");

        } while (!userInput.nextLine().equalsIgnoreCase("n"));

//        if (userInput.nextLine().equalsIgnoreCase("n")) {
//            run.choice();
//        }
    }

    public void selectItem() {

        List <Item> inventoryList = inventory.getInventoryList();

        System.out.println("Select an item from the list!");
        inventory.displayItems(inventory); // display inventory
        String itemSelected = userInput.nextLine(); // customer selects an item


        try {
            if (inventoryList.contains(itemSelected)) {
                for (int i = 0; i < inventoryList.size(); i++) {
                    if (inventoryList.get(i).getLocation().equalsIgnoreCase(itemSelected)) {
                        int quantity = inventoryList.get(i).getQuantity();
                        double price = inventoryList.get(i).getPrice();
                        String name = inventoryList.get(i).getName();
                        String type = inventoryList.get(i).getType();

                        if (price < totalBalance) {
                            System.out.println("Insufficient funds for that item. Sorry!");
                            System.out.println("Select another item or return to purchase menu to deposit more money.");

                        } else if (quantity == 0) {
                            System.out.println("Sorry! " + name + " is all sold out! Pick another yummy option!");

                        } else if (quantity > 0) {
                            inventoryList.get(i).setQuantity(quantity - 1);

                            System.out.println(name + " " + price);
                            System.out.println();

                            if (type.equals("Chips")) {
                                System.out.println(inventoryList.get(i).getCHIP_MESSAGE());
                            } else if (type.equals("Candy")) {
                                System.out.println(inventoryList.get(i).getCANDY_MESSAGE());
                            } else if (type.equals("Drink")) {
                                System.out.println(inventoryList.get(i).getDRINK_MESSAGE());
                            } else if (type.equals("Gum")) {
                                System.out.println(inventoryList.get(i).getGUM_MESSAGE());
                            }

                            System.out.println();
                            totalBalance -= price;
                            System.out.println("You have a remaining balance of: $" + totalBalance);
                            String transactionLogLine = LocalDateTime.now() + inventoryList.get(i).getName() + inventoryList.get(i).getLocation() + " $" + df.format(price) + " $" + df.format(totalBalance - price);
                            transactionLog.add(index, transactionLogLine);
                            index += 1;
                            Item item = new Item(inventoryList.get(i).getName(), price);
                            dailySalesReport.add(item);

                        }
                    }
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Sorry! That code is invalid!");
            Purchases nextPurchase = new Purchases();
            nextPurchase.choice();
            
        }
    }

    public void finishTransaction () {

        System.out.println("Thank you for choosing the yummy vending machine today!");
        System.out.println("Your change is $" + df.format(totalBalance));

        // save to transaction Log
        String transactionLogLine = LocalDateTime.now() + " GIVE CHANGE: $" + df.format(totalBalance) + " $" + df.format(totalBalance - totalBalance);
        transactionLog.add(index, transactionLogLine);
        index += 1;

        int changeDollars = (int)(totalBalance);
        System.out.println("Your change is $" + changeDollars);

        Double QUARTER = .25;
        if (totalBalance % changeDollars != 0) {
            totalBalance -= changeDollars;
            int quarterChange = (int) (totalBalance / QUARTER);
            totalBalance -= (quarterChange * QUARTER);
            System.out.print("& " + quarterChange + "quarters");
        }

        Double DIME = .1;
        if (totalBalance % QUARTER != 0) {
            int dimeChange = (int) (totalBalance / DIME);
            totalBalance -= (dimeChange * DIME);
            System.out.print("& " + dimeChange + "dimes");
        }

        if (totalBalance % DIME != 0) {
            Double NICKLE = .05;
            int nickelChange = (int) (totalBalance / NICKLE);
            totalBalance -= (nickelChange * DIME);
            System.out.print("& " + nickelChange + "nickels");
        }

        System.out.println("Balance is now $0.00");
    }

}
