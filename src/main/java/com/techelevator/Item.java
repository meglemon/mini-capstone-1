package com.techelevator;

public class Item {

    private String name;
    private double price;
    private int quantity;
    private String message;
    private String location;

    public Item() {
    }

    public Item(String name, double price, int quantity, String message, String location) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.message = message;
        this.location = location;
    }

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
