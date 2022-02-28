package com.interview.programs.search.sort;

public class SortingTechniques {

	public static void main(String[] args) {

		// System.out.println(binaryTreeSearch(intArr, 0, len, 10));
		// selectionSortAnIntArray(new int[] { 6, 5, 8, 4, 10, 3, 9, 2 });
	}

	private static void selectionSortAnIntArray(int[] unsortedArray) {

		int len = unsortedArray.length;
		// Printing unsorted int array
		for (int i = 0; i < len; i++) {
			printArray(unsortedArray);

			for (int j = i + 1; j < len; j++) {
				// search elements for min value in array.
				if (unsortedArray[i] > unsortedArray[j]) {
					int temp = unsortedArray[i];
					unsortedArray[i] = unsortedArray[j];
					unsortedArray[j] = temp;
				}
			}
			System.out.println();
		}
		printArray(unsortedArray);
	}

	/**
	 * @param unsortedArray
	 */
	private static void printArray(int[] unsortedArray) {
		// Printing unsorted int array
		for (int i : unsortedArray) {
			System.out.print(i + ", ");
		}
	}
}
