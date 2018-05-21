package utils;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;

import java.util.Scanner;

public class DataReader {
	private Scanner sc;

	public DataReader() {
		sc = new Scanner(System.in);
	}

	public void close() {
		sc.close();
	}

	public int getInt() {
		int number = sc.nextInt();
		sc.nextLine();
		return number;
	}

	public IndividualCustomer readAndCreateIndividualCustomer() {
		System.out.println("Podaj id klienta");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Podaj imie klienta");
		String name = sc.nextLine();
		System.out.println("Podaj nazwisko klienta");
		String subname = sc.nextLine();
		System.out.println("Podaj pesel klienta");
		String pesel = sc.nextLine();
		System.out.println("Podaj numeru telefonu klienta");
		String MSISDN = sc.nextLine();

		return new IndividualCustomer(id, name, subname, pesel, MSISDN);
	}

	public SOHOCustomer readAndCreateSOHOCustomer() {
		System.out.println("id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("nazwa: ");
		String name = sc.nextLine();
		System.out.println("nip: ");
		String nip = sc.nextLine();
		System.out.println("numer telefonu");
		String msisdn = sc.nextLine();

		return new SOHOCustomer(id, name, nip, msisdn);
	}
}
