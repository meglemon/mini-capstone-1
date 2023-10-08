package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    Scanner fileReader = new Scanner(System.in);

    private  List<Item> inventoryList = new ArrayList<>();

    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Item> createList()  {
        File inputFile = new File("src/main/java/com/techelevator/vendingmachine.csv");
        int indexCounter = 0;
        List<Item> newList = new ArrayList<>();
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
            setInventoryList(newList);
            return inventoryList;

        } catch (FileNotFoundException e) {
            System.out.println("File cannot be found.");
            return null;
        }
    }



    public List<Item> displayItems(){
        List<Item> inventoryList = getInventoryList();
        for (int i = 0; i < inventoryList.size(); i++) {
            System.out.print(inventoryList.get(i).getLocation() + ": ");
            System.out.print(inventoryList.get(i).getName());
            System.out.print(" ($");
            System.out.printf("%.2f", inventoryList.get(i).getPrice());
            System.out.print(")");
            if (inventoryList.get(i).getQuantity() < 1) {
                System.out.print(" SOLD OUT!");
            }
            System.out.println();
        }
        return inventoryList;
    }

    public void removeItem() {
    }
}


