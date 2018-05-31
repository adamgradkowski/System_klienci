package utils;

import java.util.Collection;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;

public class TabUtils {

	public static void printCustomerIndividual(TabCustomers tabcust) {
		/* Customer[] cust = tabcust.getCustomers(); */
		Collection<Customer> customers = tabcust.getCustomers().values();
		int countIndividual = 0;
		for (Customer c : customers) {
			if (c instanceof IndividualCustomer) {
				System.out.println(c);
				countIndividual++;
			}
		}

		if (countIndividual == 0) {
			System.out.println("Brak klientów indywidualnych");
		}
	}

	public static void printCustomerSOHO(TabCustomers tabcust) {
		Collection<Customer> customers = tabcust.getCustomers().values();
		int countSOHO = 0;
		for (Customer c : customers) {
			if (c instanceof SOHOCustomer) {
				System.out.println(c);
				countSOHO++;
			}
		}

		if (countSOHO == 0) {
			System.out.println("Brak klientów indywidualnych");
		}

	}
}
