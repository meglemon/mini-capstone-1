package com.techelevator;

public class Drinks extends Item {

    public Drinks() {
    }

    public Drinks(String name, double price, int quantity, String message, String location) {
        super(name, price, quantity, message, location);
    }

    public Drinks(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
