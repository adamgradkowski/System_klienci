package app;

import java.util.NoSuchElementException;

import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;
import data.TabService;
import utils.DataReader;
import utils.FileManager;
import utils.TabUtils;

public class TabControll {

	private DataReader dataReader;
	private FileManager fileManager;
	private TabCustomers tabCustomers;
	private TabService services;

	public TabControll() {
		dataReader = new DataReader();
		fileManager = new FileManager();

		try {
			tabCustomers = fileManager.readCustomersFromFile();
			services = fileManager.readServiceFromFile();
			System.out.println("Wczytano baz� klient�w oraz us�ug");
		} catch (Exception e) {
			tabCustomers = new TabCustomers();
			services = new TabService();
			System.out.println("Utworzono baz� klient�w baz� klient�w oraz us�ug");
			e.printStackTrace();
		}
	}

	private void addCustomerIndividual() {
		IndividualCustomer cust = dataReader.readAndCreateIndividualCustomer();
		tabCustomers.addCustIndividual(cust);
	}

	private void printCustomersIndividual() {
		TabUtils.printCustomerIndividual(tabCustomers);
	}

	private void addSOHO() {
		SOHOCustomer cust = dataReader.readAndCreateSOHOCustomer();
		tabCustomers.addCustSOHO(cust);
	}

	private void printSOHO() {
		TabUtils.printCustomerSOHO(tabCustomers);
	}

	private void printPhone() {
		TabUtils.printPhone(services);
	}

	private void printInternet() {
		TabUtils.printInternet(services);
	}

	private void printTv() {
		TabUtils.printTv(services);
	}

	private void printOptions() {
		System.out.println("WYbierz opcj�: ");
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
			case PHONE:
				printPhone();
				break;
			case INTERNET:
				printInternet();
				break;
			case TV:
				printTv();
				break;
			case EXIT:
				;
			}
			printOptions();
		}
		// zamykamy strumie� wej�cia
		dataReader.close();
	}

	private enum Option {
		EXIT(0, "Wyj�cie z programu"), ADD_INDIVIDUAL(1, "Dodanie klienta indywidualnego"), PRINT_INDIVIDUAL(2,
				"Wy�wietlenie klient�w indywidualnych"), ADD_SOHO(3, "Dodanie klienta biznesowego"), PRINT_SOHO(4,
						"Wy�wielenie klitn�w biznesowych"), PHONE(5,
								"Oferty telefoniczne"), INTERNET(6, "Oferty internetowe"), TV(7, "Oferty telewizyjne");

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
