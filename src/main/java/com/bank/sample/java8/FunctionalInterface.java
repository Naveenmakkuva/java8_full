package com.bank.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
//	1. Consumer Interface demo.
//	Consumer (generally has void accept()) consumes o/p but doesn't provide any op. ex: forEach.
//	Traditional way of using consumer.
	class ConsumerDemo implements Consumer<Integer> {

		@Override
		public void accept(Integer t) {
			System.out.println("Accept consumer input :: " + t);
		}

	}

//	2.Predicate Interface Demo.
//	Used for conditional Checks. having internal method as test(T t);
//	Common example in java 8 is filter(). this uses predicate inteface internally.

//	TraditionalWay
	class PredicateDemo implements Predicate<Integer> {

		@Override
		public boolean test(Integer t) {
			if (t % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}

	}

//	using java 8 lambda
	class PredicateDem {
		Predicate<Integer> predInt = (t) -> {
			if (t % 2 == 0) {
				return true;
			} else {
				return false;
			}
		};
	}
	
//	3. Supplier Interface. The one which gives o/p regardless of any input present or not.
//	Traditional way.
//	Generally used in filter when we dont have any data and we want to give any generalised output.
	class SupplierDemo implements Supplier<String>{

	@Override
	public String get() {
		return "Hey Naveen called supplier interface successfully";
	}
		
	}
	
	class SupplierDem {
		Supplier<String> sup = () -> "Hey naveen called supplier interface successfully without implements";
	}

	public static void main(String[] args) {
//		1. using Java8 lambda
		Consumer<Integer> cons = t -> System.out.println(t);
		cons.accept(10);
//		using forEach
		List<Integer> intLis = Arrays.asList(1, 2, 3, 4, 5);
//		We can use custom forEach like this,
//		intLis.stream().forEach(cons);

//		we can use inBuilt forEach like below using lambda expression since accept method calling internally.
		intLis.stream().forEach(t -> System.out.println(t));

//		2. Predicate examples.
		Predicate<Integer> predInt = t -> t % 2 == 0;
		System.out.println("Testing predicate interface :: " + predInt.test(13));

//		using filter method.
//		We can print like this for customized applicaiton of predicate.
//		intLis.stream().filter(predInt).forEach(t -> System.out.println("printing even :: "+t));

//		we can use like this in general
		intLis.stream().filter(f -> f % 2 == 0)
				.forEach(r -> System.out.println("Printing even in general way :: " + r));
		
//		3. Supplier Interface.
		Supplier<String> sup = () -> "Hey naveen called supplier interface successfully without implements";
		List<String> strLis = Arrays.asList("a","b");
		System.out.println("getting supplier with elemets in list.. "+strLis.stream().findAny().orElseGet(sup));
		
		List<String> strList = Arrays.asList();
		System.out.println("getting supplier withOut elemets in list.. "+strList.stream().findAny().orElseGet(sup));
		
//		generalway with lambda expression.
		strLis.stream().findAny().orElseGet(() -> "used lambda expression to print supplier");
		
	}
}
