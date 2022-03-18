package com.interview.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {

		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(10, 20, 30, 15, 50, 10, 70, 3, 17));

		// find out all the even numbers exist.
		evenNumbersExistInList(listOfIntegers);

		System.out.println();
		// find out all the numbers starting with 1.
		findAllNumbersStartingWith1(listOfIntegers);

		System.out.println();
		// How to find duplicate elements in a given integers list in java using Stream
		// functions?
		System.out.print("Duplicate Elements: ");
		Set<Integer> setOfIntgers = new HashSet<>();
		listOfIntegers.stream().filter(s -> !setOfIntgers.add(s)).forEach(s -> System.out.print(s + ", "));

		System.out.println();
		// Given the list of integers, find the first element of the list using Stream
		// functions?
		System.out.print("First Element: ");
		System.out.println(listOfIntegers.stream().findFirst().get());

		// Given a list of integers, find the total number of elements present in the
		// list using Stream functions?
		System.out.print("Count of elements: ");
		System.out.println(listOfIntegers.stream().count());

		// Given a list of integers, find the maximum value element present in it using
		// Stream functions?
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				} else if (o1 < o2) {
					return -1;
				} else {
					return +1;
				}
			}
		};
		System.out.print("Max elements: ");
		System.out.print(listOfIntegers.stream().max(comparator));

		System.out.println();
		// Given a String, find the first non-repeated character in it using Stream
		// functions?
		List<String> listOfString = new ArrayList<>(Arrays.asList("Anup", "Anup", "Deepali", "30", "15"));
		System.out.print("Non repitative elements: ");
		listOfString.stream().distinct().forEach(s -> System.out.print(s + ", "));

		System.out.println();
		// Given a String, find the first repeated character in it using Stream
		// functions?
		String input = "Anup is good G";
		Character result = input.chars() // Stream of String
				.mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(entry -> entry.getKey()).findFirst()
				.get();
		System.out.println("First repeated character in string: " + result);

		// Given a list of integers, sort all the values present in it using Stream
		// functions?
		System.out.print("Sorted List: ");
		listOfString.stream().sorted().forEach(s -> System.out.print(s + ", "));

		System.out.println();
		// Given a list of integers, sort all the values present in it in descending
		// order using Stream functions?
		listOfString.stream().sorted(Collections.reverseOrder()).forEach(s -> System.out.print(s + ", "));
	}

	/**
	 * @param listOfIntegers
	 */
	private static void findAllNumbersStartingWith1(List<Integer> listOfIntegers) {
		System.out.print("Elements which starts with 1: ");
		listOfIntegers.stream().map(s -> s + "") // Convert integer to String
				.filter(s -> s.startsWith("1")).forEach(s -> System.out.print(s + ", "));
	}

	/**
	 * @param listOfIntegers
	 */
	private static void evenNumbersExistInList(List<Integer> listOfIntegers) {
		System.out.print("Even numbers: ");
		listOfIntegers.stream().filter(s -> s % 2 == 0).forEach(s -> System.out.print(s + ", "));
	}
}
