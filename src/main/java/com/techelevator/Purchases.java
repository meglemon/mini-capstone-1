package com.techelevator;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class Purchases {

    static List<String> transactionLog = new ArrayList<>();

    static List<Item> dailySalesReport = new ArrayList<>();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private final Double NICKLE = .05;
    private final Double DIME = .1;
    private final Double QUARTER = .25;


    public static void main(String[] args) throws InvalidCodeInput {

        Inventory inventory = new Inventory();
        List <Item> inventoryList = inventory.getInventoryList();
        
        Scanner userInput = new Scanner(System.in);

        Purchases currentPurchase = new Purchases();
        String currentChoice = currentPurchase.choice();

        Double currentMoneyProvided = 0.00;
        Double remainingBalance = 0.00;


        int index = 0;
        double totalBalance = 0;

        switch (currentChoice) {
            case "1":
               while ( userInput.nextLine().equalsIgnoreCase("y")) {
                   System.out.println("How much money would you like to load?");
                   String moneyFed = userInput.nextLine();
                   currentMoneyProvided += Double.parseDouble(moneyFed);
                   String transactionLogLine = LocalDateTime.now() + "FEED MONEY: $" + currentMoneyProvided + "$" +(totalBalance + currentMoneyProvided);
                   transactionLog.add(index, transactionLogLine);
                   index += 1;
                   System.out.println("Current Balance: $" + df.format(currentMoneyProvided));
                   System.out.println("Would you like to feed more money? [Y/N] ");
                   if (userInput.nextLine().equalsIgnoreCase("n")) {
                       Purchases nextPurchase = new Purchases();
                       nextPurchase.choice();
                       break;
                   }
               }
               break;

            case "2":
                System.out.println("Select an item from the list!");
                inventory.displayItems(inventory);
                String itemSelected = userInput.nextLine();

                try{

                    if (inventoryList.contains(itemSelected.toString())) {
                        for (int i = 0; i < inventoryList.size(); i++) {

                            if (inventoryList.get(i).getLocation().equalsIgnoreCase(itemSelected)) {

                                int quantity = inventoryList.get(i).getQuantity();

                                if (quantity == 0) {
                                    System.out.println("Sorry! " + inventoryList.get(i).getName() + " is all sold out! Pick another yummy option!");
                                }

                                // if price is too high

                                if (quantity > 0) {
                                    inventoryList.get(i).setQuantity(quantity - 1); // not confident this will change the official inventory

                                    System.out.println(inventoryList.get(i).getName() + " " + inventoryList.get(i).getPrice());
                                    System.out.println();

                                    if(inventoryList.get(i).getType().equals("Chips")) {
                                        System.out.println(inventoryList.get(i).getCHIP_MESSAGE());
                                    } else if (inventoryList.get(i).getType().equals("Candy")) {
                                        System.out.println(inventoryList.get(i).getCANDY_MESSAGE());
                                    } else if (inventoryList.get(i).getType().equals("Drink")) {
                                        System.out.println(inventoryList.get(i).getDRINK_MESSAGE());
                                    } else if (inventoryList.get(i).getType().equals("Gum")) {
                                        System.out.println(inventoryList.get(i).getGUM_MESSAGE());
                                    }

                                    System.out.println();
                                    double price = inventoryList.get(i).getPrice();
                                    remainingBalance = currentMoneyProvided - price;
                                    System.out.println("You have a remaining balance of: $" + remainingBalance);
                                    String transactionLogLine = LocalDateTime.now() + inventoryList.get(i).getName() + inventoryList.get(i).getLocation() + " $" + df.format(price) + " $" + df.format(totalBalance - price);
                                    transactionLog.add(index, transactionLogLine);
                                    index += 1;
                                    Item item = new Item(inventoryList.get(i).getName(), price);
                                    dailySalesReport.add(item);

                                }

                                Purchases anotherPurchase = new Purchases();
                                String anotherChoice = anotherPurchase.choice();
                                break;
                            }
                        }
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Sorry! That code is invalid!");
                    Purchases nextPurchase = new Purchases();
                    nextPurchase.choice();
                    break;
                }

            case "3":

                System.out.println("Thank you for choosing the yummy vending machine today!");
                System.out.println("Your change is $" + df.format(remainingBalance));
                String transactionLogLine = LocalDateTime.now() + " GIVE CHANGE: $" + df.format(remainingBalance) + " $" + df.format(totalBalance - remainingBalance);
                transactionLog.add(index, transactionLogLine);
                index += 1;

                // completes transaction
               // gives change using nickels, dimes, and quarters
               // (using the smallest amount of coins possible).
                // The machine's current balance updates to $0 remaining.

                System.out.println("Balance is now $0.00");

            default:
                System.out.println("Please select 1, 2 or 3!");
        }


    }
    public String choice () {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Get some yummies!");
        System.out.println();
        System.out.println("Choose one of the following:");
        System.out.println("[1] Feed Money");
        System.out.println("[2] Select a yum yum");
        System.out.println("[3] Finish up & getcha change");

        return userInput.nextLine();
    }



}
