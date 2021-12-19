package com.algorithmn.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 12, 54, 65, 7, 23, 9 };
		//int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Before Bubble sort");
		printArray(arr);
		arr = bubbleSort(arr);
		System.out.println("After Bubble sort");
		printArray(arr);
	}

	private static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean isSorted = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSorted = false;
				}
			}
			System.out.println("After pass : " + (i + 1));
			printArray(arr);
			if (isSorted)
				break;
		}
		return arr;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
