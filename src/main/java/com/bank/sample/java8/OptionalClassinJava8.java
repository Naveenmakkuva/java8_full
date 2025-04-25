package com.bank.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bank.sample.java8.StreamsMapFlatMap.Customer;

public class OptionalClassinJava8 {
	
//	using otional class in java 8
	
	public static Customer getCustomer(String name) {
		List<Customer> custLis =  Arrays.asList(new Customer(1, "Naveen", "naveen.makkuva@gmail.com", Arrays.asList("9154242678")),
				new Customer(2, "Harish", "harish.makkuva@gmail.com", Arrays.asList("8121205196")),
				new Customer(3, "Appaji", "appaji.makkuva@gmail.com", Arrays.asList("7729880255")),
				new Customer(4, "Rajeswari", "rajeswari.makkuva@gmail.com", Arrays.asList("8125710696")));
		
//		return custLis.stream().filter(f -> f.getName().equalsIgnoreCase("NAVEEN")).findAny().get();
		
		return custLis.stream().filter(f -> f.getName().startsWith("m")).findAny().orElseThrow(() -> new RuntimeException("No customer found with this name."));
	}
	
	public static void main(String[] args) {

//		Following 3 ways to create optional in java 8.

//		1. optionsl.empty() --> returns empty object.
		Optional<Object> opt = Optional.empty();
		System.out.println(opt);

		Customer cust = new Customer(12, "Naveen", null, Arrays.asList("9154242678"));

//		2. Optional.of() --> we use this method when we are sure data wont be null.
//		Below throws null pointer since email is null since we must know data wont be null but here data is coming as null.
//		Optional.of(cust.getEmail());
//		id will be retuned.
		Optional<Integer> opt1 = Optional.of(cust.getId());
		System.out.println(opt1);

//		3. Optional.ofNullable --> we can use when we are not sure that data might come as null.
//		ofNullable is combination of Optional.empty() and Optional.of(). if empty o/p is empty... if not null o/p is given.
//		below sent null data so returned empty.
		Optional<String> opt2 = Optional.ofNullable(cust.getEmail());
		System.out.println(opt2);
		
//		using get() and isPresent() in optional class
		if(opt2.isPresent()) {
			System.out.println(opt2.get());
		}else {
			System.out.println("default@gmail.com");
		}
		
//		optimizing above if else as below. using orElse() generally gives alternative data is no data is present.
		System.out.println(opt2.orElse("default@gmail.com"));
		
//		using orElseThrow()  --> if we want to throw own exception.
//		System.out.println(opt2.orElseThrow(() -> new RuntimeException("No email present")));
		
//	using map in optional
		System.out.println(opt2.map(String::toUpperCase).orElseGet(() -> "default email id..."));
//		data present scenario.
		Optional<String> opt3 = Optional.ofNullable(cust.getName());
		System.out.println(opt3.map(String::toUpperCase).orElseGet(() -> "default email id..."));
		
//		Calling method implements optional in sream.
		System.out.println(getCustomer("Naveen"));
		
//		We can directly apply optional in pojo getter methods. which is recomended.
	}
}
