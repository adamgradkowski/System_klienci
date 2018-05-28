package data;

import java.io.Serializable;
import java.util.Arrays;

import utils.FileManager;

public class TabCustomers implements Serializable {
	private static final long serialVersionUID = 2995794334600947814L;
	public static final int INITIAL_CAPACITY = 1;
	private Customer[] customers;
	private int customersNumber;
	private FileManager fileManager;

	public Customer[] getCustomers() {
		return customers;
	}

	public int getCustomersNumber() {
		return customersNumber;
	}

	public TabCustomers() {
		customers = new Customer[INITIAL_CAPACITY];
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

	public void addCustomer(Customer cust) throws ArrayIndexOutOfBoundsException {
		if (customersNumber == customers.length) {
			customers = Arrays.copyOf(customers, customers.length * 2);
		}
		customers[customersNumber] = cust;
		customersNumber++;
	}
	
	public void removeCustomers(Customer cust) {
		if (cust == null)
			return;
		
		final int NOT_FOUND = -1;
		int found = NOT_FOUND;
		int i=0;
		while (i <customers.length && found == NOT_FOUND) {
			if (cust.equals(customers[i])) {
				found = i;
			} else {
				i++;
			}
		}
		
		if (found != NOT_FOUND) {
			System.arraycopy(customers, found+1, customers, found, customers.length - found -1);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(32);
		for (int i = 0; i < customersNumber; i++) {
			builder.append(customers[i]);
			builder.append('\n');
		}
		return builder.toString();
	}

	public void printCustomerIndividual() {
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
	}
}