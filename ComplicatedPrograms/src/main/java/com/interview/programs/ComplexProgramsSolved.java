package com.interview.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ComplexProgramsSolved {
	// SwappingTwoNumbers
	public static void main(String[] args) {

		// findDuplicateElementsInIntegerArray(new int[] { 1, 2, 5, 5, 5 });
		// findDuplicateElementsInStringArray(new String[] { "A", "B", "B", "C", "C",
		// "A", "D" });
		// reverserString("BHANDEGAONKAR");
		// reverserNumbers(1234567);
		// swappingOfTwoNumbers(20, 40);

	}

	private static void findDuplicateElementsInIntegerArray(int[] intValues) {

		// Logic 1 Using two loops
		int[] intArray = intValues;

		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intValues.length; j++) {
				if (intArray[i] == intArray[j]) {
					System.out.println("Found duplicate element: [" + intArray[i] + "].");
				}
			}
		}

		// Logic 2 Using one loops
		intArray = intValues;
		Arrays.sort(intArray);
		for (int i = 0; i < intArray.length - 1; i++) {
			if (intArray[i] == intArray[i + 1])
				System.out.println("Found duplicate element: [" + intArray[i] + "].");
		}

	}

	private static void findDuplicateElementsInStringArray(String[] stringArray) {

		// Logic 1 Using two loops

		String[] strings = stringArray;
		Optional<Boolean> flag = Optional.of(false);
		for (int i = 0; i < strings.length; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i] == strings[j]) {
					System.out.println("Found the duplicate element:[" + strings[i] + "]");
					flag = Optional.of(true);
				}
			}
		}
		if (flag.get() == false) {
			System.out.println("Duplicate variable not found");
		}

		// Logic 2 Using HashSet
		strings = stringArray;
		List<String> duplicateValues = new ArrayList<>();
		Set<String> stringSet = new HashSet<>();

		for (String value : strings) {
			if (!stringSet.contains(value))
				stringSet.add(value);
			else
				duplicateValues.add(value);
		}
		System.out.println("Found the duplicate element:" + duplicateValues);
	}

	private static void reverserString(String string) {

		// Logic-1 Using concatenation operator
		System.out.println("Before Reversing: string[" + string + "].");

		String rev = "";
		int length = string.length();
		for (int i = length - 1; i >= 0; i--) {
			rev = rev + string.charAt(i);

		}
		System.out.println("After Reversing: string [" + rev + "].");
		// Logic-1 Using char array

		// Logic-1 Using char array

		int len = string.length();
		char[] charArray = string.toCharArray();
		rev = "";
		for (int i = charArray.length - 1; i >= 0; i--) {
			rev = rev + charArray[i];
		}

		System.out.println("After Reversing: string [" + rev + "].");
	}

	private static void reverserNumbers(int num) {

		int temp = num;
		System.out.println("Before Reversing: num[" + num + "].");

		// Logic-1 Using algorithm
		int rev = 0;
		while (temp != 0) {
			rev = rev * 10 + temp % 10; // 0 + 1234 % 10 = 4
			temp = temp / 10; // 1234/10 = 123
		}
		System.out.println("After Reversing: num[" + rev + "].");

		// Logic-1 Using StringBuilder class
		rev = 0;
		temp = num;
		StringBuilder stringValue = new StringBuilder("").append(temp);
		System.out.println("After Reversing: num[" + stringValue.reverse() + "].");
	}

	private static void swappingOfTwoNumbers(int x, int y) {
		int a = x;
		int b = y;
		System.out.println("Before swapping: a[" + a + "], b[" + b + "].");

		// Logic-1 using third variable
		int temp = a; // 20 into temp variable
		a = b; // 10 into value2
		b = temp; // 20 into value1
		System.out.println("Logic-1 After swapping: a[" + a + "], b[" + b + "].");

		// Logic-2 without using third variable
		a = x;
		b = y;
		a = a + b; // b= 10+20 = 30
		b = a - b; // b= 30 - 10 = 20
		a = a - b;
		System.out.println("Logic-2 After swapping: a[" + a + "], b[" + b + "].");

		// Logic-3 without using third variable. It will convert into binary form and
		// then ^ condition will run to generate new binary value.
		a = x;
		b = y;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("Logic-2 After swapping: a[" + a + "], b[" + b + "].");
	}

}
