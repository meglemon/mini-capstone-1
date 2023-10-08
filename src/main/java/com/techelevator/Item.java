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

    private int totalSold;


    public Item() {
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.totalSold = 0;
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

    public String getGUM_MESSAGE() {
        return GUM_MESSAGE;
    }

    public String getCANDY_MESSAGE() {
        return CANDY_MESSAGE;
    }

    public String getCHIP_MESSAGE() {
        return CHIP_MESSAGE;
    }

    public String getDRINK_MESSAGE() {
        return DRINK_MESSAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int quantitySold) {
        this.totalSold = quantitySold;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
