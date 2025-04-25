package com.bank.sample.java8;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.ToString;

public class MapReduceJava8 {

//	Realtime example : Evaluate employee salary average from grade A.

	@Data
	@ToString
	static class Employee {
		int id;
		String name;
		String grade;
		int salary;

		public Employee(int id, String name, String grade, int salary) {
			this.id = id;
			this.name = name;
			this.grade = grade;
			this.salary = salary;
		}

	}

	public static void main(String[] args) {

		/*
		 * Map -> Transform data 
		 * Reduce -> Aggregate data (combines stream of data and
		 * provides single op). Ex : [1,2,3,4,5] reduce -> combines stream and give sum
		 * as op.
		 * 
		 * 
		 * T reduce (T identity, BinaryFunction<T> accumelator) ex: Integer sumofInt =
		 * Stream.of(1,2,3,4,5).reduce(0, (a,b) -> a+b); o is identity nothing but
		 * starting Value (a,b) -> a+b is accumelator function.
		 */

		List<Integer> intLis = Arrays.asList(1, 2, 4, 5, 6);

//		Traditional way
		Integer sum = 0;
		for (int no : intLis) {
			sum = sum + no;
		}
		System.out.println(sum);

//		using lambda expression
//		mapToInt(n -> n) here we are just getting no to n and mapping no to int.
		int aggregateVal = intLis.stream().mapToInt(n -> n).sum();
		System.out.println(aggregateVal);

//		using reduce().
		int aggValWithReduce = intLis.stream().reduce(0, (a, b) -> a + b);
		System.out.println(aggValWithReduce);

//		using reduce with method ref
		int aggValRedMethod = intLis.stream().reduce(Integer::sum).get();
		System.out.println(aggValRedMethod);

//		multiply
		int multipRes = intLis.stream().reduce(1, (a, b) -> a * b);
		System.out.println(multipRes);

//		max no in array
		int maxNo = intLis.stream().reduce((a, b) -> a > b ? a : b).get();
		System.out.println(maxNo);

//		min no in Array
		int minNo = intLis.stream().reduce((a, b) -> a < b ? a : b).get();
		System.out.println(minNo);

//		using method ref
		int maxMethodRef = intLis.stream().reduce(Integer::max).get();
		System.out.println(maxMethodRef);

//		Max length string
		List<String> words = Arrays.asList("coreJava", "Spring", "Hibernate");

		String maxLengthWord = words.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get();
		System.out.println(maxLengthWord);

//		Realtime : evaluate average sal of employee grade A.
		List<Employee> empLis = Arrays.asList(new Employee(10, "Naveen", "A", 50000),
				new Employee(20, "Harish", "A", 60000), new Employee(30, "Appaji", "B", 40000),
				new Employee(50, "Raji", "C", 35000));

		Double avgSal = empLis.stream()
				.filter(f -> f.getGrade().equalsIgnoreCase("A")) //Filtering emp with grade a
				.map(Employee::getSalary) // getting employee sal
				.mapToDouble(n -> n) // mapping it to double since we want double
				.average() // average value of double mapped salaries.
				.getAsDouble(); // since map gives optional, uses getAsDouble as o/p.
		
		System.out.println(avgSal);
		
//		same example but we want sum of salary
		Integer sumOfSal = empLis.stream()
		.filter(f -> f.getGrade().equalsIgnoreCase("A"))
		.map(Employee::getSalary)
		.reduce(Integer::sum).get();
		
		System.out.println(sumOfSal);
	}

}
