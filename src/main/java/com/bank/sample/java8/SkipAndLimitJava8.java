package com.bank.sample.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SkipAndLimitJava8 {

	/*
	 * Skip -> this method is used to discard number of elements we provide inside
	 * method ie; skip(5) --> this will start (start) getting values in stream from
	 * 6th no.
	 * 
	 * Limit -> this method is alss used to discard the values after (end) of
	 * Value.class. ie; limit(7) --> this will provide elements inside list till 7th
	 * value
	 * 
	 * ex : [1,2,3,4,5,6,7,8,9,11];
	 * stream.of(1,2,3,4,5,6,7,8,9,11).skip(3).limit(4); o/p will be --> [4,5,6,7].
	 * since in limit(3) 1,2,3 is removed and position of 4 will become 1. limit
	 * provides positions till 4 from 1. so 4,5,6,7 will become O/P. rest are
	 * ignored.
	 * 
	 * ***** Dont calculate based on index.
	 */

	public static void main(String[] args) throws IOException {
//		use case : i want O/P as 1st element removed and up to 8 value.
		List<Integer> intLis = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		intLis.stream()
			.skip(1)  // removes 1st element.
			.limit(7) // post removal of 1st element, 2 will become position 1. so 8 value position will be 7. so limit(7) is used.
			.forEach(System.out::print);
		
		System.out.println("\n"+"==================");
		
//		Created a file inside main package with name data.txt. read all lines and skip header and footer.
		List<String> files = Files.readAllLines(Paths.get("data.txt"));
		files.stream().skip(1).limit(4).forEach(f -> System.out.println(f));
		
//		making this dynamic rather than hardcoding limit size. First know the size of list.Then remove header and footer means size-2.
		System.out.println(files.size());
		files.stream().skip(1).limit(files.size()-2).forEach(System.out::println);
		
		
	}
}
