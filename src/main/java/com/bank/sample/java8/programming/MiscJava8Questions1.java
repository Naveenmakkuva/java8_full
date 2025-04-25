package com.interview5.practice.ProgrammingQA;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.ToString;

public class MiscJava8Questions1 {
//	1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
//	2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
//	3. How to find duplicate elements in a given integers list in java using Stream functions?
//	4. Given the list of integers, find the first element of the list using Stream functions?
//	5. Given a list of integers, find the total number of elements present in the list using Stream functions?
//	6. Given a list of integers, find the maximum value element present in it using Stream functions?
//	7. Given a String, find the first non-repeated character in it using Stream functions?
//	8. Given a String, find the first repeated character in it using Stream functions?
//	9. Given a list of integers, sort all the values present in it using Stream functions?
//	10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
//	11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//	12. How will you get the current date and time using Java 8 Date and Time API?
//	13. Write a Java 8 program to concatenate two Streams?
//	14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
//	15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
//	16. How to use map to convert object into Uppercase in Java 8?
//	17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
//	18. How to count each element/word from the String ArrayList in Java8?
//	19. How to find only duplicate elements with its count from the String ArrayList in Java8?
//	20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
//	21. Write a Program to find the Maximum element in an array?
//	22. Write a program to print the count of each character in a String?
	
	@Data
	@ToString
	static class Notes{
		int id;
		String name;
		int pages;
		public Notes(int id, String name, int pages) {
			this.id = id;
			this.name = name;
			this.pages = pages;
		}
		
	}

	public static void main(String[] args) {
//		1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
		List<Integer> intLis = Arrays.asList(1, 2, 3, 4, 5, 11, 12, 13, 15, 16, 16, 16);
		System.out.println(intLis.stream().filter(f -> f % 2 == 0).collect(Collectors.toList()));
		int[] intArr = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.stream(intArr).boxed().filter(f -> f % 2 == 0).collect(Collectors.toList()));

//		2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		System.out.println(
				intLis.stream().map(m -> m.toString()).filter(s -> s.startsWith("1")).collect(Collectors.toList()));
//		3. How to find duplicate elements in a given integers list in java using Stream functions?
		System.out.println(intLis.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() > 1).collect(Collectors.toList()));
//		4. Given the list of integers, find the first element of the list using Stream functions?
		System.out.println(intLis.stream().findFirst().get());
//		5. Given a list of integers, find the total number of elements present in the list using Stream functions?
		System.out.println(intLis.stream().count());
//		6. Given a list of integers, find the maximum value element present in it using Stream functions?
		System.out.println(intLis.stream().max(Integer::compare).get());
		System.out.println(intLis.stream().reduce((a, b) -> a > b ? a : b).get());
//		7. Given a String, find the first non-repeated character in it using Stream functions?
		String str = "java Techiee";
		String s = Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() == 1).findFirst().get().getKey();
		System.out.println(s);

//		8. Given a String, find the first repeated character in it using Stream functions?
		String t = Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() > 1).findFirst().get().getKey();
		System.out.println(t);

//		9. Given a list of integers, sort all the values present in it using Stream functions?
		System.out.println(intLis.stream().sorted().collect(Collectors.toList()));

//		10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
		System.out.println(intLis.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
//		11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
		System.out.println(intLis.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().map(m -> m.getValue()).anyMatch(c -> c > 1));
//		12. How will you get the current date and time using Java 8 Date and Time API?
		LocalDate ld = LocalDate.of(1996, 05, 05);
		System.out.println(ld);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		long Years = ChronoUnit.YEARS.between(ld, ldt);
		System.out.println(Years);
		long months = ChronoUnit.MONTHS.between(ld, ldt);
		System.out.println(months);
//		13. Write a Java 8 program to concatenate two Streams?
		List<Integer> intLis1 = Arrays.asList(9,8,7,6,5);
		Stream<Integer> intLis2 = Stream.concat(intLis.stream(), intLis1.stream());
//		converting stream<integer> to List<Integer>
		System.out.println(intLis2.collect(Collectors.toList()));
//		14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
		System.out.println(intLis.stream().map(f -> f*f*f).collect(Collectors.toList()));
//		15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
		intLis.stream().sorted().forEach(System.out::println);
//		16. How to use map to convert object into Uppercase in Java 8?
		List<String> strLis = Arrays.asList("test","down","your","skills");
		System.out.println(strLis.stream().map(String::toUpperCase).collect(Collectors.toList()));
		
//		17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
		List<Notes> noteLst = new ArrayList<>();
	    noteLst.add(new Notes(1, "note1", 11));
	    noteLst.add(new Notes(2, "note2", 22));
	    noteLst.add(new Notes(3, "note3", 33));
	    noteLst.add(new Notes(4, "note4", 44));
	    noteLst.add(new Notes(5, "note5", 55));
	    noteLst.add(new Notes(6, "note4", 66));
	   
		noteLst.stream().sorted(Comparator.comparing(Notes::getName))
				.collect(Collectors.groupingBy(Notes::getName, LinkedHashMap::new,
						Collectors.mapping(Notes::getName, Collectors.toList())))
				.entrySet().stream().forEach(System.out::println);	
		
		noteLst.stream().sorted(Comparator.comparing(Notes::getName))
		.collect(Collectors.groupingBy(Notes::getName,Collectors.toList()))
		.entrySet().stream().forEach(System.out::println);	
		
		
//		18. How to count each element/word from the String ArrayList in Java8?
	    strLis.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().forEach(System.out::println);
//		19. How to find only duplicate elements with its count from the String ArrayList in Java8?
	    strLis.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(f -> f.getValue()>1).forEach(System.out::println);
//		20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
	    List<String> strLis1 = Arrays.asList();
	    Stream.ofNullable(strLis1).forEach(System.out::println);
//		21. Write a Program to find the Maximum element in an array?
	    System.out.println(intLis.stream().max(Integer::compare));
//		22. Write a program to print the count of each character in a String?
		Arrays.stream(str.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.forEach(r -> System.out.println(r.getKey() + ":" + r.getValue()));
	}
}
