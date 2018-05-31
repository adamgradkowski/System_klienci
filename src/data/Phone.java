package data;

public class Phone extends Service{
	private String sms;
	private String connect;

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}
	
	public Phone(int id, String name, double price, String sms, String connect) {
		super(id, name, price);
		this.setSms(sms);
		this.setConnect(connect);
	}

	@Override
	public String toString() {
		return "Phone [getSms()=" + getSms() + ", getConnect()=" + getConnect() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((connect == null) ? 0 : connect.hashCode());
		result = prime * result + ((sms == null) ? 0 : sms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (connect == null) {
			if (other.connect != null)
				return false;
		} else if (!connect.equals(other.connect))
			return false;
		if (sms == null) {
			if (other.sms != null)
				return false;
		} else if (!sms.equals(other.sms))
			return false;
		return true;
	}
	
}
