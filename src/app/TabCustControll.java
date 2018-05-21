package app;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;
import utils.DataReader;

public class TabCustControll {
	public static final int EXIT = 0;
	public static final int ADD_INDIVIDUAL = 1;
	public static final int PRINT_INDIVIDUAL = 2;
	public static final int ADD_SOHO = 3;
	public static final int PRINT_SOHO = 4;

	private DataReader dataReader;
	private TabCustomers tabCustomers;

	public TabCustControll() {
		dataReader = new DataReader();
		tabCustomers = new TabCustomers();
	}

	private void printOption() {
		System.out.println("Wybierz opjce programu");
		System.out.println("0 - Wyjscie z progamu");
		System.out.println("1 - Dodanie nowego klienta individualnego");
		System.out.println("2 - Wyswietlenie wszystkich klientow individualnych");
		System.out.println("1 - Dodanie nowego klienta biznesowego");
		System.out.println("2 - Wyswietlenie wszystkich klientow biznesowych");
	}

	private void addCustomerIndividual() {
		IndividualCustomer cust = dataReader.readAndCreateIndividualCustomer();
		tabCustomers.addCustomerIndividual(cust);
	}

	private void printCustomersIndividual() {
		tabCustomers.printCustomerIndividual();
	}
	
	private void addSOHO() {
		SOHOCustomer cust = dataReader.readAndCreateSOHOCustomer();
		tabCustomers.addCustomerSOHO(cust);
	}

	private void printSOHO() {
		tabCustomers.printCustomerIndividual();
	}

	public void controlLoop() {
		int option;
		printOption();
		while ((option = dataReader.getInt()) != EXIT) {
			switch (option) {
			case ADD_INDIVIDUAL:
				addCustomerIndividual();
				break;
			case PRINT_INDIVIDUAL:
				printCustomersIndividual();
				break;
			case ADD_SOHO:
				addSOHO();
				break;
			case PRINT_SOHO:
				printSOHO();
				break;
			default:
				System.out.println("Nie ma takiej opcji, wprowadŸ ponownie: ");
			}
			printOption();
		}
		// zamykamy strumieñ wejœcia
		dataReader.close();
	}

}
