package data;

public class IndividualCustomer extends Customer {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndividualCustomer other = (IndividualCustomer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append(getIdCustomer());
		print.append(";");
		print.append(getFirstName());
		print.append(";");
		print.append(getLastName());
		print.append(";");
		print.append(getPesel());
		print.append(";");
		print.append(getMSISDN());
		return print.toString();
	}

}
