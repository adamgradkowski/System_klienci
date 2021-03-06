package data;

import java.util.List;

public class Customer {
	private int idCustomer;
	private String MSISDN;

	private List<Service> services;

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

	public List<Service> getServices() {
		return services;
	}

	protected Customer(int idCustomer, String MSISDN) {
		this.setIdCustomer(idCustomer);
		this.setMSISDN(MSISDN);
	}
	
	public void addService(Service serv) {
		services.add(serv);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MSISDN == null) ? 0 : MSISDN.hashCode());
		result = prime * result + idCustomer;
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
		Customer other = (Customer) obj;
		if (MSISDN == null) {
			if (other.MSISDN != null)
				return false;
		} else if (!MSISDN.equals(other.MSISDN))
			return false;
		if (idCustomer != other.idCustomer)
			return false;
		return true;
	}

}
