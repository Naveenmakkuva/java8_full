package com.bank.sample.java8.programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MiscQuestionsInternet {
//  1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
//	2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
//	3. How to find duplicate elements in a given integers list in java using Stream functions?
//	4. Given the list of integers, find the first element of the list using Stream functions?
//	5. Given a list of integers, find the total number of elements present in the list using Stream functions?
//	6. Given a list of integers, find the maximum value element present in it using Stream functions?
	
	public static void main(String[] args) {
		
//		1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
		IntStream.rangeClosed(1, 10).filter(s -> s%2==0).forEach(System.out::println);
		
//		2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		List<Integer> intLis = Arrays.asList(1,2,4,5,11,12,14,15,16,17,16);
		System.out.println(intLis.stream().distinct().map(m -> m.toString()).filter(s -> s.startsWith("1")).collect(Collectors.toList()));
		
//		3. How to find duplicate elements in a given integers list in java using Stream functions?
		intLis.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() > 1).forEach(System.out::println);
		
//		4. Given the list of integers, find the first element of the list using Stream functions?
		System.out.println(intLis.stream().findFirst().get());
		
//		5. Given a list of integers, find the total number of elements present in the list using Stream functions?
		Long count = intLis.stream().count();
		System.out.println(count);
		
//		6. Given a list of integers, find the maximum value element present in it using Stream functions?
		Integer largestNo = intLis.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println(largestNo);
	}

}
