package com.bank.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

public class StreamsMapFlatMap {

	/*
	 * Map takes stream as input and provides another stream as output. so its
	 * called one to one mapping example of Map strLis = ["a","b","c","d"]; --> we
	 * want to transform data to uppercase like ["A","B","C","D"]
	 */
	/*
	 * Flatmap takes stream of stream as input and provides a single stream with
	 * data flattened as output so its called one to many mapping. Example for
	 * flatmap: we have multiple arrays of an array. FlatMap map =
	 * [[1,2],[3,4],[5,6]] --> flattening to single array like [1,2,3,4,5,6]
	 */
	@Data
	static class Customer {
		Integer id;
		String name;
		String email;
		List<String> poneNumbers;

		public Customer(Integer id, String name, String email, List<String> poneNumbers) {
			this.id = id;
			this.name = name;
			this.email = email;
			this.poneNumbers = poneNumbers;
		}

	}

	public static void main(String[] args) {
		
		List<Customer> custLis =  Arrays.asList(new Customer(1, "Naveen", "naveen.makkuva@gmail.com", Arrays.asList("9154242678")),
				new Customer(2, "Harish", "harish.makkuva@gmail.com", Arrays.asList("8121205196")),
				new Customer(3, "Appaji", "appaji.makkuva@gmail.com", Arrays.asList("7729880255")),
				new Customer(4, "Rajeswari", "rajeswari.makkuva@gmail.com", Arrays.asList("8125710696")));
		
		
//		List<Customer> to List<String> data transformation using map.
//		mapping logic : from customer -> getEmail and create a separate list.
//		one customer having one email. so one to one mapping.
//		our map takes only stream of (array of) values as input and gives single list as o/p.
		List<String> emailLis = custLis.stream().map(c -> c.getEmail()).collect(Collectors.toList());
		System.out.println(emailLis);
		
//		we have array of phone no for one customer ie: one customer many phone nos (one to many).. so we need to use flat map to get single list.
//		return type is List<List<String>> but we want as List<String> single list. so we need to use flatmap.
		
		List<List<String>> phoneNoArray = custLis.stream().map(c -> c.getPoneNumbers()).collect(Collectors.toList());
		System.out.println(phoneNoArray);
		
//		using flatmap for one to many relations  flat map takes stream of stream (array of array) as input so given stream of phoneNos as i/p and we get phone no lis as o/p.
		List<String> phoneNoLis = custLis.stream().flatMap(c -> c.getPoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(phoneNoLis);
	}

}
