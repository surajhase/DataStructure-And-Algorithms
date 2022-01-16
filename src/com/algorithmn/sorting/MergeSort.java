package com.algorithmn.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 12, 54, 65, 7, 23, 9, 16 };
		// int[] arr = { 1, 2, 3, 4, 5, 6 };
		MergeSort ms = new MergeSort();
		System.out.println("Before merge sort");
		ms.printArray(arr);
		arr = ms.mergeSort(arr);
		System.out.println("After merge sort");
		ms.printArray(arr);
	}

	// Divide the array till 1 element and merge it again by sorting each divided
	// array
	public int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int middleIndex = arr.length / 2;

		/* Create temp arrays */
		int leftArray[] = new int[middleIndex - 0];
		int rightArray[] = new int[arr.length - middleIndex];

		/* divide arrays from middle and Copy data to temp arrays */
		for (int i = 0; i < middleIndex; ++i) {
			leftArray[i] = arr[i];
		}
		for (int k = 0, j = middleIndex; j < arr.length; k++, j++) {
			rightArray[k] = arr[j];
		}
		System.out.println("Left array :");
		printArray(leftArray);
		/* divide left array further */
		leftArray = mergeSort(leftArray);
		System.out.println("Sorted Left array :");
		printArray(leftArray);
		/* divide right array further */
		System.out.println("Right array :");
		printArray(rightArray);
		rightArray = mergeSort(rightArray);
		System.out.println("Sorted Right array :");
		printArray(rightArray);
		/* Sort the both array and merge it */
		int[] sorted = sortAndMerge(leftArray, rightArray);
		System.out.println("After sorting and merging left & right array :");
		printArray(sorted);
		return sorted;
	}

	int[] sortAndMerge(int leftArray[], int[] rightArray) {
		// Initial indexes of first and second subarrays
		int[] sortedArray = new int[leftArray.length + rightArray.length];
		int sizeOfLeftArray = leftArray.length;
		int sizeOfRightArray = rightArray.length;
		int i = 0, j = 0, k = 0;
		// Initial index of merged subarray array
		while (i < sizeOfLeftArray && j < sizeOfRightArray) {
			if (leftArray[i] <= rightArray[j]) {
				sortedArray[k] = leftArray[i];
				i++;
			} else {
				sortedArray[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < sizeOfLeftArray) {
			sortedArray[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < sizeOfRightArray) {
			sortedArray[k] = rightArray[j];
			j++;
			k++;
		}
		return sortedArray;
	}

	private void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
