package data;

import java.io.Serializable;

public class TabCustomers implements Serializable{
	private static final long serialVersionUID = 2995794334600947814L;
	public static final int maxCustomers = 2000;
	private Customer[] customers;
	private int customersNumber;

	public Customer[] getCustomers() {
		return customers;
	}

	public int getCustomersNumber() {
		return customersNumber;
	}

	public TabCustomers() {
		customers = new Customer[maxCustomers];
	}

	public void addCustIndividual(IndividualCustomer cust) {
		addCustomer(cust);
	}

	public void addCustSOHO(SOHOCustomer cust) {
		addCustomer(cust);
	}

	public void addCustomer(Customer cust) throws ArrayIndexOutOfBoundsException {
		if (customersNumber < maxCustomers) {
			customers[customersNumber] = cust;
			customersNumber++;
		} else {
			System.out.println("Maxymalna liczba klientów zosta³a osi¹gniêta");
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
			System.out.println("Brak klientów indiwidualnych w tabeli");
		}
	}
}