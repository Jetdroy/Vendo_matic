package com.techelevator.view;

import java.util.InputMismatchException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
	int currentMoneyProvided = 0;
	InventoryMap vendingMachineInventoryMap = new InventoryMap();
	MoneyCounter drawer = new MoneyCounter();


	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
	//Display Items Menu Option

	public void displayStock() throws IOException {

		System.out.println("This is our varied selection of products: ");
		for (String lines : vendingMachineInventoryMap.displayItems().split("\\n")) {
			System.out.println(lines);
		}
	}

	public Object getChoiceFromOptionsPurchaseMenu(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptionsPurchaseMenu(options);
			choice = getChoiceFromUserInputPurchaseMenu(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInputPurchaseMenu(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptionsPurchaseMenu(Object[] options) {
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();

	}

	public void feedMoney() throws IOException {
		boolean keepFeeding = true;
		int moneyInserted = 0;

			try {
				while (keepFeeding) {
					System.out.println("\nPlease Insert U.S. Dollar Bills( $1, 5, 10, 20)");
					moneyInserted = in.nextInt();

					if (moneyInserted == 1 || moneyInserted == 5 || moneyInserted == 10 || moneyInserted == 20) {
						//startingBalance += moneyInserted;
						drawer.addMoney(moneyInserted);
						System.out.println("Thank You For inserting $" + moneyInserted + ".00." + " You currently have: $" + String.format("%.2f", drawer.getBalance()));
						//add log here
						Logger.log("User added: $" + moneyInserted + " currently has: $" + drawer.getBalance() + " ");
						//Prompt user to see if they want to keep feeding money or break out
						System.out.println("\nDo you want to continue feeding machine? (Yes/No) ");
						in.nextLine();
						keepFeeding = in.nextLine().equalsIgnoreCase("Yes");
					} else {
						System.out.println("Please Insert Valid Currency");

					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Insert Valid Currency");
				Logger.log("An Error Occurred: " + e.getMessage());
			}

	}

	public void productSelection() throws IOException {
		boolean productSelect = true;
		while (productSelect) {

			// Handle selecting a product
			displayStock();
			System.out.println("\nPlease use the ItemID to select the items of purchase(Ex: B3)");
			String slotInput = in.nextLine().toUpperCase();

			//Validating user input
			 if (!vendingMachineInventoryMap.getProductMap().containsKey(slotInput)) {
				//If the user chooses an item outside the scope of the itemlist
				System.out.println("Not a valid choice\n");
				Logger.log("User chose an incorrect input ");
				continue;
			} else {
				if (!drawer.validatePrice(slotInput)) {
					System.out.println("\n Not enough money! \n");
					//log
					Logger.log("User balance is not enough to cover item selected ") ;

					continue;
				} else if (vendingMachineInventoryMap.stockCheck(slotInput) == 0) {
					System.out.println("\n Product is out of stock!");
					//log
					Logger.log(slotInput + " is out of stock ") ;

					continue;
				} else {
					Product product = vendingMachineInventoryMap.getProductMap().get(slotInput);
					drawer.subtractPrice(product.getPrice());
					System.out.println("\nPurchase is successful");
					System.out.println(product.getName() + " Price: $" + String.format("%.2f", product.getPrice()) + " ");
					vendingMachineInventoryMap.reduceStock(product.getItemNumber());
					//Couldn't get classes to inherit correctly. Working on it later
					System.out.println("\n" + product.getSound());
					//Log here
					Logger.log("User successfully selected item " + product.getName() + " we now currently have " + vendingMachineInventoryMap.stockCheck(slotInput) + ". User now has: $" + String.format("%.2f",drawer.getBalance()) + " remaining. ");
					System.out.println("\nDo you want to continue selecting items? (Yes/No) ");
					productSelect = in.nextLine().equalsIgnoreCase("Yes");
				}
			}
		}
	}
	public void finalizeTransaction() throws IOException {

		System.out.println("Here's your change: ");
		Logger.log(drawer.getBalanceAsString());
		String change = drawer.userChange();
		System.out.println(change);
		System.out.println("\nThank you for shopping with the Vendo-Matic 800. Have a nice day");

	}

}