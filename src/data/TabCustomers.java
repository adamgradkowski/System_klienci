package data;

public class TabCustomers {
	public static final int maxINDIVIDUAL = 1000;
	public static final int maxSOHO = 1000;
	private IndividualCustomer[] customersIndividual;
	private SOHOCustomer[] customersSOHO;
	private int numberIndividual;
	private int numberSOHO;

	public IndividualCustomer[] getCustomersIndividual() {
		return customersIndividual;
	}

	public void setCustomersIndividual(IndividualCustomer[] customersIndividual) {
		this.customersIndividual = customersIndividual;
	}

	public SOHOCustomer[] getCustomersSOHO() {
		return customersSOHO;
	}

	public void setCustomersSOHO(SOHOCustomer[] customersSOHO) {
		this.customersSOHO = customersSOHO;
	}

	public TabCustomers() {
		setCustomersIndividual(new IndividualCustomer[maxINDIVIDUAL]);
		setCustomersSOHO(new SOHOCustomer[maxSOHO]);
	}

	public void addCustomerIndividual(IndividualCustomer cust) {
		if (numberIndividual < maxINDIVIDUAL) {
			customersIndividual[numberIndividual] = cust;
			numberIndividual++;
		} else {
			System.out.println("Brak miejsca");
		}
	}

	public void addCustomerSOHO(SOHOCustomer cust) {
		if (numberSOHO < maxSOHO) {
			customersSOHO[numberSOHO] = cust;
			numberSOHO++;
		} else {
			System.out.println("Brak miejsca");
		}
	}

	public void printCustomerIndividual() {
		if (numberIndividual == 0) {
			System.out.println("Brak klientow inywidualnych");
		}
		for (int i = 0; i < numberIndividual; i++) {
			customersIndividual[i].printInfo();
		}
	}
	
	public void printSOHOCustomer() {
		if (numberSOHO == 0) {
			System.out.println("Brak klientow biznesowych");
		}
		for (int i = 0; i < numberSOHO; i++) {
			customersSOHO[i].printInfo();
		}
	}
}