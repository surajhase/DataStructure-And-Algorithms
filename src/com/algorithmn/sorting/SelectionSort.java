package com.algorithmn.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 12, 54, 65, 7, 23, 9 };
		//int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Before Selection sort");
		printArray(arr);
		arr = selectionSort(arr);
		System.out.println("After Selection sort");
		printArray(arr);
	}

	private static int[] selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			int min_index = i;
			for (int j = i+1; j < n ; j++) {
				if (arr[j] < arr[min_index]) {
					min_index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min_index];
			arr[min_index] = temp;
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
