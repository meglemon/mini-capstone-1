package com.techelevator;

public class Candy extends Item {

    public Candy() {
    }

    public Candy(String name, double price, int quantity, String message, String location) {
        super(name, price, quantity, message, location);
    }

    public Candy(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
