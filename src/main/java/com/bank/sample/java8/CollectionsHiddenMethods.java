package com.bank.sample.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsHiddenMethods {
	public static void main(String[] args) {

//		1. Adds the given obj for given number in a list. However list is IMMUTABLE.
		List<String> strLis = Collections.nCopies(10, "Hello");
		System.out.println(strLis);

//		2. Collections.frequency() --> used to find freq of a particular element in a list.
		List<Integer> intLis = Arrays.asList(1, 2, 2, 3, 4, 5, 2, 6, 7, 8, 2, 9);
		System.out.println(Collections.frequency(intLis, 2));

//		3. collections.disjoint() --> validates 2 lists and common elements between em..it return boolean.
		List<String> strLis1 = Arrays.asList("test", "Hello", "hai");
		Boolean isPresen = Collections.disjoint(strLis, strLis1);
		if (isPresen) {
			System.out.println("Common not found");
		} else {
			System.out.println("Common ele found");
		}
		
//		4. Collecctions.singleton --> creates immutable set that cotains only single element.
		Collections.singleton("javaTechie");
		
//		5. Collections.rotate --> it rotate element of specified list by ginven instance. ie; shifting position left or right,
		List<Integer> intLis1 = Arrays.asList(1, 2, 3,4,5,6,7,8,9);
//		Collections.rotate(intLis1, 3);  // from right, it will take elements and rotate. so Op will be starting from 7,8,9,1,2,3,4,5,6 like this.
//		in case i want to rotate from left, i should give negative number like Collections.rotate(intLis1,-3);
//		Collections.rotate(intLis1, -3);
		Collections.rotate(intLis1, -15);
		System.out.println(intLis1);
		
		
	}
}
