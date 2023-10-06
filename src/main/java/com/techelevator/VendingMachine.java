package com.techelevator;

public class VendingMachine {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        TransactionLog log = new TransactionLog();
        SalesReport salesReport = new SalesReport();
        MainMenu menu = new MainMenu(inventory);
        menu.mainMenu();
    }
}
