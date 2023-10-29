package com.techelevator.view;

import java.io.*;
import java.util.*;

public class InventoryMap {
    private Map<String, Integer> inventorySelection = new HashMap<>();
    private Map<String, Product> productMap = new HashMap<>();

    public Map<String, Integer> getInventorySelection() {
        return inventorySelection;
    }
    public Map<String, Product> getProductMap() {
        return productMap;
    }
    //Importing the csv file to the TreeMap
    public InventoryMap(){
        String filePath = "vendingmachine.csv";
        File inputFile = new File(filePath);

        //Putting in the Item Number and Quantity the vm starts with(5)
        inventorySelection.put("A1", 5);
        inventorySelection.put("A2", 5);
        inventorySelection.put("A3", 5);
        inventorySelection.put("A4", 5);
        inventorySelection.put("B1", 5);
        inventorySelection.put("B2", 5);
        inventorySelection.put("B3", 5);
        inventorySelection.put("B4", 5);
        inventorySelection.put("C1", 5);
        inventorySelection.put("C2", 5);
        inventorySelection.put("C3", 5);
        inventorySelection.put("C4", 5);
        inventorySelection.put("D1", 5);
        inventorySelection.put("D2", 5);
        inventorySelection.put("D3", 5);
        inventorySelection.put("D4", 5);

        try{
            Scanner filescanner = new Scanner(inputFile);
            while (filescanner.hasNextLine()){
                String line = filescanner.nextLine();
                String [] itemInformation = line.split("\\|");
                //From product class split the information in its slot
                String itemNumber = itemInformation[0];
                String name = itemInformation[1];
                double price = Double.parseDouble(itemInformation[2]);
                String type = itemInformation[3];

                Product currentProduct = new Product(name, type, itemNumber, price) {

                    @Override
                    public String getSound() {
                        return super.getSound();
                    }
                };
                productMap.put(itemNumber, currentProduct);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The current file cannot be found");
        }

    }
    //Methods to call and hope it does what i want it too lol
    public double getPrice(String itemNumber){
        return productMap.get(itemNumber).getPrice();
    }

    public int stockCheck (String itemNumber){
        //checking the inventory map to see how much of a quantity is left and showing/removing one from the total
        if (inventorySelection.get(itemNumber) <= 0){
            return 0;
        } else return inventorySelection.get(itemNumber);
    }

    public void reduceStock(String itemNumber){
        if (stockCheck(itemNumber) == 0){
            return;
        } else {
            int currentStock = inventorySelection.get(itemNumber);
            currentStock--;
            //Updating the quantity in the map
            inventorySelection.put(itemNumber, currentStock);
            return;
        }
    }

    public String displayItems(){
        String displayItems = "";

        Set<String> itemKey = inventorySelection.keySet();

        List<String> keyOrder = Arrays.asList(itemKey.toArray(new String[0]));
        keyOrder.sort(null);

        for(int i = 0 ; i < itemKey.size(); i++){
            String key = keyOrder.get(i);
            if (inventorySelection.get(key) > 0 ){
                displayItems += "\n" + productMap.get(key).getItemNumber() +  " " +  productMap.get(key).getName() + " $"+ String.format("%.2f",productMap.get(key).getPrice()) +" " +inventorySelection.get(key);;
            }
        }
        return displayItems;
    }

}
