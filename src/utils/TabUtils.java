package utils;

import java.util.Collection;

import data.Customer;
import data.IndividualCustomer;
import data.Internet;
import data.Phone;
import data.SOHOCustomer;
import data.Service;
import data.TabCustomers;
import data.TabService;
import data.Tv;

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
	
	public static void printPhone(TabService serv) {
		Collection<Service> services = serv.getServices().values();
		int countPhone = 0;
		for (Service s : services) {
			if (s instanceof Phone) {
				System.out.println(s);
				countPhone++;
			}
		}

		if (countPhone == 0) {
			System.out.println("Brak klientów indywidualnych");
		}

	}
	
	public static void printInternet(TabService serv) {
		Collection<Service> services = serv.getServices().values();
		int countInternet = 0;
		for (Service s : services) {
			if (s instanceof Internet) {
				System.out.println(s);
				countInternet++;
			}
		}

		if (countInternet == 0) {
			System.out.println("Brak klientów indywidualnych");
		}

	}
	
	public static void printTv(TabService serv) {
		Collection<Service> services = serv.getServices().values();
		int countTv = 0;
		for (Service s : services) {
			if (s instanceof Tv) {
				System.out.println(s);
				countTv++;
			}
		}

		if (countTv == 0) {
			System.out.println("Brak klientów indywidualnych");
		}

	}
	
}
