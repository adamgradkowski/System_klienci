package utils;

import data.Customer;
import data.IndividualCustomer;
import data.SOHOCustomer;
import data.TabCustomers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
	private Scanner sc;

	public DataReader() {
		sc = new Scanner(System.in);
	}

	public void close() {
		sc.close();
	}

	public int getInt() throws NumberFormatException {
		int number = 0;
		try {
			number = sc.nextInt();
		} catch (InputMismatchException e) {
			throw new NumberFormatException("Liczba wprowadzona w niepoprawnej formie");
		} finally {
			sc.nextLine();
		}
		return number;
	}

	public IndividualCustomer readAndCreateIndividualCustomer() throws InputMismatchException{
		int id = TabCustomers.getCustomersNumber() + 1;
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
		int id = TabCustomers.getCustomersNumber() + 1;
		System.out.println("nazwa: ");
		String name = sc.nextLine();
		System.out.println("nip: ");
		String nip = sc.nextLine();
		System.out.println("numer telefonu");
		String msisdn = sc.nextLine();

		return new SOHOCustomer(id, name, nip, msisdn);
	}
}
