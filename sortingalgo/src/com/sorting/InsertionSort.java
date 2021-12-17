package com.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 12, 54, 65, 7, 23, 9 };
		//int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Before Insertion sort");
		printArray(arr);
		arr = insertionSort(arr);
		System.out.println("After Insertion sort");
		printArray(arr);
	}

	private static int[] insertionSort(int[] arr) {
		int n = arr.length;
		int temp;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i-1 ; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println("After pass : " + i);
			printArray(arr);
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
