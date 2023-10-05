package com.techelevator;

public class Gum extends Item {

    public Gum() {
    }

    public Gum(String name, double price, int quantity, String message, String location) {
        super(name, price, quantity, message, location);
    }

    public Gum(String name, double price, int quantity) {
        super(name, price, quantity);
    }

}
