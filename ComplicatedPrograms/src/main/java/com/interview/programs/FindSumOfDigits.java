package com.interview.programs;

public class FindSumOfDigits {

	public static void main(String[] args) {
		int value = 12345;

		int result = findSumOfDigit(value);

		System.out.println("Some of digits: " + result);
	}

	private static int findSumOfDigit(int value) {
		int sum = 0;
		int remainder = 0;
		while (value > 0) {

			remainder = value % 10;
			value = value / 10;
			sum += remainder;

			System.out.println("Remainder: [" + remainder + "], value: [" + value + "] sum: [" + sum + "]");
		}
		return sum;
	}
}
