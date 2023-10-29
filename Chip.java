package com.techelevator.view;

public class Chip extends Product {

    public Chip(String name,String type, String itemNUmber, double price) {
        super(name,type, itemNUmber, price);
    }

    @Override
    public String getSound() {

        return "\"Crunch Crunch, Yum!\"";
    }

}