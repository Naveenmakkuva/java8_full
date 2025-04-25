package com.interview5.practice.ProgrammingQA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8ProgrammingQuestions {
	
//	1. write a program to count occurance of each char in given string
//	2. write a java program to find all duplicate elements in a given string.
//	3. write a java program to find first non repeat element in a given string. (ie; what ever char is not repeated and first comes in string)
//	4. write a java program to find 2nd highest number from given numbers array.
//	5. write a java program to find longest string in given string array.
//	6. write a java program to find all elements of an array starts with 1.
	
//	Joins example.
//	limit and skip usecase.
	
	public static void main(String[] args) {
		
//		1. write a program to count occurance of each char in given string
		
//		Question 1 Start ================
		
		String str = "i Love Java Techie";
//		Converting of string to array using split("").
//		String[] res = str.split("");
//		if we want to ignore spaces, we can use replaceAll(" ","");
//		String[] res = str.replace(" ", "").split("");

		System.out.println("======================");
		
//		in single line
		Arrays.stream(str.replaceAll(" ", "").split(""))  // given string replaceAll used to remove spaces, then to create arrays of char present in string.
			.collect(Collectors.groupingBy(s -> s))  // using groupingBy what ever element/char coming into stream, mapping it into a map<key,value> format like [i,[i,i]]
			.entrySet().stream().forEach(g -> System.out.println(g.getKey() + " : " + g.getValue().size()));  // printed obtained o/p.
		
		System.out.println("========================");
//		****** Best Approach
//		alternate way using inbuilt methods in java 8  ** internally uses hashmap checks weather key is present and proceeds.
		Map<String, Long> maps =  Arrays.stream(str.replaceAll(" ", "").split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(maps);
		System.out.println("==============1==============");
//		Question 1 end =================
		
//		Question 2 Start ================
		
//		2. write a java program to find all duplicate elements in a given string. 
		String strs = "I Love Java Techie";
		
		Arrays.stream(strs.toLowerCase().replaceAll(" ", "").split(""))
		.collect(Collectors.groupingBy(g->g))
		.entrySet().stream().filter(s -> s.getValue().size() > 1).forEach(s -> System.out.println(s.getKey()));
		
//		****** Best Approach using internal functions.
		Arrays.stream(str.replaceAll(" ", "").split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() > 1).forEach(System.out::println);
		
//		In case of unique elements in a string,
		Arrays.stream(str.replaceAll(" ", "").split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
		.filter(s -> s.getValue() == 1).map(Map.Entry::getKey).forEach(System.out::println);
		System.out.println("2=============");
//		in case i dont want to use method ref with unique elements.
		Arrays.stream(str.replaceAll(" ", "").split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
		.filter(s -> s.getValue() == 1).forEach(s -> System.out.println("Unique elements :: "+s.getKey()));
		System.out.println("2=====================");
//		Question 2 end ================
		
//		Question 3 Start ================
		
//		3. write a java program to find first non-repeating element in a given string.
//		**we just added linkedHashMap inside groupingBY function specifing stream to use linked hashMap since in hashmap insertion order is not preserved.
		String firstEle = Arrays.stream(strs.toLowerCase().replaceAll(" ","").split(""))
			.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			.entrySet().stream().filter(f -> f.getValue()==1).findFirst().get().getKey();
		System.out.println(firstEle);
		
//		in case we want to find first repeatative cahr
		String repeatedVal = Arrays.stream(strs.toLowerCase().replaceAll(" ", "").split(""))
			.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
			.entrySet().stream().filter(f -> f.getValue()>1).findFirst().get().getKey();
		System.out.println(repeatedVal);
		
		System.out.println("3====================");
		
//		Question 3 end ================
		
//		Question 4 Start ================
		
//		4. write a java program to find 2nd highest number from given numbers array.
		List<Integer> intLis = Arrays.asList(1,2,4,8,5,6,7);
		Integer ints = intLis.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(ints);
		
		int[] intArr = {3,4,5,653,2121,12,213};
//		int[] is not a wrapper class in java. inorder to convert to Integer[] (wrapper class), we use boxed().
		Integer intss = Arrays.stream(intArr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(intss);
		System.out.println("4=================");
//		Question 4 end ================
		
//		Question 5 Start ================
		
//		5. write a java program to find longest string in given string array.
		String[] strArr = {"naveen","amzad","lakshman","hanuman","dinosar"};
		String lengthiestObj = Arrays.stream(strArr).reduce((a,b) -> a.length()>b.length()?a:b).get();
		System.out.println(lengthiestObj);
		System.out.println("5==================");
//		Question 5 end ================
		
//		Question 6 Start ================
		
//		6. write a java program to find all elements of an array starts with 1.
		int[] intAr = {1,22,12,2,15,16,17};
		Arrays.stream(intAr).boxed().map(s -> s.toString()).filter(s -> s.startsWith("1")).forEach(System.out::println);
		System.out.println("6==================");
//		Question 6 end ================
		
//		Joins in java 8 --> used to add delimeter between any String array objects.
//		interview questions. you have an array of integers [1,2,3,4]; you want o/p as 1-2-3-4. then we can use joins.
		List<String> intLi = Arrays.asList("1","2","3","4","5");
		System.out.println(String.join("-", intLi));
		
//		Limit and skip use case. : from aray of 10 elements, give list from 2nd to last but one element.
		List<Integer> intso = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		intso.stream().skip(1).limit(intso.size()-2).forEach(System.out::println);
		
	}
}
