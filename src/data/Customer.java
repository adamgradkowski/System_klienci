package data;

public class Customer {
	private int idCustomer;
	private String MSISDN;

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	protected Customer(int idCustomer, String MSISDN) {
		this.setIdCustomer(idCustomer);
		this.setMSISDN(MSISDN);
	}

	public void printInfo() {
		String info = getIdCustomer() + "; " + "; " + getMSISDN();
		System.out.println(info);
	}
}
