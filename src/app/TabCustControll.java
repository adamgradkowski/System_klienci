package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;
import utils.DataReader;
import utils.FileManager;

public class TabCustControll {

	private DataReader dataReader;
	private FileManager fileManager;
	private TabCustomers tabCustomers;

	public TabCustControll(){
		dataReader = new DataReader();
		fileManager = new FileManager();
		
		try {
			tabCustomers = fileManager.readCustomersFromFile();
			System.out.println("Wczytano bazê klientów");
		} catch (Exception e) {
			tabCustomers = new TabCustomers();
			System.out.println("Utworzono bazê klientów bazê klientów");
			e.printStackTrace();
		}
	}

	private void addCustomerIndividual() {
		IndividualCustomer cust = dataReader.readAndCreateIndividualCustomer();
		tabCustomers.addCustIndividual(cust);
	}

	private void printCustomersIndividual() {
		tabCustomers.printCustomerIndividual();
	}

	private void addSOHO() {
		SOHOCustomer cust = dataReader.readAndCreateSOHOCustomer();
		tabCustomers.addCustSOHO(cust);
	}

	private void printSOHO() {
		tabCustomers.printCustomerSOHO();
	}

	private void printOptions() {
		System.out.println("WYbierz opcjê: ");
		for (Option o : Option.values()) {
			System.out.println(o);
		}
	}

	public void controlLoop() {
		Option option;
		printOptions();
		while ((option = Option.createFromInt(dataReader.getInt())) != Option.EXIT) {
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
			case EXIT:
				;
			}
			printOptions();
		}
		// zamykamy strumieñ wejœcia
		dataReader.close();
	}

	private enum Option {
		EXIT(0, "Wyjœcie z programu"), ADD_INDIVIDUAL(1, "Dodanie klienta indywidualnego"), PRINT_INDIVIDUAL(2,
				"Wyœwietlenie klientów indywidualnych"), ADD_SOHO(3,
						"Dodanie klienta biznesowego"), PRINT_SOHO(4, "Wyœwielenie klitnów biznesowych");

		private int value;
		private String description;

		Option(int value, String desc) {
			this.value = value;
			this.description = desc;
		}

		@Override
		public String toString() {
			return value + " - " + description;
		}

		public static Option createFromInt(int option) throws NoSuchElementException {
			Option result = null;
			try {
				result = Option.values()[option];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException("Brak elementu o wskazanych ID");
			}
			return result;
		}
	}

}
