package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    Scanner inputFile = new Scanner("C:\\Users\\Student\\workspace\\capstones\\java-minicapstonemodule1-team5\\vendingmachine.csv");

    public  List<Item> inventoryList = new ArrayList<>();

    private Item getIndividualItem(String line) {

        String[] itemProperties = line.split("//|");
        String itemLocation = itemProperties[0];
        String itemName = itemProperties[1].replace("//|", "");
        String itemPriceString = itemProperties[2].replace("//|", "");
        Double itemPrice = Double.parseDouble(itemPriceString);
        String itemType = itemProperties[3].replace("//|", "");
        Item newItem = new Item(itemName, itemPrice, 5, itemType, itemLocation);
        return newItem;
    }


    public List<Item> getInventoryList() {
        while (inputFile.hasNextLine()) {
            int index = 0;
            inventoryList.add(index, getIndividualItem(inputFile.nextLine()));
            index++;
        }

        return inventoryList;

    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.
    }


}


