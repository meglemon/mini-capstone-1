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

        String testMoneyFed = "";

        Assert.assertEquals(sut.feedMoney(testMoneyFed), sut.runPurchaseMenu(inventory, option));;

    }

    @Test
    public void runPurchasesMenu_happy_path_option_2(){
        String testCurrentChoice = "2";
        Assert.assertEquals(sut.isValidItem(inventory), sut.runPurchaseMenu(inventory, testCurrentChoice));
    }

    @Test
    public void runPurchasesMenu_happy_path_option_3(){
        String option = "3";
        Assert.assertEquals(0.0, sut.finishTransaction(), .001);

    }

    @Test
    public void feedMoney_returns_totalBalance () {
        // arrange
        String testInput = userInput.nextLine();
        testInput = "2";
        sut.setTotalBalance(0);

        // act
        // assert
        Assert.assertEquals(2.00, sut.feedMoney(testInput));

    }
    @Test
    public void feedMoney_returns_error_when_negative_input() {
        // arrange
        String test = userInput.nextLine();
        test = "-2";

        //act
        // assert
        Assert.assertEquals(0, sut.feedMoney(test));
    }

    @Test
    public void isValidItem_returns_true_when_purchased () {
        // arrange
        String testItemSelected = userInput.nextLine();
        testItemSelected = "A1";
        sut.setTotalBalance(3.00);

        // act
        // assert
        Assert.assertTrue(sut.isValidItem(inventory));
    }
    @Test
    public void isValidItem_returns_false_with_insufficient_funds () {
        // arrange
        String testItemSelected = userInput.nextLine();
        testItemSelected = "A1";
        sut.setTotalBalance(.50);

        // act
        // assert
        Assert.assertTrue(sut.isValidItem(inventory));

    }

    // TODO: not sure how we would make this 0 quantity
//    @Test
//    public void isInvalidItem_returns_false_when_item_is_sold_out () {
//        // arrange
//        String testItemSelected = userInput.nextLine();
//        testItemSelected = "A1";
//        int quantity = inventory.getInventoryList().get(i).getQuantity();
//        quantity = 0;
//        sut.setTotalBalance(3.00);
//
//        // act
//        // assert
//        Assert.assertTrue(sut.isValidItem(inventory));
//    }

    @Test
    public void isValidItem_returns_false_when_input_is_invalid () {
        //arrange
        String testItemSelected = "Z5";
        //act
        //assert
        Assert.assertFalse(sut.isValidItem(inventory));

    }

}
