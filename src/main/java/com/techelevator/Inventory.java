package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    Scanner fileReader = new Scanner(System.in);

    public  List<Item> inventoryList = new ArrayList<>();

    public List<Item> createList()  {
        File inputFile = new File("C:\\Users\\Student\\workspace\\capstones\\java-minicapstonemodule1-team5\\src\\main\\java\\com\\techelevator\\vendingmachine.csv");
        List<Item> newList = new ArrayList<>();
        int indexCounter = 0;
        try (Scanner fileReader = new Scanner(inputFile)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] itemProperties = line.split("\\|");
                String itemLocation = itemProperties[0];
                String itemName = itemProperties[1];
                String itemPriceString = itemProperties[2];
                Double itemPrice = Double.parseDouble(itemPriceString);
                String itemType = itemProperties[3];
                Item newItem = new Item(itemName, itemPrice, 5, itemType, itemLocation);
                newList.add(indexCounter, newItem);
                indexCounter++;
            }
            return newList;


        } catch (FileNotFoundException e) {
            return null;
        }

    }

    public void displayItems(Inventory inventory){
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

    }


}


