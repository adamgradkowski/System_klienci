package app;

public enum Option {
	EXIT(0, "Wyjœcie z programu"), ADD_INDIVIDUAL(1, "Dodanie klienta indywidualnego"), PRINT_INDIVIDUAL(2,
			"Wyœwietlenie klientów indywidualnych"), ADD_SOHO(3,
					"Dodanie klienta biznesowego"), PRINT_SOHO(4, "Wyœwielenie klitnów biznesowych");

	private int value;
	private String description;

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	Option (int value, String desc) {
		this.value = value;
		this.description = desc;
	}
	
	@Override
	public String toString() {
		return value + " - " + description;
	}
	
	public static Option createFromInt(int option) {
		return Option.values()[option];
	}
}
