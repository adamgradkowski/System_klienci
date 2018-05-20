package data;

public class Customer {
	private int idCustomer;
	private String firstName;
	private String lastName;
	private String pesel;
	private String MSISDN;
	
	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

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

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public Customer(int idCustomer, String firstName, String lastName, String pesel, String MSISDN) {
		this.setIdCustomer(idCustomer);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPesel(pesel);
		this.setMSISDN(MSISDN);
	}
	
	public void printInfo() {
		String info = getIdCustomer() + "; " + getFirstName()  + "; " + getLastName() + "; " + getPesel() + "; " + getMSISDN();
		System.out.println(info);
	}
}
