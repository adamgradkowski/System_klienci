package data;

public class SOHOCustomer extends Customer {
	private static final long serialVersionUID = 2061400934707882805L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nip == null) ? 0 : nip.hashCode());
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
		SOHOCustomer other = (SOHOCustomer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nip == null) {
			if (other.nip != null)
				return false;
		} else if (!nip.equals(other.nip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder print = new StringBuilder(32);
		print.append(getIdCustomer());
		print.append("; ");
		print.append(getName());
		print.append("; ");
		print.append(getNip());
		print.append("; ");
		print.append(getMSISDN());
		return print.toString();
	}

}
