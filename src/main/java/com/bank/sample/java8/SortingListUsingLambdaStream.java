package com.bank.sample.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.ToString;

public class SortingListUsingLambdaStream {

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

	public static class EmployeeService {
		List<Employee> empLis = Arrays.asList(new Employee(201, "Appaji", "Marketing", 2000000),
				new Employee(203, "Rajeswari", "Quality", 1500000), new Employee(209, "Harish", "Sales", 1000000),
				new Employee(212, "Naveen", "Productions", 800000));
	}

//	cusotm logic ends ===========

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 10, 22, 12, 25, 5, 6);

//		TraditionalWay of sorting ASCENDING Order.
		Collections.sort(intList);
		System.out.println(intList);

//		traditionalWay of sorting in DESCENDING order.
		Collections.reverse(intList);
		System.out.println(intList);

//		using java8 streams
		intList.stream().sorted(); // Ascending order.
		intList.stream().sorted(Comparator.reverseOrder()); // Descending order.

//		when we want to do sorting using specific field, we can do as below.
//		sorting list<employee> based on salary.

		List<Employee> empLis = Arrays.asList(new Employee(201, "Appaji", "Marketing", 2000000),
				new Employee(203, "Rajeswari", "Quality", 1500000), new Employee(209, "Harish", "Sales", 1000000),
				new Employee(212, "Naveen", "Productions", 800000));

//		TraditionalWay
		Collections.sort(empLis, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// Below is sorting in asc order. if we want to sort in des order, just replace
				// o1 with o2 and o2 with o1.
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		System.out.println("sorted in ASC order using traditional way :: " + empLis);

//		using lambda expression.
		Collections.sort(empLis, (o1, o2) -> o2.getSalary().compareTo(o1.getSalary()));

		System.out.println("sorted in DESC order using traditional way :: " + empLis);
		
//		using streams API
		empLis.stream().sorted((o1,o2) -> o1.getSalary().compareTo(o2.getSalary())).forEach(System.out::println);
		System.out.println("===================");
		
//		using streams in optimized way
		empLis.stream().sorted(Comparator.comparing(s -> s.getSalary())).forEach(System.out::println);
		System.out.println("===================");
		
//		using method references. syntax --> ClassName :: method (get)  ******
		empLis.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);   //Ascending Order
		empLis.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);  //DescendingOrder.
		System.out.println("===================");
		List<Employee> emplist = empLis.stream().sorted(Comparator.comparing(Employee::getDept).reversed()).collect(Collectors.toList());
		System.out.println("employees sorted based on department in DESC order :: "+emplist);

	}
}
