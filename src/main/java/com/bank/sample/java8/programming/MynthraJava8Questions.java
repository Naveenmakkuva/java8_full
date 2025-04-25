package com.bank.sample.java8.programming;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.Payload;
import lombok.Data;
import lombok.ToString;

public class MynthraJava8Questions {

//	1. write a java program to find the nth highest salary using java8 stream api.

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

	static class empService {
		List<Employee> getEmployee() {
			List<Employee> empLis = new ArrayList<>();
			for (int i = 0; i <= 10; i++) {
				Employee emp = new Employee(i, "emp" + i, new Random().nextDouble(1000 * 100));
				empLis.add(emp);
			}
			System.out.println(empLis);
			return empLis;
		}
	}

	public static void main(String[] args) {

//		1. write a java program to find the nth highest salary using java8 stream api.
		empService emps = new empService();
		Double sal = emps.getEmployee().stream().map(Employee::getSalary).reduce((a,b) -> a>b?a:b).get().doubleValue();
		System.out.println(sal);
	}
}
