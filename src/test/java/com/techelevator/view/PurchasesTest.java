package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Purchases;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class PurchasesTest {

    Purchases sut = new Purchases();

    Scanner userInput = new Scanner(System.in);

    Inventory inventory = new Inventory();

    @Test
    public void runPurchasesMen_happy_path(){
        String option = "2";
        Assert.assertEquals(sut.runPurchaseMenu(inventory), 2);

    }
}
