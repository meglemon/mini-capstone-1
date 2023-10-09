package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private Inventory inventory;
    private Purchases purchases;
    private SalesReport salesReport;
    private TransactionLog transactionLog;
    private Scanner scanner = new Scanner(System.in);
    private String currentChoice;

    public MainMenu(Inventory inventory, Purchases purchases, Scanner scanner, TransactionLog transactionLog, SalesReport salesReport) {
        this.inventory = inventory;
        this.purchases = purchases;
        this.scanner = scanner;
        this.transactionLog = transactionLog;
        this.salesReport = salesReport;
    }

    public List<String> menu(MainMenu mainMenu) {
        List<Item> inventoryList = inventory.createList();
            while (true) {
                try {
                    int option = Integer.parseInt(mainMenu.mainChoice(mainMenu.scanner));

                    switch (option) {

                        case 1:
                            System.out.println();
                            inventory.displayItems();
                            System.out.println();
                            break;

                        case 2:
                            mainMenu.purchases.runPurchaseMenu(inventory, currentChoice);
                            System.out.println();
                            break;

                        case 3:
                            System.out.println();
                            System.out.println("bye bye bye");
                            return purchases.getTransactionLog();




                        case 4:
                            System.out.println();
                            System.out.println("Total Sales Report");
                            salesReport.printSales(salesReport.salesListToMap(salesReport.transactionLogToSalesList()));
                            System.exit(0);
                            break;




                        default:
                            System.out.println("Please select 1, 2 or 3!");
                            break;

                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please select 1, 2, or 3!");
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