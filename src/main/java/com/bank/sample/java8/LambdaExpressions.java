package com.bank.sample.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

//Functional Interface exmaple
/*annotation is not mandatory but interface must contain single abstract method but can have multiple default and static methods.*/

interface Icalculator {

//	1. simple method
//	void switchOn();

//	2. with one arg
//	void singleArg(String a);

//	3. with return type and 2 args
	int multiply(int a, int b);

}

@Data
@AllArgsConstructor
@ToString
class Book {
	Integer id;
	String name;
	Integer pages;
}

//Below is example of real time compare with name in traditional way

class bookService {

	public List<Book> getSortedByName() {
		List<Book> books = Arrays.asList(new Book(1, "Core Java", 12), new Book(2, "Hibernate", 10),
				new Book(3, "Spring", 5), new Book(4, "WebService", 100));
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});
		return books;
	}
}

// using lambda expression

/*
 * new Comparator<Book>() {
 * 
 * @Override public int compare(Book o1, Book o2) { return
 * o1.getName().compareTo(o2.getName()); }
 * 
 * });
 */

class BookServices {
	public List<Book> getSortedByName() {
		List<Book> books = Arrays.asList(new Book(1, "Core Java", 12), new Book(2, "Hibernate", 10),
				new Book(3, "Spring", 5), new Book(4, "WebService", 100));
//		using labda exp in place of creating new class with comparator (functional interfcae) implementes into that class.
		Collections.sort(books, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return books;
	}
}

public class LambdaExpressions {

//	systax of lambda expression ()  ->  {};     () is parameter, -> is expression ,  {} is body.

//	instead f traditaional way of using implements, using lambda expression, we can represent method into anonymous method.

//	@Override
//	public void switchOn() {
//		// TODO Auto-generated method stub
//		
//	}

	public static void main(String[] args) {
//		1.  representing using lambda exp.
//		Icalculator cal = () -> System.out.println("swithed on");
//		cal.switchOn();

//		2.  with single arg.
//		data/return type of argument "a" is not requred since JDK 8, it will recognize automatically.
//		Icalculator cal = (a) -> System.out.println(a);
//		cal.singleArg("checking single arg");

//		3. with return type and multiple args. "return" declaration is not needed since directly it will return the body.
//		Icalculator cal = (a,b) -> a*b;
//		System.out.println("multiplied result is :: "+cal.multiply(2, 3));

//		3.1  if we have business logic,
//		Icalculator cal = (a,b) -> {
//			if(a > 100 && b > 100) {
//				throw new RuntimeException("Sorry! unable to calculate multiples of nums more than 100");
//			}else {
//				return a*b;
//			}
//		};
//		
//		System.out.println(cal.multiply(1000, 10));

//		calling books method with sorted list by name.

		System.out.println("using Traditional way :: " + new bookService().getSortedByName());
		System.out.println("using lambda expression :: " + new BookServices().getSortedByName());

	}

}
