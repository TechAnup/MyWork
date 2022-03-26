package com.interview.programs.java8;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {
    private static Consumer<String> println;

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

        // sort all the values
        System.out.print("Sorted List: ");
        sortValuesPresentAscendingOrder(listOfString);


        String sorted = "bdca".chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * sort values present descending order
     *
     * @param listOfString listOfString
     */
    private static void sortValuesPresentAscendingOrder(List<String> listOfString) {
        listOfString.stream().sorted().forEach(s -> System.out.print(s + ", "));
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
    private static void findFirstNonRepeatedCharacter(final List<String> listOfString) {
        System.out.print("Non repetitive elements: ");
        listOfString.stream().distinct().findFirst().ifPresent(System.out::println);
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
