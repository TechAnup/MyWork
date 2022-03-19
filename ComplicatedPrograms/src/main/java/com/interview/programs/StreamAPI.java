package com.interview.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {

		List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(12, 10, 20, 30, 15, 50, 100, 70, 12, 3, 17));
		List<String> listOfString = new ArrayList<>(
				Arrays.asList("Anup", "Anup", "Deepali", "Adi", "Adi", "30", "15", "15"));

		// find out all the even numbers exist.
		evenNumbersExistInList(listOfIntegers);

		System.out.println();
		// find out all the numbers starting with 1.
		findAllNumbersStartingWith1(listOfIntegers);

		System.out.println();
		// find duplicate elements in a given integers list
		findDuplicateElementsInGivenIntegersList(listOfIntegers);

		System.out.println();
		// find first element from list
		findFirstElementFromList(listOfIntegers);

		// find the total number of elements
		findTotalNumberOfElements(listOfIntegers);

		// find the maximum value element
		findMaximumValueElement(listOfIntegers);

		System.out.println();
		// find first non-repeated character
		findFirstNonRepeatedCharacter(listOfString);

		System.out.println();
		// find the first repeated character
		findFirstRepeatedCharacter();

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
	 * 
	 */
	private static void findFirstRepeatedCharacter() {
		System.out.print("First repeated character:");
		String input = "Anup is good G";
		input.chars().mapToObj(Character::toLowerCase)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1L).map(Entry::getKey).findFirst()
				.ifPresent(System.out::println);
	}

	/**
	 * @return
	 */
	private static List<String> findFirstNonRepeatedCharacter(final List<String> listOfString) {
		System.out.print("Non repitative elements: ");
		listOfString.stream().distinct().forEach(s -> System.out.print(s + ", "));
		return listOfString;
	}

	/**
	 * @param listOfIntegers
	 */
	private static void findMaximumValueElement(List<Integer> listOfIntegers) {
		System.out.print("Max elements: ");
		System.out.print(listOfIntegers.stream().max((o1, o2) -> o1.equals(o2) ? +1 : (o1 < o2) ? -1 : 0));
	}

	/**
	 * @param listOfIntegers
	 */
	private static void findTotalNumberOfElements(List<Integer> listOfIntegers) {
		System.out.print("Count of elements: ");
		System.out.println(listOfIntegers.stream().count());
	}

	/**
	 * @param listOfIntegers
	 */
	private static void findFirstElementFromList(List<Integer> listOfIntegers) {
		System.out.print("First Element: ");
		listOfIntegers.stream().findFirst().ifPresent(System.out::println);
	}

	/**
	 * @param listOfIntegers
	 */
	private static void findDuplicateElementsInGivenIntegersList(List<Integer> listOfIntegers) {
		System.out.print("Duplicate Elements: ");
		Set<Integer> setOfIntgers = new HashSet<>();
		listOfIntegers.stream().filter(s -> !setOfIntgers.add(s)).forEach(s -> System.out.print(s + ", "));
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
