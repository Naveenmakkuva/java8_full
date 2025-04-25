package com.interview5.practice.ProgrammingQA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.ToString;

public class RealTimeEmployeeExamples {
	
//	1. How many male and female employees are there in the organization?
//	2. Print the name of all departments in the organization?
//	3. What is the average age of male and female employees?
//	4. Get the details of highest paid employee in the organization?
//	5. Get the names of all employees who have joined after 2015?
//	6. Count the number of employees in each department?
//	7. What is the average salary of each department?
//	8. Get the details of youngest male employee in the product development department?
//	9. Who has the most working experience in the organization?
//	10. How many male and female employees are there in the sales and marketing team?
//	11. What is the average salary of male and female employees?
//	12. List down the names of all employees in each department?
//	13. What is the average salary and total salary of the whole organization?
//	14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
//	15. Who is the oldest employee in the organization? What is his age and which department he belongs to?

	@Data
	@ToString
	static class Employee {
		int id;
		String name;
		int age;
		String gender;
		String department;
		int yearOfJoining;
		double salary;

		public Employee(int id, String name, int age, String gender, String department, int yearOfJoining,
				double salary) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.department = department;
			this.yearOfJoining = yearOfJoining;
			this.salary = salary;
		}
	}

	static class EmployeeService {
		public static List<Employee> getEmployeeList() {
			List<Employee> employeeList = new ArrayList<Employee>();
			employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
			employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
			employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
			employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
			employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
			employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
			employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
			employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
			employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
			employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
			employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
			employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
			employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
			employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
			employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
			employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
			employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
			return employeeList;
		}
	}

	public static void main(String[] args) {
		
		List<Employee> empLis = EmployeeService.getEmployeeList();
		
//		1. How many male and female employees are there in the organization?
		List<Entry<String, Long>> empList = empLis.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet().stream()
				.collect(Collectors.toList());
		System.out.println(empList);
		
//		2. Print the name of all departments in the organization?
		empLis.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
//		3. What is the average age of male and female employees?
		double maleEmpDouble = empLis.stream().filter(f -> f.getGender().equalsIgnoreCase("Male")).mapToDouble(Employee::getAge).average().getAsDouble();
		System.out.println(maleEmpDouble);
		System.out.println(empLis.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge))));
		
//		4. Get the details of highest paid employee in the organization?
		List<Employee> emp = empLis.stream().collect(Collectors.groupingBy(Employee::getSalary))
			.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).findFirst().get().getValue();
		System.out.println(emp);
		System.out.println("==================");
		
//		5. Get the names of all employees who have joined after 2015?
		empLis.stream().filter(f -> f.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		
//		6. Count the number of employees in each department?
		empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())).entrySet().stream().forEach(System.out::println);
		System.out.println("=============");
		
//		7. What is the average salary of each department?
		System.out.println(empLis.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))));
		System.out.println("=============");
		
//		8. Get the details of youngest male employee in the product development department?
		Employee youngestEmp = empLis.stream()
								.filter(f -> f.getGender().equalsIgnoreCase("male"))
								.sorted(Comparator.comparing(Employee::getAge))
								.filter(f -> f.getDepartment().equalsIgnoreCase("Product Development"))
								.findFirst().get();
		System.out.println(youngestEmp.getName());
		
//		9. Who has the most working experience in the organization?
		Employee oldestEmpInOrg = empLis.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst().get();
		System.out.println(oldestEmpInOrg.getName());
		
//		10. How many male and female employees are there in the sales and marketing team?
		System.out.println(empLis.stream().filter(f -> f.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
		
//		11. What is the average salary of male and female employees? 
		System.out.println(empLis.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary))));
		System.out.println("======================");
		
//		12. List down the names of all employees in each department?
		empLis.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.mapping(Employee::getName, Collectors.joining(","))))
				.entrySet().stream().forEach(System.out::println);
		
//		13. What is the average salary and total salary of the whole organization?
		double averageSalOfOrg = empLis.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(averageSalOfOrg);
		double totalSalOfOrg = empLis.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum();
		System.out.println(totalSalOfOrg);
		
//		14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		empLis.stream().collect(Collectors.partitioningBy(f -> f.getAge()<25))
			.entrySet().stream().forEach(s -> System.out.println(s.getKey().equals(true)?"younger than 25 :: "+s.getValue():"older than 25 :: "+s.getValue()));
		System.out.println("=================");
		
//		15. Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Employee oldestEmp = empLis.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).findFirst().get();
		System.out.println(oldestEmp);
		
	}
}
