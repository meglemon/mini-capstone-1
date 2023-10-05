package com.techelevator;

public class Item {

    private final String GUM_MESSAGE = "Chew Chew, Yum!";
    private final String CANDY_MESSAGE = "Munch Munch, Yum!";
    private final String CHIP_MESSAGE = "Crunch Crunch, Yum!";
    private final String DRINK_MESSAGE = "Glug Glug, Yum!";
    private String name;
    private double price;
    private int quantity = 5;
    private String type;
    private String location;

    
    public Item() {
    }

    public Item(String name, double price, int quantity, String type) {
        //inventory
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public Item(String name, double price, int quantity, String type, String location) {
        //display
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.location = location;
    }

}
