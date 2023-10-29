package com.techelevator.view;

import org.apache.log4j.chainsaw.Main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyCounter {
    private double balance = 0.00;
    InventoryMap vendingMachineInventoryMap = new InventoryMap();


    public MoneyCounter(){};
    //Depositing money to machine
    public void addMoney(double input){
        if (input > 0){
            this.balance += input;
        }
    }
    public boolean validatePrice(String itemNumber){
        double price = vendingMachineInventoryMap.getPrice(itemNumber);
        System.out.println("Price: " + String.format("%.2f",price) + ", Balance: " + String.format("%.2f",this.balance));
        return price <= this.balance;
    }
    //Subtracting Balance from item price
    public void subtractPrice(double price){
        this.balance  -= price;
    }
    //Return the balance to the user
    public double getBalance() {
        return this.balance;
    }

    //Need to convert balance to a String for the logger
    public String getBalanceAsString() {
        return "$" + String.format("%.2f", this.balance) + " ";
    }



    /*The machine returns the customer's money using nickels, dimes, and quarters
     Figure out the logic behind this and return as a String for the customer to see*/
    public String userChange() {
        int changeInQuarters = 0;
        int changeInDimes = 0;
        int changeInNickels = 0;
        double printBalance = this.balance;

        changeInQuarters = (int) (this.balance / 0.25);
        System.out.println("Quarter count: " + changeInQuarters);
        this.balance = this.balance - ((double)changeInQuarters * 0.25);

        changeInDimes = (int) (this.balance / 0.10);
        System.out.println("Dime count: " + changeInDimes);
        this.balance = this.balance - ((double)changeInDimes  * 0.10);

        changeInNickels = (int) (this.balance / 0.05);
        System.out.println("nickels count: " + changeInNickels );
        this.balance = this.balance - ((double)changeInNickels * 0.05);
        // reset balance to 0
        this.balance = 0;

        // Create a String to display the user change
        return "\nYour change back is $" + String.format("%.2f", printBalance) + ", " +
                changeInQuarters + " quarter(s), " +
                changeInDimes + " dime(s), and " +
                changeInNickels + " nickel(s).";
    }
}
