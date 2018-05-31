package data;

public class Internet extends Service {
	private String type;
	private double number_MB;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getNumber_MB() {
		return number_MB;
	}

	public void setNumber_MB(double number_MB) {
		this.number_MB = number_MB;
	}
	
	public Internet(int id, String name, double price, String type, double number_mb) {
		super(id, name, price);
		this.setType(type);
		this.setNumber_MB(number_mb);
	}

	@Override
	public String toString() {
		return "Internet [getType()=" + getType() + ", getNumber_MB()=" + getNumber_MB() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(number_MB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Internet other = (Internet) obj;
		if (Double.doubleToLongBits(number_MB) != Double.doubleToLongBits(other.number_MB))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
