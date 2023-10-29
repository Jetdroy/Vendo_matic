package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class VendingMachineCLI {

		private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
		private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
		private static final String MAIN_MENU_OPTION_EXIT = "Exit";
		private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
		private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
		private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
		private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
		 private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
		private Menu menu;

		public VendingMachineCLI(Menu menu) {
			this.menu = menu;
		}
		public void run() throws IOException {
		while (true) {
			System.out.println("\nWelcome to the Vendo-Matic 800. Please choose an option below to continue");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				menu.displayStock();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				//menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if(choice2.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
					menu.feedMoney();
				} else if(choice2.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
					menu.productSelection();
				} else if(choice2.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
					menu.finalizeTransaction();
					break;
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				//Should display a goodbye message and close the program
				System.out.println("Thank you for using the vending machine. Have a nice day!");
				break;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	}
