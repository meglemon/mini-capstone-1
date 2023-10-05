package com.techelevator;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        MainMenu mainMenu = new MainMenu();
        mainMenu.mainChoice();

        switch (mainMenu.mainChoice()) {

            case "1":
                for (int i = 0; i < inventory.createList().size(); i++) {
                System.out.print(inventory.createList().get(i).getLocation() + ": ");
                System.out.print(inventory.createList().get(i).getName());
                System.out.print(" ($");
                System.out.printf("%.2f", inventory.createList().get(i).getPrice());
                    System.out.print(")");
                if (inventory.createList().get(i).getQuantity() < 1) {
                        System.out.print("SOLD OUT!");
                    }
                System.out.println();
                }
                break;

            case "2":
                Purchases purchases = new Purchases();
                break;

            case "3":
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
