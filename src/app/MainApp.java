package app;

public class MainApp {

	public static void main(String[] args) {
		final String appName = "Tablica o klientach";
		System.out.println(appName);
		TabCustControll control = new TabCustControll();
		control.controlLoop();

	}

}
