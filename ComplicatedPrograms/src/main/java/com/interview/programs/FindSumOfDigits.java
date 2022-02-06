package com.interview.programs;

public class FindSumOfDigits {

	static int factorial = 0;

	public static void main(String[] args) {

		generateFibonacciSeries();
	}

	// 0 1 1 2 3 5 8 13 21 34 55 89.
	private static void generateFibonacciSeries() {

		int first = 0;
		int second = 1;
		// System.out.println("Fibonacci Series:");
		System.out.println(first);
		System.out.println(second);
		for (int i = 0; i < 20; i++) {
			int temp = first + second;
			first = second;
			second = temp;
			System.out.println(temp);
		}
	}

}
