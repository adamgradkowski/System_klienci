package data;

public class Tv extends Service {
	private String type_pac;
	private String num_prog;

	public String getType_pac() {
		return type_pac;
	}

	public void setType_pac(String type_pac) {
		this.type_pac = type_pac;
	}

	public String getNum_prog() {
		return num_prog;
	}

	public void setNum_prog(String num_prog) {
		this.num_prog = num_prog;
	}
	
	public Tv(int id, String name, double price, String type_pac, String num_prog) {
		super(id, name, price);
		this.setType_pac(type_pac);
		this.setNum_prog(num_prog);
	}

	@Override
	public String toString() {
		return "Tv [getType_pac()=" + getType_pac() + ", getNum_prog()=" + getNum_prog() + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((num_prog == null) ? 0 : num_prog.hashCode());
		result = prime * result + ((type_pac == null) ? 0 : type_pac.hashCode());
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
		Tv other = (Tv) obj;
		if (num_prog == null) {
			if (other.num_prog != null)
				return false;
		} else if (!num_prog.equals(other.num_prog))
			return false;
		if (type_pac == null) {
			if (other.type_pac != null)
				return false;
		} else if (!type_pac.equals(other.type_pac))
			return false;
		return true;
	}
	
	
}
