
public class Customer {
	int idCustomer;
	String firstName;
	String lastName;
	String pesel;
	String MSISDN;
	
	public Customer(int id, String f, String l, String p, String M) {
		idCustomer = id;
		firstName = f;
		lastName = l;
		pesel = p;
		MSISDN = M;
	}
	
	void printInfo() {
		String info = idCustomer + "; " + firstName  + "; " + lastName + "; " + pesel + "; " + MSISDN;
		System.out.println(info);
	}
}
