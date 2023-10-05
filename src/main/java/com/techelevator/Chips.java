package com.techelevator;

public class Chips extends Item {

    public Chips() {
    }

    public Chips(String name, double price, int quantity, String message, String location) {
        super(name, price, quantity, message, location);
    }

    public Chips(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
