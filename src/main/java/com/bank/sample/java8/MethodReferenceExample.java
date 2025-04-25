package com.bank.sample.java8;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MethodReferenceExample {
//	Special type of lambda expressions that executes only one method.
//	syntax : Object::methodName  here object is method reference and methodName is method call.
	
//	ref can be 3 types of method references : 1.static methods ref, 2.Non-static method ref , 3.Constructor ref

	public void m1() {
		System.out.println("nonStatic/instance method");
	}

	public static void m2() {
		System.out.println("static method");
	}

//	Constructor reference.
	@Data
	@ToString
	@NoArgsConstructor
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
		public List<Employee> getEmp() {
			return IntStream.rangeClosed(1, 10)
					.mapToObj(q -> new Employee(q, "Emp" + q, new Random().nextDouble(1000 * 100)))
					.collect(Collectors.toList());
		}
	}
	
	public static void print(Employee employee) {
		System.out.println(employee);
	}
	
//	Instance method or non-static method.
	public void printing(Employee s) {
		System.out.println(s);
	}
	
//	Constructor ref  --> functional interface with abstract method (must have return type).
	interface EmployeeManager{
		public Employee checkMethor();
	}

	public static void main(String[] args) {

//		Traditional way.
		MethodReferenceExample.m2(); // static method so no obj
		MethodReferenceExample mEx = new MethodReferenceExample();
		mEx.m1();		

//		syntax orientated change.  reference :: methodCall.

//		MethodReferenceExample::m2();
//		mEx::m1();

		EmpService empService = new EmpService();
		empService.getEmp().stream().forEach(new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				System.out.println("using anonymous functions " + t);

			}
		});
		
		System.out.println("===================");
		
		empService.getEmp().stream().forEach(s -> System.out.println("using lambda expression "+s));
		System.out.println("===================");
//		Calling static method using method ref
		empService.getEmp().stream().forEach(MethodReferenceExample::print);
		
//		Calling static method using method ref with predefined class
		empService.getEmp().stream().forEach(System.out::println);
		
		
//		Calling instance/non-static method
		MethodReferenceExample methodRefobj = new MethodReferenceExample();
		empService.getEmp().stream().forEach(methodRefobj::printing);
		
//		getting name of each employee
		empService.getEmp().stream().map(Employee::getName).forEach(System.out::println);
//		in above example, we can see both Employee class and getName() are not static but still we able to 
//		call using method ref directly without obj creation to employee class.
//		This is beacuse in java8, functions, what ever method doesn't have any params/Args will be considered as static methods.
		
//		==================
		
//		 constructor ref --> Reference :: new 
//		using lambda exp.
		EmployeeManager emp = () -> new Employee(0, "", 0);
		emp.checkMethor();
		
		EmployeeManager emp1 = Employee::new;  // Must have noArgsCons for this.
		emp1.checkMethor();

	}
}
