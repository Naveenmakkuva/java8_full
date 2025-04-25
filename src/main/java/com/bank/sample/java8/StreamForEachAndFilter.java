package com.bank.sample.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.ToString;

public class StreamForEachAndFilter {

//	Stream is used to process collection of data.It doesn't store any data but it can perform various operations on collections that are provided.

//	Example of real time starts Write stream API and filter out employees with sal more than 5 lakhs ======

	@Data
	@ToString
	public static class Employee {
		Integer id;
		String name;
		String dept;
		Integer salary;

		public Employee(Integer id, String name, String dept, Integer salary) {
			this.id = id;
			this.dept = dept;
			this.name = name;
			this.salary = salary;
		}
	}

	public static class EmployeeService {
		List<Employee> empLis = Arrays.asList(new Employee(201, "Appaji", "Marketing", 2000000),
				new Employee(203, "Rajeswari", "Quality", 1500000), new Employee(209, "Harish", "Sales", 1000000),
				new Employee(212, "Naveen", "Productions", 800000));

//		standard way of using ifelse.
		List<Employee> getTaxEligibleEmp(String notation) {
			if (notation.equalsIgnoreCase("tax")) {
				return empLis.stream().filter(f -> f.getSalary() >= 1000000).collect(Collectors.toList());
			} else {
				return empLis.stream().filter(f -> f.getSalary() < 1000000).collect(Collectors.toList());
			}
		}
		
//		using ternary operations.
		List<Employee> getTaxEligibleEmpUsingTernaryOperation(String notation) {
			
			return (notation.equalsIgnoreCase("tax"))
					? empLis.stream().filter(f -> f.getSalary() >= 1000000).collect(Collectors.toList())
					: empLis.stream().filter(f -> f.getSalary() < 1000000).collect(Collectors.toList());

		}
	}

//	Example of real time ends=======

	public static void main(String[] args) {

//		ForEach internally uses consumer interface having abstract method void accept(t t);

//		forEach example with list.
		List<String> intLis = Arrays.asList("Appaji", "Rajeswari", "Harish", "Naveen");
		intLis.stream().forEach(s -> System.out.println(s));

//		filter example (using predicate internally with boolean test (t t)):
		intLis.stream().filter(f -> f.startsWith("R")).forEach(j -> System.out.println("list filter example :: " + j));

//		forEach using map.
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("Appaji", 50);
		maps.put("Rajeswari", 48);
		maps.put("Harish", 31);
		maps.put("Naveen", 28);

//		we can directly use forEach to iterate map as below
		maps.forEach((key, value) -> System.out.println(key + " : " + value));

//		we can use stream api for maps as follows. --> prints whole entry set
		maps.entrySet().stream().forEach((obj) -> System.out.println(obj));

//		Map filter example.
		maps.entrySet().stream().filter(j -> j.getValue() % 2 == 0)
				.forEach(s -> System.out.println("filter in map example :: " + s));

//		Realtime example : Write stream API and filter out employees with sal more than 10 lakhs .
		EmployeeService emps = new EmployeeService();
		System.out.println("employees not eligible for taxation are :: "+emps.getTaxEligibleEmp("Non tax"));
		
//		Realtime ex with ternary operations.
		System.out.println("Using ternary operation, getting emps eligible for taxation "+emps.getTaxEligibleEmpUsingTernaryOperation("tax"));
	}
}
