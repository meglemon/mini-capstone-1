package com.techelevator;

import java.util.Scanner;

public class Purchases {

    private final Double NICKLE = .05;
    private final Double DIME = .1;
    private final Double QUARTER = .25;


    public static void main(String[] args) throws InvalidCodeInput {

        Scanner userInput = new Scanner(System.in);

        Purchases currentPurchase = new Purchases();
        String currentChoice = currentPurchase.choice();

        Double currentMoneyProvided = 0.00;

        switch (currentChoice) {
            case "1":
               while (!userInput.nextLine().equalsIgnoreCase("n")) {
                   System.out.println("How much money would you like to load?");
                   String moneyFed = userInput.nextLine();
                   currentMoneyProvided += Double.parseDouble(moneyFed);
                   System.out.println("Current Balance: " + currentMoneyProvided);
                   System.out.println("Would you like to feed more money? [Y/N] ");
                   if (userInput.nextLine().equalsIgnoreCase("n")) {
                       Purchases nextPurchase = new Purchases();
                       nextPurchase.choice();
                       return;
                   }
               }
               return;

            case "2":


            // show available items with prices and location
            // allow the user to input the code for the item

                String itemSelected = userInput.nextLine();

//        - If the product code doesn't exist, the vending machine informs the customer and returns them
//        to the Purchase menu.

                try {

                } catch (InvalidCodeInput e) {
                    // return to main menu
                    System.out.println("Sorry! That code is invalid!");
                    MainMenu newMain = new MainMenu();
                }

//            // try -- create exception: InvalidCode -- catch return to purchase menu
//
//        - If a product is currently sold out, the vending machine informs the customer and returns them to the
//        Purchase menu.
//
//            // if quantity is 0, tell customer the item is sold out and return to purchase menu
//
//        - If a customer selects a valid product, it's dispensed to the customer.
//        - Dispensing an item prints the item name, cost, and the money
//        remaining. Dispensing also returns a message:
//          - All chip items print "Crunch Crunch, Yum!"
//          - All candy items print "Munch Munch, Yum!"
//          - All drink items print "Glug Glug, Yum!"
//          - All gum items print "Chew Chew, Yum!"
//
//            // valid item dispenses the item and prints the name, cost and money remaining
//            // also displays type message
//
//
//        - After the machine dispenses the product, the machine must update its balance
//        accordingly and return the customer to the Purchase menu.
//            // display remaining balance then return to purchase menu

                 */

            case "3":
                // completes transaction
               // gives change using nickels, dimes, and quarters
               // (using the smallest amount of coins possible).
                // The machine's current balance updates to $0 remaining.

            default:
                System.out.println("Please select 1, 2 or 3!");
        }


    }
    public String choice () {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Get some yummies!");
        System.out.println("Choose one of the following:");
        System.out.println("[1] Feed Money");
        System.out.println("[2] Select a yum yum");
        System.out.println("[3] Finish up & getcha change");

        String choice = userInput.nextLine();
        return choice;
    }

}
