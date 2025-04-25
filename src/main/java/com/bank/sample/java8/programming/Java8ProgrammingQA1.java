package com.bank.sample.java8.programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ProgrammingQA1 {

//	1. Write a program to count the no of occurances of each char in a given string.
//	2. write a program to find duplicate elements in a given string.
//	3. write a program to find Unique elements in a given string.
//	4. write a java program to find a 1st non repeating element in a given string.
//	5. write a java program to find 2nd highest number from given numbers array.
//	6. write a java program to find longest string in a given string array.
//	7. write a java program to find all elements of an array to find the number starts with 1.
//	8. Reverse a string using java8

	public static void main(String[] args) {
		String str = "Raja Rajeswari Devi";
//		1. Write a program to count the no of occurances of each char in a given string.

		Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // gives as Map (internally
																							// uses hashmap) [i,[i,i]]
				.entrySet().stream().forEach(System.out::println);

		System.out.println("1===================");

//		2. write a program to find duplicate elements in a given string.
		Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() > 1).forEach(s -> System.out.println(s.getKey()));

		System.out.println("2===================");

//		3. write a program to find Unique elements in a given string.

		Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() == 1).forEach(s -> System.out.println(s.getKey()));

		System.out.println("3===================");

//		4. write a java program to find a 1st non repeating element in a given string.
		String str1 = "I Love java techie";
		String nonRepeating = Arrays.stream(str1.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() == 1).findFirst().get().getKey();

		System.out.println(nonRepeating);

		System.out.println("4===================");

//		5. write a java program to find 2nd highest number from given numbers array.
		int[] intLis = { 1, 2, 3, 4, 5, 9, 12, 1213, 999 };

		Integer integer = Arrays.stream(intLis).boxed() // creating wrapped class form int[] to Integer [].
				.sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(integer);

		System.out.println("5====================");

//		6. write a java program to find longest string in a given string array.
		List<String> strLis = Arrays.asList("java", "python", ".net", "muleSoft");
		String longestStr = strLis.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get();
		System.out.println(longestStr);

		System.out.println("5====================");

//		7. write a java program to find all elements of an array to find the number starts with 1.
		List<Integer> intList = Arrays.asList(1, 2, 12, 15, 10, 9, 19, 12, 14, 19);
		List<String> strList = intList.stream().distinct().map(s -> s.toString()).filter(s -> s.startsWith("1"))
				.collect(Collectors.toList());
		System.out.println(strList);

//		8. Reverse a string using java8
		String strs = "Kushwanth and Sriram";
		System.out.println("Actual Stirng :: " + strs);
		String reversed = new StringBuilder(strs).reverse().chars().mapToObj(s -> String.valueOf((char) s))
				.collect(Collectors.joining());
		
		String rev1 = new StringBuilder("naveen kumar").reverse().toString();
		System.out.println(rev1);
		System.out.println("reversed :: " + reversed);

		//		for array of lists.
		strLis.stream().map(s -> new StringBuilder(s).reverse().toString()).forEach(System.out::println);

	}

}
