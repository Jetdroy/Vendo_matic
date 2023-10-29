package com.techelevator.view;

public class Candy extends Product {

    public Candy(String name,String type, String itemNUmber, double price) {
        super(name,type, itemNUmber, price);
    }

    @Override
    public String getSound() {

        return "\"Munch Munch, Yum!\"";
    }

}
