package com.techelevator;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {

        while (true) {
            MainMenu mainMenu = new MainMenu();
            int option = Integer.parseInt(mainMenu.mainChoice());
            Inventory inventory = new Inventory();


            switch (option) {

                case 1:
                    inventory.displayItems(inventory);
                    System.out.println();
                    break;

                case 2:
                    Purchases purchases = new Purchases();
                    purchases.choice();
                    mainMenu.mainChoice();
                    break;

                case 3:
                    System.out.println("bye bye bye");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select 1, 2 or 3!");
                    mainMenu.mainChoice();
            }
        }


    }

    public String mainChoice () {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Main Menu");
        System.out.println();
        System.out.println("Choose your vending machine adventure: ");
        System.out.println("[1] See available items.");
        System.out.println("[2] Purchase something yummy!");
        System.out.println("[3] Exit");

        return userInput.nextLine();
    }

}
