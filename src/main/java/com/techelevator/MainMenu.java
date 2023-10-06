package com.techelevator;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        MainMenu mainMenu = new MainMenu();
        int option = Integer.parseInt(mainMenu.mainChoice());

        switch (option) {

            case 1:
                inventory.displayItems(inventory);

                break;

            case 2:
                Purchases purchases = new Purchases();
                purchases.choice();
                break;

            case 3:
                System.out.println("bye bye bye");
                break;

            default:
                System.out.println("Please select 1, 2 or 3!");
                break;
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
