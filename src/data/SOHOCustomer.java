package data;

public class SOHOCustomer extends Customer{
	private String name;
	private String nip;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}
	
	public SOHOCustomer(int id, String name, String nip, String MSISDN) {
		super(id, MSISDN);
		this.setName(name);
		this.setNip(nip);
	}
	
	public void printInfo() {
		String info = getIdCustomer() + getName() + getNip() + getMSISDN();
		System.out.println(info);
	}
}
