package com.techelevator.view;

public class Drink extends Product {

    public Drink(String name,String type, String itemNUmber, double price) {
        super(name,type, itemNUmber, price);
    }

    @Override
    public String getSound() {

        return "\"Glug Glug, Yum!\"";
    }

}