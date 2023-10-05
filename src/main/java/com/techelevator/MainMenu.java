package com.techelevator;

import java.util.Scanner;

public class MainMenu {



    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Main Menu");
        System.out.println("Choose your vending machine adventure: ");
        System.out.println("[1] See available items.");
        System.out.println("[2] Purchase something yummy!");
        System.out.println("[3] Exit");

        String choice = userInput.nextLine();

        switch (choice) {

            case "1":
                inventory.displayItems(inventory);

                break;

            case "2":
                // run purchase menu

            case "3":
                System.out.println("bye bye bye");

            default:
                System.out.println("Please select 1, 2 or 3!");
        }
    }


}
