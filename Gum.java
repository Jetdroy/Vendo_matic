package com.techelevator.view;

public class Gum extends Product {

    public Gum(String name,String type, String itemNUmber, double price) {
        super(name,type, itemNUmber, price);
    }

    @Override
    public String getSound() {

        return "\"Chew Chew, Yum!\"";
    }

}