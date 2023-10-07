package com.techelevator;

import com.sun.tools.javac.Main;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Inventory inventory;
    private Purchases purchases;

    private TransactionLog transactionLog;
    private Scanner scanner = new Scanner(System.in);

    public MainMenu(Inventory inventory, Purchases purchases, Scanner scanner, TransactionLog transactionLog) {
        this.inventory = inventory;
        this.purchases = purchases;
        this.scanner = scanner;
        this.transactionLog = transactionLog;
    }

    public List<String> menu(MainMenu mainMenu) {
        while (true) {
            int option = Integer.parseInt(mainMenu.mainChoice(mainMenu.scanner));

            switch (option) {

                case 1:
                    inventory.displayItems(inventory);
                    System.out.println();
                    break;

                case 2:
                    mainMenu.purchases.runPurchaseMenu();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("bye bye bye");
                    return purchases.getTransactionLog();


                case 4:
                    // read sales Report


                default:
                    System.out.println("Please select 1, 2 or 3!");
                    mainChoice(mainMenu.scanner);
                    break;

            }
        }
    }

    public String mainChoice(Scanner scanner) {

        System.out.println("Main Menu");
        System.out.println();
        System.out.println("Choose your vending machine adventure: ");
        System.out.println("[1] See available items.");
        System.out.println("[2] Purchase something yummy!");
        System.out.println("[3] Exit");

        return scanner.nextLine();
    }

}