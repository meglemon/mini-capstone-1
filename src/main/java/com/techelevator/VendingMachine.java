package com.techelevator;

import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {
        Purchases purchases = new Purchases();
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner (System.in);
        TransactionLog transactionLog = new TransactionLog();
        SalesReport salesReport= new SalesReport();
        MainMenu mainMenu = new MainMenu(inventory, purchases, scanner, transactionLog, salesReport);
        transactionLog.createLog(mainMenu.menu(mainMenu));
        System.out.println();
    }
}
