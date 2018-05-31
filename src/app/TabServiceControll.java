package app;

import java.util.NoSuchElementException;

import data.Service;
import data.TabCustomers;
import data.TabService;
import utils.DataReader;
import utils.FileManager;
import utils.TabUtils;

	

public class TabServiceControll {
	private TabService services;
	private FileManager fileManager;
	private DataReader dataReader;
	
	public TabServiceControll(){
		dataReader = new DataReader();
		fileManager = new FileManager();
		
		try {
			services = fileManager.readServiceFromFile();
			System.out.println("Wczytano us³ug klientów");
		} catch (Exception e) {
			services = new TabService();
			e.printStackTrace();
		}
	}

	private void printOptions() {
		System.out.println("WYbierz opcjê: ");
		for (Option o : Option.values()) {
			System.out.println(o);
		}
	}
	
	private void printPhone() {
		TabUtils.printPhone(services);
	}
	
	private void printInternet() {
		TabUtils.printInternet(services);
	}
	
	private void printTv() {
		TabUtils.printTv(services);
	}
	
	
	
	public void controlLoop() {
		Option option;
		printOptions();
		while ((option = Option.createFromInt(dataReader.getInt())) != Option.EXIT) {
			switch (option) {
			case PHONE:
				printPhone();
				break;
			case INTERNET:
				printInternet();
				break;
			case TV:
				printTv();
				break;
			case EXIT:
				break;
			}
			printOptions();
		}
		// zamykamy strumieñ wejœcia
		dataReader.close();
	}

	private enum Option {
		PHONE(0, "Oferty telefoniczne"), INTERNET(1, "Oferty internetowe"), TV(2, "Oferty telewizyjne"),EXIT(4, "Wyjœcie z programu");

		private int value;
		private String description;

		Option(int value, String desc) {
			this.value = value;
			this.description = desc;
		}

		@Override
		public String toString() {
			return value + " - " + description;
		}

		public static Option createFromInt(int option) throws NoSuchElementException {
			Option result = null;
			try {
				result = Option.values()[option];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new NoSuchElementException("Brak elementu o wskazanych ID");
			}
			return result;
		}
	}
}
