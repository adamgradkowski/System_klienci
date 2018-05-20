
public class TabCustomers {

	public static void main(String[] args) {
		final String appName= "Aplication vol1";
		
		Customer cust = new Customer();
		cust.idCustomer = 1;
		cust.firstName = "Adam";
		cust.lastName = "Gradkowski";
		cust.pesel = "94021615734";
		cust.MSISDN = "798197372";
		
		System.out.println(appName);
		System.out.println(cust.firstName);
		System.out.println(cust.lastName);
		System.out.println(cust.pesel);
		System.out.println(cust.MSISDN);

	}

}
