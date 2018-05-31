package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import utils.FileManager;

public class TabCustomers{
	private static final long serialVersionUID = 2995794334600947814L;
	public static final int INITIAL_CAPACITY = 1;
	
	private Map<String, Customer> customers;
	/*private Customer[] customers;*/
	private int customersNumber;
	private FileManager fileManager;

	public Map<String, Customer> getCustomers() {
		return customers;
	}

	public int getCustomersNumber() {
		return customersNumber;
	}

	public TabCustomers() {
		customers = new HashMap<>();
		fileManager = new FileManager();
	}

	public void addCustIndividual(IndividualCustomer cust) {
		addCustomer(cust);
		try {
			fileManager.writeCustomersToFile(cust);
		} catch (Exception e) {
			System.out.println("Nie wczytano klienta do pliku");
			e.printStackTrace();
		}
	}

	public void addCustSOHO(SOHOCustomer cust) {
		addCustomer(cust);
		try {
			fileManager.writeCustomersToFile(cust);
		} catch (Exception e) {
			System.out.println("Nie wczytano klienta do pliku");
			e.printStackTrace();
		}
	}

	public void addCustomer(Customer cust){
		customers.put(cust.getMSISDN(), cust);
	}
	
	public void removeCustomers(Customer cust) {
		if(customers.containsValue(cust)) {
			customers.remove(cust.getMSISDN());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(32);
		for (Customer c: customers.values()) {
			builder.append(c);
			builder.append("\n");
		}
		return builder.toString();
	}

	/*public void printCustomerIndividual() {
		int countIndividual = 0;
		for (int i = 0; i < customersNumber; i++) {
			if (customers[i] instanceof IndividualCustomer) {
				System.out.println(customers[i]);
				countIndividual++;
			}
		}
		if (countIndividual == 0) {
			System.out.println("Brak klientów indiwidualnych w tabeli");
		}
	}

	public void printCustomerSOHO() {
		int countSOHO = 0;
		for (int i = 0; i < customersNumber; i++) {
			if (customers[i] instanceof SOHOCustomer) {
				System.out.println(customers[i]);
				countSOHO++;
			}
		}
		if (countSOHO == 0) {
			System.out.println("Brak klientów biznesowych w tabeli");
		}
	}*/
}