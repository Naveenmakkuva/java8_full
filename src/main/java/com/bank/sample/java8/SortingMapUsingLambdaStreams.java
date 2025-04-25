package com.bank.sample.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.bank.sample.java8.SortingListUsingLambdaStream.Employee;

import java.util.TreeMap;

import lombok.Data;
import lombok.ToString;

public class SortingMapUsingLambdaStreams {

//	In traditional way, if we want to sort a map we can use Treemap declaraion inseted of Hashmap declaration.

//	custom logic begins ============

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

//	cusotm logic ends ===========

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("paintCost", 200);
		map.put("dentingCost", 100);
		map.put("repairCost", 1000);
		map.put("finishingCost", 600);

//		Traditional way is using Collections.List but this expects always list as input. so we need co convert Map to list using entryset.
		List<Entry<String, Integer>> mapLis = new ArrayList<>(map.entrySet());

//		Using lambda expression.
		Collections.sort(mapLis, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
//		System.out.println(mapLis);

//		using streams No NEED oF Converting to list from map. directly we can do.  *********
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(s -> System.out.println(s));
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(s -> System.out.println(s));

//		Here we can directly pass expression inside tree map method.
//		***** for comparator if we are using int to compare we should use o2.get() - o2.get()... if we are using Stirng, we should use o1.get().compareTo(o2.get())
//		TraditionalWay
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> o1.getSalary() - o2.getSalary());
		employeeMap.put(new Employee(201, "Appaji", "Marketing", 2000000), 15);
		employeeMap.put(new Employee(203, "Rajeswari", "Quality", 1500000), 20);
		employeeMap.put(new Employee(209, "Harish", "Sales", 1000000), 30);
		employeeMap.put(new Employee(212, "Naveen", "Productions", 800000), 35);
//		System.out.println(employeeMap);

//		using streams with method ref.
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
				.forEach(System.out::println); // ASC

		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed()))
				.forEach(System.out::println); // Desc
		
//		with value
		System.out.println("***********");
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

	}
}
