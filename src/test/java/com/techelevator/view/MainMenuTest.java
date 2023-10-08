package com.techelevator.view;

import com.techelevator.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenuTest {

    // happy path
    @Test
    public void menu_happy_path() {
        Inventory inventory = new Inventory();
        Purchases purchases = new Purchases();
        Scanner scanner = new Scanner(System.in);
        TransactionLog transactionLog = new TransactionLog();


        MainMenu sut = new MainMenu(inventory, purchases, scanner, transactionLog);

        int option = 2;

        inventory.createList();
        Assert.assertEquals(inventory.displayItems().get(1).getLocation(), "A2");

    }

    @Test
    public void menu_outside_integer() {
        Inventory inventory = new Inventory();
        Purchases purchases = new Purchases();
        Scanner scanner = new Scanner(System.in);
        TransactionLog transactionLog = new TransactionLog();


        MainMenu sut = new MainMenu(inventory, purchases, scanner, transactionLog);

        int option = 5;

        inventory.createList();
        Assert.assertEquals("","");

    }

    // insufficient funds
    // secret menu
    // invalid code
    // sold out

}
