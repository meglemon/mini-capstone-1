package com.techelevator;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Purchases {
    //  F I E L D S  //
    private static final DecimalFormat df = new DecimalFormat("0.00");
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm a");
    String formattedDate = now.format(dtf);  //17-02-2022
    private List<String> transactionLog = new ArrayList<>();
    static List<Item> currentSalesReport = new ArrayList<>();
    private final Scanner userInput = new Scanner(System.in);
    private Inventory inventory = new Inventory();
    private double totalBalance;
    private int index;
    String moneyFed;


    //  C O N S T R U C T O R S  //

    public Purchases(Inventory inventory, double totalBalance, int index) {
        this.inventory = inventory;
        this.totalBalance = totalBalance;
        this.index = index;
    }

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

    public List<String> getTransactionLog() {
        return transactionLog;
    }

    public static List<Item> getCurrentSalesReport() {
        return currentSalesReport;
    }

    public int runPurchaseMenu (Inventory inventory, String currentChoice) {
            boolean isThree = false;

            while (!isThree) {
                try {
                    currentChoice = choice();
                    int option = Integer.parseInt(currentChoice);

                    switch (option) {
                        case 1:
                            feedMoney(moneyFed);
                            break;

                        case 2:
                            isValidItem(inventory);
                            break;

                        case 3:
                            finishTransaction();
                            isThree = true;
                            break;

                        default:
                            System.out.println("Please select 1, 2 or 3!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please select 1, 2 or 3!");
                }
            }
        return 0;
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

    public double feedMoney(String moneyFed) {
        try {
            String answer = "";
            do {

                System.out.println("How much money would you like to load?");
                moneyFed = userInput.nextLine();
                double currentMoneyProvided = Double.parseDouble(moneyFed);

                if (currentMoneyProvided <= 0) {
                    System.out.println("Please input a positive amount to continue.");
                    feedMoney(moneyFed);
                    return 0;
                }

                setTotalBalance(getTotalBalance() + currentMoneyProvided);

                String transactionLogLine = formattedDate + " FEED MONEY: $" + df.format(currentMoneyProvided) + " $" + df.format(totalBalance);
                getTransactionLog().add(getIndex(), transactionLogLine);
                setIndex(getIndex() + 1);

                System.out.println("You added $" + df.format(currentMoneyProvided));
                System.out.println("Current Balance is now $" + df.format(totalBalance));
                System.out.println("Would you like to add more money? [Y/N]");
                answer = userInput.nextLine();
//                if (!answer.equalsIgnoreCase("y") || !answer.equalsIgnoreCase("n")) {
//                    System.out.println("Incorrect input. Please select [y] or [n]");
//                }

            } while (userInput.nextLine().equalsIgnoreCase("y"));

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid cash amount!");
        }
        double feedMoney = getTotalBalance();
        return feedMoney;
    }

    public boolean isValidItem(Inventory inventory) {
        boolean isValidItem = false;
        while (isValidItem == false) {
            System.out.println();
            System.out.println("Select an item from the list!");
            System.out.println();
            inventory.displayItems(); // display inventory
            String itemSelected = userInput.nextLine(); // customer selects an item

            for (int i = 0; i < inventory.getInventoryList().size(); i++) {

                if (inventory.getInventoryList().get(i).getLocation().equalsIgnoreCase(itemSelected)) {
                    isValidItem = true;

                    int quantity = inventory.getInventoryList().get(i).getQuantity();
                    double price = inventory.getInventoryList().get(i).getPrice();
                    String name = inventory.getInventoryList().get(i).getName();
                    String type = inventory.getInventoryList().get(i).getType();

                    if (price > getTotalBalance()) {
                        System.out.println();
                        System.out.println("Insufficient funds for that item. Sorry!");
                        System.out.println("Select another item or return to purchase menu to deposit more money.");
                        return false;

                    } else if (quantity == 0) {
                        System.out.println();
                        System.out.println("Sorry! " + name + " is all sold out! Pick another yummy option!");
                        return false;

                    } else if (quantity > 0) {
                        quantity -= 1;
                        inventory.getInventoryList().get(i).setQuantity(quantity);

                        System.out.println();
                        System.out.println(name + " " + df.format(price));

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
                            System.out.println("You have a remaining balance of: $" + df.format(totalBalance));

                            String transactionLogLine = formattedDate + " " + name + " " + inventory.getInventoryList().get(i).getLocation() + " $" + df.format(price) + " $" + df.format(totalBalance);
                            getTransactionLog().add(getIndex(), transactionLogLine);
                            setIndex(getIndex() + 1);

                            return true;
                        }
                }
            }
            if (!isValidItem) {
                System.out.println("Sorry! That code is invalid!");
                System.out.println();
            } else {
                break;
            }
        } return false;
    }


    public double finishTransaction() {

        System.out.println();
        System.out.println("Thank you for choosing the yummy vending machine today!");
        System.out.println("Your change is $" + df.format(totalBalance));


        // save to transaction Log
        String transactionLogLine = formattedDate + " GIVE CHANGE: $" + df.format(totalBalance) + " $" + df.format(totalBalance - totalBalance);
        getTransactionLog().add(getIndex(), transactionLogLine);
        index += 1;

        int changeDollars = (int)(totalBalance);
        if (changeDollars == 1) {
            System.out.print("Your change is " + changeDollars + " dollar");
        } else {
            System.out.print("Your change is " + changeDollars + " dollars");
        }

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

        return 0.0;
    }


}
