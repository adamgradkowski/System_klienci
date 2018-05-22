package app;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;
import utils.DataReader;

public class TabCustControll {

	private DataReader dataReader;
	private TabCustomers tabCustomers;

	public TabCustControll() {
		dataReader = new DataReader();
		tabCustomers = new TabCustomers();
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
	
	private void printOption() {
		System.out.println("WYbierz opcjê: ");
		for(Option o: Option.values()) {
			System.out.println(o);
		}
	}

	public void controlLoop() {
		Option option;
		printOption();
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
			default:
				System.out.println("Nie ma takiej opcji, wprowadŸ ponownie: ");
			}
			printOption();
		}
		// zamykamy strumieñ wejœcia
		dataReader.close();
	}

}
