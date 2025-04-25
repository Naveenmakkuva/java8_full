package com.bank.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionHandlingJava8 {

//	Approaches 1 - 4 for handling unchecked exceptions.

//	Approach 2 not recomended.
	public static String getException(String s) {
		try {
			System.out.println(Integer.parseInt(s));
		} catch (Exception e) {
			System.out.println("Exception is :: " + e.getMessage());
		}
		return s;
	}

//	3rd approach.but not generic exception hirearchy since its hardcoded for one type of exception.
//	we took consumer since foreach accepts consumer as input.
	static Consumer<String> handleException(Consumer<String> payload) {
		return s -> {
			try {
				payload.accept(s);
			} catch (Exception e) {
				System.out.println("exception is :: " + e.getMessage());
			}
		};
	}

//	Approach 4 --> handles generic exceptions (any kind of execptions).
	static <T, Ex extends Exception> Consumer<T> handleGenericException(Consumer<T> tConsumer, Class<Ex> eClass) {
		return r -> {
			try {
				tConsumer.accept(r);
			} catch (Exception e) {
				try {
//					below inside try block, we are validating weather exception thrown by application is valid or not.
					Ex ex = eClass.cast(e);
					System.out.println("Exception is :: " + ex);
				} catch (Exception exc) {
//					if calss cast exception comes, that means data is wrong. hence throwing main exception.
					throw e;
				}
			}
		};
	}

//	Handling unchecked exeption

	interface MyInterface<Target, Ex extends Exception> {
		void accept(Target target) throws Ex;
	}

	static <Target> Consumer<Target> handleCheckedException(MyInterface<Target, Exception> handleConsumer) {
		return s -> {
			try {
				handleConsumer.accept(s);
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		};
	}

	public static void main(String[] args) {
		List<String> strLis = Arrays.asList("12", "45", "445", "xyz");
//		General approach using streams
//		strLis.stream().map(Integer::parseInt).collect(Collectors.toList());

//		Approach 1 using exception handling. Not recomended while using lambda since its traditional way.
		strLis.forEach(s -> {
			try {
				System.out.println(Integer.parseInt(s));
			} catch (Exception e) {
				System.out.println("Exception is :: " + e.getMessage());
			}
		});

//		Approach 2 not recomended using method ref --> classname.method
		strLis.stream().forEach(ExceptionHandlingJava8::getException);

//		Approch3 but not generic exception hirearchy since its hardcoded for one type of exception.
//		strLis.stream().forEach(handleException(Integer::parseInt));
		strLis.stream().forEach(handleException(s -> System.out.println(Integer.parseInt(s))));

//		Approach 4 handles any exception.
		strLis.stream().forEach(handleGenericException(Integer::parseInt, NumberFormatException.class));

//		Below wont work since expected exceptio is not same as numberformatexception.
//		strLis.stream().forEach(handleGenericException(Integer::parseInt, ArithmeticException.class));
//		if we want to handle arithmatic exception,
		List<Integer> intLis = Arrays.asList(1, 0);
		intLis.stream().forEach(handleGenericException(s -> System.out.println(10 / s), ArithmeticException.class));

//		====================================
		System.out.println("================================");

//		for handling unchecked exceptions

		List<Integer> intLis1 = Arrays.asList(10, 20);
		intLis1.stream().forEach(s -> {
			try {
				Thread.sleep(s);
				System.out.println("Thread slept for this milli seconds :: " + s);
			} catch (InterruptedException e) {
				System.out.println("Exception :: " + e);
			}
		});

//		handling unchecked exception.
		intLis1.stream().forEach(handleCheckedException(s -> {
			Thread.sleep(s);
			System.out.println("thread slept for " + s);
		}));
	}

}
