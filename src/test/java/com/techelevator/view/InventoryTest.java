package com.techelevator.view;

import com.techelevator.Inventory;
import com.techelevator.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InventoryTest {


    Inventory inventory = new Inventory();


    @Test
    public void createItems_happy_path() {
        inventory.createList();

        Assert.assertEquals(inventory.createList().size(), 16);

    }
    @Test
    public void displayItems_happy_path() {
        List<Item> sut = new ArrayList<>(inventory.createList());
        inventory.displayItems();

        Assert.assertEquals(inventory.displayItems().size(), 16);

    }

    @Test
    public void displayItems_blank() {
        List<Item> sut = new ArrayList<>();
        inventory.displayItems();

        Assert.assertEquals(inventory.displayItems().size(), 0);

    }

    @Test
    public void displayItems_null() {
        List<Item> sut;
        inventory.displayItems();

        Assert.assertEquals(inventory.displayItems().size(), 0);

    }
}
