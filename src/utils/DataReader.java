package utils;

import data.Customer;
import java.util.Scanner;

public class DataReader {
	private Scanner sc;

	public DataReader() {
		sc = new Scanner(System.in);
	}

	public void close() {
		sc.close();
	}

	public Customer readAndCreateBook() {
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
		
		return new Customer(id, name, subname, pesel, MSISDN);
	}
}
