package com.bank.sample.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.ToString;

public class ParallelStreamsAndParallelDataProces {

//	Parallel stream introduces in java8 inorder to achieve a keen improvement in performance in processing of application by utilizing multiple cores of system.
//	However in paraller stream, order (sorting) is not controlled since multiple threads run parallelly.
//	in plain stream, all processing will happen in single core.

//	Real time execution starts

	@Data
	@ToString
	static class Employee {
		int id;
		String name;
		String grade;
		Double salary;

		public Employee(int id, String name, String grade, Double salary) {
			this.id = id;
			this.name = name;
			this.grade = grade;
			this.salary = salary;
		}
	}

//	Real time execution ends

	public static void main(String[] args) {

		Long startTime = (long) 0;
		Long endTime = (long) 0;

		startTime = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		endTime = System.currentTimeMillis();
//		we can see order is followed when used plain stream.
		System.out.println("Time taken by plain stream to process :: " + (endTime - startTime));

		System.out.println("==============");

		startTime = System.currentTimeMillis();
//		1st way of getting parallel stream
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		endTime = System.currentTimeMillis();
//		We can see order is not followed when parallel stream is used.
		System.out.println("Time taken by prallel stream to process :: " + (endTime - startTime));

//		Deep divie look into how processing happening on different threads.

		IntStream.range(1, 10).forEach(s -> {
			System.out.println("Thread using plain stream :: " + Thread.currentThread().getName() + " : " + s);
		});

		IntStream.range(1, 10).parallel().forEach(s -> {
			System.out.println("Thread using parallel stream :: " + Thread.currentThread().getName() + " : " + s);
		});

//		Evaluate average salary of employees using normal stream and parallel stream and give me difference.
//		Creating 1000 employees with different salaries and grades.
		
		List<Employee> empLis = new ArrayList<>();
		for (int i = 1; i <= 1000; i++) {
			empLis.add(new Employee(i, "newEmployee" + i, new Random().nextBoolean() ? "A" : "B",
					Double.valueOf(new Random().nextInt(1000 * 100))));
		}
//		using normal stream.
		startTime = System.currentTimeMillis();
		Double avgSalUsingStream = empLis.stream().map(Employee::getSalary).mapToDouble(s -> s).average().getAsDouble();
		endTime = System.currentTimeMillis();
		System.out.println("average salary got using streams ::"+avgSalUsingStream + "Time taken is :: "+(endTime-startTime));
		
//		Accessing parallel stream using Parallel().
//		startTime = System.currentTimeMillis();
//		Double avgSalUsingParallelStream = empLis.stream().parallel().map(Employee::getSalary).mapToDouble(s -> s).average().getAsDouble();
//		endTime = System.currentTimeMillis();
//		System.out.println("average salary got using parallel streams ::"+avgSalUsingParallelStream + "Time taken is :: "+(endTime-startTime));
		
//		Accessing Parallel stream directly using ParallelStream().
		startTime = System.currentTimeMillis();
		Double avgSalUsingParallelStream = empLis.parallelStream().map(Employee::getSalary).mapToDouble(s -> s).average().getAsDouble();
		endTime = System.currentTimeMillis();
		System.out.println("average salary got using parallel streams ::"+avgSalUsingParallelStream + "Time taken is :: "+(endTime-startTime));
		
	}
}
