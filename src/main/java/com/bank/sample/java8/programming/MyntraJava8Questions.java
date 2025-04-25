package com.interview5.practice.ProgrammingQA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.ToString;

public class MyntraJava8Questions {

//	1. write a java program to find nth highest salary.

	@Data
	@ToString
	static class Employee {
		int id;
		String name;
		double salary;

		public Employee(int id, String name, double salary) {
			this.id = id;
			this.name = name;
			this.salary = salary;
		}

	}

	static class EmpService {
//		List<Employee> getEmployees() {
//			List<Employee> empLis = new ArrayList<>();
//			for (int i = 0; i <= 5; i++) {
//				empLis.add(new Employee(i, "Employee" + i, new Random().nextDouble(1000 * 100)));
//			}
//			System.out.println(empLis);
//			return empLis;
//		}
		
		List<Employee> getEmployees() {
			List<Employee> empLis = new ArrayList<>();
			empLis.add(new Employee(1, "Naveen", 800));
			empLis.add(new Employee(2, "Kavya", 1000));
			empLis.add(new Employee(3, "Harish", 1200));
			empLis.add(new Employee(4, "Bablu", 1200));
			return empLis;
		}

		Map<String, Integer> getMap() {
			Map<String, Integer> map = new HashMap<>();
			map.put("Kavya", 60000);
			map.put("Naveen", 70000);
			map.put("Harish", 40000);
			map.put("Komali", 60000);
			map.put("abu", 60000);
			return map;
		}

	}

	public static void main(String[] args) {
		EmpService emps = new EmpService();
//		finding highest salary from map.
		Double highestSal = emps.getEmployees().stream().map(Employee::getSalary).reduce((a, b) -> a > b ? a : b).get()
				.doubleValue();
		System.out.println("*******************");		
//		***best approach
		List<String> empsWithSameSalHighest = emps.getEmployees().stream()
				.collect(Collectors.groupingBy(s -> s.getSalary(),
						Collectors.mapping(s -> s.getName(), Collectors.toList())))
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.collect(Collectors.toList()).get(0).getValue();
		System.out.println(empsWithSameSalHighest);
		
//		.entrySet().stream()
//				.sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toList()).get(0);
		
		System.out.println("*******************");
		System.out.println(Math.round(highestSal));

//		Get all emps with second highest salary form map.
//		Getting second highest salary first.
		List<Entry<String, Integer>> intLis = emps.getMap().entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).skip(1).collect(Collectors.toList());

//		got second highest salary value.
		Integer sal = emps.getMap().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.skip(1).findFirst().get().getValue();

//		comparing second highest salary with all employees in map and sorting them.
		intLis.stream().filter(s -> s.getValue().equals(sal)).forEach(System.out::println);
		System.out.println("=============");
		
//		*** Best Approach Get all emps with second highest salary form map.
//		using groupBy()
		emps.getMap().entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue,  // using grouping by, got map as follows : sal=[[emp1=5000,emp2=5000],[emp3=1000],[emp4=700]]
						Collectors.mapping(Map.Entry::getKey, Collectors.toList())))  // asking collectors again to map as follows: [sal=[emp1,emp2],[emp3],[emp4]]
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Collections.reverseOrder())) // since o/p is a map, sorted and made as list and got index 1.
				.collect(Collectors.toList()).get(1);
			

	}

}
