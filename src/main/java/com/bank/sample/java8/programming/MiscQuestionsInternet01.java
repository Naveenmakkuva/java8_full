package com.bank.sample.java8.programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MiscQuestionsInternet01 {
//	1. Write a Java 8 program using a lambda expression to add two integers.
//	2. Write a Java 8 program to filter and print even numbers from a list.
//	3. Write a Java 8 program to map integers to their squares and print results.
//	4. Write a Java 8 program to find and print the maximum value from a list.
//	5. Write a Java 8 program to count and print the number of elements in a list.
//	6. Write a Java 8 program to reduce a list of integers to their sum.
//	7. Write a Java 8 program to print the lengths of strings in a list.
//	8. Write a Java 8 program to print distinct elements from a list of integers.
//	9. Write a Java 8 program to print names sorted in alphabetical order from a list.

//	11. Write a Java 8 program to group strings by their lengths and print the groups.
//	12. Write a Java 8 program to collect squares of numbers into a new list.
//	13. Write a Java 8 program to limit and skip elements in a list, then print.
//	14. Write a Java 8 program to find and print the first element in sorted order.

//	16. Write a Java 8 program using flatMap to print characters from lists of strings.
//	7. Write a Java 8 program using peek to print processed elements during a stream operation.
//	write a program to find duplicate elements in a list.
//	GroupBy strings with equal length from list using java8
//	Remove strings form stream contains "an"
//	join each element in list using comma.

	public static void main(String[] args) {
//		1. Write a Java 8 program using a lambda expression to add two integers.
		Integer c = 1;
		Integer d = 2;

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println(add.apply(c, d));

//		2. Write a Java 8 program to filter and print even numbers from a list.
		List<Integer> intLis = Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12,2);
		List<Integer> primeList = intLis.stream().filter(f -> f % 2 == 0).collect(Collectors.toList());
		System.out.println(primeList);

//		3. Write a Java 8 program to map integers to their squares and print results.
		intLis.stream().map(m -> m * m).forEach(System.out::println);

//		4. Write a Java 8 program to find and print the maximum value from a list.
		System.out.println(intLis.stream().reduce((a, b) -> a > b ? a : b).get());
		System.out.println(intLis.stream().max(Integer::compare).get());

//		5. Write a Java 8 program to count and print the number of elements in a list.
		Long count = intLis.stream().count();
		System.out.println(count);

//		6. Write a Java 8 program to reduce a list of integers to their sum.
		System.out.println(intLis.stream().reduce(0, (a, b) -> a + b));

//		7. Write a Java 8 program to print the lengths of strings in a list.
		List<String> strLis = Arrays.asList("map", "reduce", "function","two");
		strLis.stream().forEach(s -> System.out.println(s.length()));

//		8. Write a Java 8 program to print distinct elements from a list of integers.
		intLis.stream().distinct().forEach(System.out::println);

//		9. Write a Java 8 program to print names sorted in alphabetical order from a list.
		strLis.stream().sorted().forEach(System.out::println);

//		11. Write a Java 8 program to group strings by their lengths and print the groups.
		System.out.println(strLis.stream().collect(Collectors.groupingBy(g -> g.length())));

//		12. Write a Java 8 program to collect squares of numbers into a new list.
		System.out.println(intLis.stream().map(m -> m * m).collect(Collectors.toList()));

//		13. Write a Java 8 program to limit and skip elements in a list, then print.
		System.out.println(intLis.stream().skip(1).limit(2).collect(Collectors.toList()));

//		14. Write a Java 8 program to find and print the first element in sorted order.
		System.out.println(intLis.stream().sorted().findFirst().get());

//		16. Write a Java 8 program using flatMap to print characters from lists of strings.
		List<List<String>> strList = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
		System.out.println(strList.stream().flatMap(s -> s.stream()).collect(Collectors.toList()));

//		7. Write a Java 8 program using peek to print processed elements during a stream operation.
		intLis.stream().peek(n -> System.out.println("using peek : " + n)).forEach(System.out::println);

//		//	write a program to find duplicate elements in a list.
		System.out.println(intLis.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() > 1).map(m -> m.getKey()).collect(Collectors.toList()));
		
//		GroupBy strings with equal length from list using java8
		System.out.println(strLis.stream().collect(Collectors.groupingBy(m-> m.length())));
		
//		Remove strings form stream contains "an"
		List<String> strLiss = Arrays.asList("tant","teeth","torant","treent");
		System.out.println(strLiss.stream().filter(f -> !f.contains("an")).collect(Collectors.toList()));
		
//		join each element in list using comma.
		System.out.println(strLis.stream().collect(Collectors.joining(",")));

	}
}
