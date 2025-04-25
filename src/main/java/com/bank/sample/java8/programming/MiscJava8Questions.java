package com.interview5.practice.ProgrammingQA;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MiscJava8Questions {

//	1. write a code to find duplicate elements from a given list. List<integer> intLis = List.of(1,2,3,4,5,6,2,4,9);
//	2. wirte a code to merge 2 arrays to single array using java8.
//	3. join a list<Integer> using ** delimeter.
//	4. wirte a code to print all prime numbers from 1 to 100.
//	============== ***** ========== questions below are from concept of java for today website.
//	5. write a program to separate even and odd numbers in a given integer list.
//	6. How do you remove duplicate elements from a list using Java 8 streams
//	7. How do you find frequency of each element in an array or a list?
//	8. How do you sort the given list of decimals in reverse order?
//	9. Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
//	10. From the given list of integers, print the numbers which are multiples of 5?
//	11. Given a list of integers, find maximum and minimum of those numbers?
//	12. How do you merge two unsorted arrays into single sorted array using Java 8 streams?
//	13. How do you get three maximum numbers and three minimum numbers from the given list of integers?
//	14. Java 8 program to check if two strings are anagrams or not?
//	15. Find sum of all digits of a number in Java 8?
//	16. Find second largest number in an integer array?
//	17. Given a list of strings, sort them according to increasing order of their length?
//	18. Given an integer array, find sum and average of all elements?
//	19. How do you find common elements between two arrays?
//	20. Reverse each word of a string using Java 8 streams?
//	21. How do you find sum of first 10 natural numbers?
//	23. Print first 10 even numbers
//	24. How do you find the most repeated element in an array?
//	25. Given a list of strings, find out those strings which start with a number?
//	26. How do you extract duplicate elements from an array?
//	27. Print duplicate characters in a string?
//	28. Find first repeated character in a string?
//	29. Find first non-repeated character in a string?
//	30. First 10 odd numbers
//	31. How do you get last element of an array?
//	32. Find the age of a person in years if the birthday has given?
	
	public static void main(String[] args) {

//		1. write a code to find duplicate elements from a given list. List<integer> intLis = List.of(1,2,3,4,5,6,2,4,9);
//		output should be [2,4]
		List<Integer> intLis = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 9);
		List<Integer> ints = intLis.stream().collect(Collectors.groupingBy(s -> s)).entrySet().stream()
				.sorted(Map.Entry.comparingByKey()).filter(f -> f.getValue().size() > 1).map(s -> s.getKey())
				.collect(Collectors.toList());
		System.out.println(ints);

//		2. wirte a code to merge 2 arrays to single array using java8.
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 6, 7, 8 };

		Stream<Integer> intLis3 = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed());
		System.out.println(intLis3.toList());

//		3. join a list<Integer> using ** delimeter.
		List<String> strLis = intLis.stream().map(s -> s.toString()).toList();
		System.out.println(String.join("**", strLis));

//		4. wirte a code to print all prime numbers from 1 to 100.
		IntStream.rangeClosed(1, 100).filter(f -> f % 2 == 0).forEach(System.out::println);
		System.out.println("==================");

//		5. write a program to separate even and odd numbers in a given integer list.
		List<Integer> intLiss = IntStream.rangeClosed(1, 100).boxed().toList();
		intLiss.stream().collect(Collectors.groupingBy(s -> s % 2 == 0))
				.forEach((k, v) -> System.out.println((k ? "even" : "odd") + "numbers" + v));

//		6. How do you remove duplicate elements from a list using Java 8 streams
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python", "java");
		listOfStrings.stream().collect(Collectors.groupingBy(s -> s)).entrySet().stream()
				.filter(s -> s.getValue().size() == 1).forEach(s -> System.out.println(s.getKey()));
//		in case of numbers,
		List<Integer> intsLis = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5);
		intsLis.stream().distinct().forEach(System.out::println);

//		7. How do you find frequency of each element in an array or a list?
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");
		stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().forEach(System.out::println);

//		8. How do you sort the given list of decimals in reverse order?
		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
		decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

//		9. Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
		List<String> listOfString = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
		System.out.println(listOfString.stream().collect(Collectors.joining(",", "[", "]")));

//		10. From the given list of integers, print the numbers which are multiples of 5?
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		listOfIntegers.stream().filter(f -> f % 5 == 0).forEach(System.out::println);
		System.out.println("===========");

//		11. Given a list of integers, find maximum and minimum of those numbers?
		List<Integer> listOfInteger = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		System.out.println(listOfInteger.stream().reduce((a, b) -> a > b ? a : b).get());
		System.out.println(listOfInteger.stream().reduce((a, b) -> a < b ? a : b).get());
//		to find 2nd Highest no
		System.out.println(listOfInteger.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
//		to find 2nd lowest no
		System.out.println(listOfInteger.stream().sorted().skip(1).findFirst().get());
		System.out.println("=================");

//		12. How do you merge two unsorted arrays into single sorted array using Java 8 streams?
		int[] a = new int[] { 4, 2, 7, 1, 7 };
		int[] b = new int[] { 8, 3, 9, 5, 8 };

		Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().forEach(System.out::println);
		System.out.println("==============");
//      How do you merge two unsorted arrays into single sorted array without duplicates?
		Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed()).sorted().distinct()
				.forEach(System.out::println);
		System.out.println("===============");
//		13. How do you get three maximum numbers and three minimum numbers from the given list of integers?
		List<Integer> listOfIntege = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//		max 3 no's
		listOfIntege.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		System.out.println("max and min :: max 3 above and min 3 below.");
//		min 3 no's
		listOfIntege.stream().sorted().limit(3).forEach(System.out::println);

//		14. Java 8 program to check if two strings are anagrams or not?  (anagram meaning 2 strings if words are suffeled, 1. each letter repeats only once, 2. size should be equal.
		String s1 = "RaceCar";
		String s2 = "CarRace";

		s1 = Stream.of(s1.toLowerCase().split("")).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.toLowerCase().split("")).sorted().collect(Collectors.joining());

		System.out.println(s1.equalsIgnoreCase(s2) ? "both are same meaning given strings are anagrams"
				: "both are not same meaning given strings are not anagrams");

//      15. Find sum of all digits of a number in Java 8?
		int i = 15623;
		System.out.println(
				Stream.of(String.valueOf(i).split("")).collect(Collectors.summarizingInt(Integer::parseInt)).getSum());

//		16. Find second largest number in an integer array?
		List<Integer> listOfInteg = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		System.out.println(listOfInteg.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

//		17. Given a list of strings, sort them according to increasing order of their length?
		List<String> listOfStrin = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
//		if we want value as arrays inside list.
		listOfStrin.stream().collect(Collectors.groupingBy(s -> s.length())).entrySet().stream().map(s -> s.getValue())
				.collect(Collectors.toList()).forEach(System.out::println);
//		if we want values in a single list.
		listOfStrin.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

//		18. Given an integer array, find sum and average of all elements?
		int[] c = new int[] { 45, 12, 56, 15, 24, 75, 31, 89 };
		int sum = Arrays.stream(c).sum();
		System.out.println(sum);
		double avg = Arrays.stream(c).average().getAsDouble();
		System.out.println(avg);
		System.out.println("=================");

//		19. How do you find common elements between two arrays?
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
		List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
		list1.stream().filter(list2::contains).forEach(System.out::println);

//      20. Reverse each word of a string using Java 8 streams?
		String str = "Java Concept Of The Day";
		String reversedStr = Arrays.stream(str.split(" ")).map(m -> new StringBuilder(m).reverse())
				.collect(Collectors.joining(" "));
		System.out.println(reversedStr);

//      21. How do you find sum of first 10 natural numbers?
		System.out.println(IntStream.rangeClosed(1, 10).reduce(0, (g, h) -> g + h));
//        can also be done like this.
		System.out.println(IntStream.rangeClosed(1, 10).sum());

//      22. Reverse an integer array without sorting
		int[] array = new int[] { 5, 1, 7, 3, 9, 6 };
		int[] reversedArray = IntStream.rangeClosed(1, array.length).map(j -> array[array.length - j]).toArray();
		System.out.println(Arrays.toString(reversedArray));

//        in case we can convert and give O/P as list.
		List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList()); // Converted int[] to
																								// List<Integer>
		Collections.reverse(arrayList);
		System.out.println(arrayList);

//		23. Print first 10 even numbers
		IntStream.rangeClosed(1, 20).filter(f -> f % 2 == 0).forEach(System.out::println);

//      24. How do you find the most repeated element in an array?
		List<String> listOfStrins = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book",
				"Pencil");

		String mostRepeated = listOfStrins.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() > 1).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst()
				.get().getKey();
		System.out.println(mostRepeated);

//		25. Palindrome program using Java 8 streams
		String palindrome = "ROTATOR";
		String reversedSt = Arrays.stream(palindrome.toUpperCase().split("")).map(m -> new StringBuilder(m).reverse())
				.collect(Collectors.joining());

		if (palindrome.equalsIgnoreCase(reversedSt)) {
			System.out.println("hey this is palindrome");
		}

//		25. Given a list of strings, find out those strings which start with a number?
		List<String> listOfStrig = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		listOfStrig.stream().filter(f -> Character.isDigit(f.charAt(0))).forEach(System.out::println);

//		26. How do you extract duplicate elements from an array?
		List<Integer> listOfInters = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		listOfInters.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().filter(f -> f.getValue() > 1).forEach(s -> System.out.println(s.getKey()));

//		27. Print duplicate characters in a string?
		String inputString = "Java Concept Of The Day";
		Arrays.stream(inputString.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).filter(f -> f.getValue() > 1)
				.map(m -> m.getKey()).forEach(System.out::println);
		System.out.println("=================");

//		28. Find first repeated character in a string?
		String cahrFirstRep = Arrays.stream(inputString.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() > 1).findFirst().get().getKey();
		System.out.println(cahrFirstRep);

//		29. Find first non-repeated character in a string?
		String firstNonRepearChar = Arrays.stream(inputString.toLowerCase().replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(f -> f.getValue() == 1).findFirst().get().getKey();
		System.out.println(firstNonRepearChar);
		
//		30. First 10 odd numbers
		IntStream.rangeClosed(1, 20).filter(f -> f%2!=0).forEach(System.out::println);
		
//		31. How do you get last element of an array?
		List<String> listOfStngs = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
		String lastElement= listOfStngs.stream().skip(listOfStngs.size()-1).findFirst().get();
		System.out.println(lastElement);
		
//		32. Find the age of a person in years if the birthday has given?
		LocalDate localDt = LocalDate.of(1996, 5, 5);
		LocalDate todayDt = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(localDt, todayDt));
	}
}
