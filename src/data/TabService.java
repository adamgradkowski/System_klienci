package data;

import java.util.HashMap;
import java.util.Map;

import utils.FileManager;

public class TabService {
	private Map<String, Service> services;
	private FileManager fileManager;

	public Map<String, Service> getServices() {
		return services;
	}

	public TabService() {
		services = new HashMap<>();
		fileManager = new FileManager();
	}
	
	public void addService(Service serv){
		services.put(serv.getName(), serv);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(32);
		for (Service c: services.values()) {
			builder.append(c);
			builder.append("\n");
		}
		return builder.toString();
	}
}
