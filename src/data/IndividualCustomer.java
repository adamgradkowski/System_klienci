package data;

public class IndividualCustomer extends Customer{
	private String firstName;
	private String lastName;
	private String pesel;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public IndividualCustomer(int id, String firstname, String lastname, String pesel, String MSISDN) {
		super(id, MSISDN);
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setPesel(pesel);
		
	}
	public void printInfo() {
		String info = getIdCustomer() + getFirstName() + getLastName() + getPesel() + getMSISDN() ; 
		System.out.println(info);
	}
}
