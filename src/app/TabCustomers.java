package app;
import data.Customer;

public class TabCustomers {

	public static void main(String[] args) {
		final String appName= "Aplication vol1";
		
		
		Customer[] customers = new Customer[100];
		customers[0] = new Customer(1, "Adam", "Gradkowski", "94021615734", "798197372");
		customers[1] = new Customer(2, "Marek", "Dybis", "93083738484", "877654311");
		customers[2] = new Customer(3, "Jerzy", "Roszkowski", "89133738292", "576874632");
		System.out.println(appName);
		customers[0].printInfo();
		customers[1].printInfo();
		customers[2].printInfo();

	}

}
