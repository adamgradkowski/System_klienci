package utils;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;

public class TabUtils {
	
	public void printCustomerIndividual(TabCustomers tabcust) {
		Customer[] cust = tabcust.getCustomers();
		int customersNumber = tabcust.getCustomersNumber();
		int countIndividual = 0;
		for (int i = 0; i < customersNumber; i++) {
			if (cust[i] instanceof IndividualCustomer) {
				System.out.println(cust[i]);
				countIndividual++;
			}
		}
		if (countIndividual == 0) {
			System.out.println("Brak klientów indiwidualnych w tabeli");
		}
	}

	public void printCustomerSOHO(TabCustomers tabcust) {
		Customer[] cust = tabcust.getCustomers();
		int customersNumber = tabcust.getCustomersNumber();
		int countSOHO = 0;
		for (int i = 0; i < customersNumber; i++) {
			if (cust[i] instanceof SOHOCustomer) {
				System.out.println(cust[i]);
				countSOHO++;
			}
		}
		if (countSOHO == 0) {
			System.out.println("Brak klientów indiwidualnych w tabeli");
		}
	}

}
