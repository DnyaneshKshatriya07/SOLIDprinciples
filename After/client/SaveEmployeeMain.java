package Gtech.After.client;

import java.io.IOException;
import java.util.List;

import Gtech.After.employees.Employee;
import Gtech.After.loggers.ConsoleLogger;
import Gtech.After.repositories.EmployeeRepository;



public class SaveEmployeeMain {

	public static void main(String[] args) {
		// Grab employees
		EmployeeRepository repository = new EmployeeRepository();
		List<Employee> employees = repository.findAll();

		ConsoleLogger consoleLogger = new ConsoleLogger();

		// Save all
		for (Employee e : employees){
			try {
				repository.save(e);
				consoleLogger.writeInfo("Saved employee " + e.toString());
			} catch (IOException exception) {
				exception.printStackTrace();
				consoleLogger.writeError("Error saving employee", exception);
			}
		}
	}
}