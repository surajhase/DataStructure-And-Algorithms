package com.sorting;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 12, 54, 65, 7, 23, 9 };
		// int[] arr = { 1, 2, 3, 4, 5, 6 };
		System.out.println("Before Quick sort");
		printArray(arr);
		quickSort(arr, 0, arr.length - 1);
		System.out.println("After Quick sort");
		printArray(arr);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
