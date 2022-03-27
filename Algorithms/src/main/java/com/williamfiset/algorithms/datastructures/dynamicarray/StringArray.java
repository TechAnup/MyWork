/**
 * Most of the time when you use an array it's to place string inside of it, so why not have a
 * super fast string only array? This file contains an implementation of an string only array
 * which can outperform Java's ArrayList by about a factor of 10-15x! Enjoy!
 *
 * @author Anup B, anup.bhandegaonkar@gmail.com - Added few modifications
 */
package com.williamfiset.algorithms.datastructures.dynamicarray;

import java.util.Arrays;

public class StringArray {

	private static final int INITIAL_CAPACIT = 1 << 3;

	private String[] stringArray = null;
	private int length = 0;
	private int capacity = 0;

	// Initialize this string array with default capacity
	public StringArray() {
		this(INITIAL_CAPACIT);
	}

	// Initialize the array with a certain capacity
	public StringArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Invalid capacity " + capacity);
		this.capacity = capacity;
		this.stringArray = new String[capacity];
	}

	// Given an array make it a dynamic array!
	public StringArray(String[] stringArray) {
		if (stringArray == null) {
			throw new IllegalArgumentException("Array should not be null");
		}

		this.stringArray = Arrays.copyOf(stringArray, stringArray.length);
		capacity = length = stringArray.length;
	}

	// Returns the size of the array
	public int size() {
		return length;
	}

	// Returns true/false on whether the array is empty
	public boolean isEmpty() {
		return length == 0;
	}

	public String get(int index) {
		return stringArray[index];
	}

	public void set(String value, int index) {
		this.stringArray[index] = value;
	}

	// Add an element to this dynamic array.
	public void add(String value) {
		if (length + 1 >= capacity) {
			if (capacity == 0) {
				capacity = 1;
			} else {
				capacity *= capacity;
			}
			this.stringArray = Arrays.copyOf(stringArray, capacity);
		}
		stringArray[length++] = value;
	}

	// Add an element to this dynamic array.
	public static void main(String[] args) {
		String[] arr = { "Anup", "Vrushali", "Deepali", "Anup" };

		StringArray arr1 = new StringArray(arr);

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1.get(i));
		}
		arr1.add("Adisharee");

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1.get(i));
		}
	}

}
