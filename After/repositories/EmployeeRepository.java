package Gtech.After.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import Gtech.After.employees.Employee;
import Gtech.After.employees.FullTimeEmployee;
import Gtech.After.employees.PartTimeEmployee;
import Gtech.After.serializers.EmployeeFileSerializer;

public class EmployeeRepository {

	public List<Employee> findAll(){

		// Employees are kept in memory for simplicity
		Employee anna = new FullTimeEmployee("Anna Smith", 2000);
		Employee billy = new FullTimeEmployee("Billy Leech", 920);

		Employee steve = new PartTimeEmployee("Steve Jones", 800);
		Employee magda = new PartTimeEmployee("Magda Iovan", 920);

		return Arrays.asList(anna, billy, steve, magda);
	}

	public void save(Employee employee) throws IOException{

		EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
		String employeeSerialized = employeeFileSerializer.serialize(employee);

		Path path = Paths.get(employee.getFullName()
				.replace(" ","_") + ".rec");
		Files.write(path, employeeSerialized.getBytes());
	}
}