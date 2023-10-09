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
    public void runPurchasesMenu_happy_path_option_1(){

        String option = "1";
        userInput.nextLine().equals(5);

        Assert.assertEquals(5, userInput.nextLine().equals(5));

    }

    @Test
    public void runPurchasesMenu_happy_path_option_2(){
        String option = "2";
        Assert.assertEquals(sut.runPurchaseMenu(inventory), 2);

    }


    // invalid code
    // sold out
    // insufficient funds
}
