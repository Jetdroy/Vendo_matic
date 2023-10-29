package com.techelevator.view;


public abstract class Product {
    //Class for the Tree map to add identifiers for the items
    private  String name;
    private  double price;
    private  String type;
    private  String itemNumber;

    private int quantity = 5;

    public Product(String name, String type, String itemNumber, double price){
        this.itemNumber = itemNumber;
        this.name = name;
        this.type = type;
        this.price = price;
    }



    //Getters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    //Hoping this would print out the product line
    public  String  getSound(){
        String sound = "";
        switch (this.type) {
            case "Chip":
                sound = "Crunch Crunch, Yum!";
                break;
            case "Candy":
                sound = "Munch Munch, Yum!";
                break;
            case "Gum":
                sound = "Chew Chew, Yum!";
                break;
            case "Drink":
                sound = "Glug Glug, Yum!";
                break;
            default:
                throw new IllegalArgumentException("Unsupported type: " + this.type);
        }
        return sound;
    }

}



