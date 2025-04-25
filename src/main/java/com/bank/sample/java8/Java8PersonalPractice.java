package com.bank.sample.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import lombok.Data;
import lombok.ToString;

public class Java8PersonalPractice {
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

	public static void main(String[] args) {
//		Sorting a List and Map Practice

//		Sorting on a list.
		List<Integer> intLis = Arrays.asList(1, 2, 4, 5, 16, 21, 6);
//		Basic sorting in reversed order.
		intLis.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		List<Employee> empLis = Arrays.asList(new Employee(201, "Appaji", "Marketing", 2000000),
				new Employee(203, "Rajeswari", "Quality", 1500000), new Employee(209, "Harish", "Sales", 1000000),
				new Employee(212, "Naveen", "Productions", 800000));

//		I want to sort based on name of employee
		empLis.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
		System.out.println("====================");

//		I want to sort based on salary in reverse order.
		empLis.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
		System.out.println("====================");

//		I want to sort using lamda expression.
		empLis.stream().sorted(Comparator.comparing(s -> s.getSalary())).forEach(System.out::println);
		System.out.println("====================");

//		I want to sort using comparator lambda expression
		empLis.stream().sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).forEach(System.out::println);
		System.out.println("====================");
//		Filtering a list for slaary > 10 lakhs and then sorting by name in reversed order.
		empLis.stream().filter(f -> f.getSalary() > 1000000).sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
		System.out.println("====================BBB");

//		Sorting using Map.

//		for hashmap.
		Map<String, Integer> map = new HashMap<>();
		map.put("paintCost", 200);
		map.put("dentingCost", 100);
		map.put("repairCost", 1000);
		map.put("finishingCost", 600);

//		General way
		List<Entry<String, Integer>> mapLis = new ArrayList<>(map.entrySet());
		Collections.sort(mapLis, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		System.out.println(mapLis);
		System.out.println("====================");
//		Using Streams.
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("====================");
//		Traditional way of sorting on TreeMap  Sorting based on Name directly from treemap.
		Map<Employee, String> employeeMap = new TreeMap<>((o1, o2) -> o1.getName().compareTo(o2.getName()));
		employeeMap.put(new Employee(201, "Appaji", "Marketing", 2000000), "Test1");
		employeeMap.put(new Employee(203, "Rajeswari", "Quality", 1500000), "Test2");
		employeeMap.put(new Employee(209, "Harish", "Sales", 1000000), "Test3");
		employeeMap.put(new Employee(212, "Naveen", "Productions", 800000), "Test4");

//		Sorting using Streams.
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
				.forEach(System.out::println);
		System.out.println("====================");
//		Sorting using value.
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		System.out.println("====================");
//		Sorting using Key salary in reversed order.
		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
				.forEach(System.out::println);
		System.out.println("====================AAA");
//		using filter by Value ends with letter "4" and then sorting value in asc order.
		employeeMap.entrySet().stream().filter(f -> f.getValue().endsWith("4")).sorted(Map.Entry.comparingByValue())
				.forEach(System.out::println);
		System.out.println("====================AAA");
//		using filter by dept starts with letter "q" and then sorting Key by name in reversed order.
		employeeMap.entrySet().stream().filter(f -> f.getKey().getDept().startsWith("Q"))
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed()))
				.forEach(System.out::println);

	}
}
