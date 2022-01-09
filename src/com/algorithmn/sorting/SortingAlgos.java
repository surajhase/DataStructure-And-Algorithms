package com.algorithmn.sorting;

public class SortingAlgos {
	public static void main(String[] args) {

	}

	public int[] bubbleSort(int[] unsorted) {
		for(int i = 0;i<unsorted.length ;i++) {
			for(int j=0;j<unsorted.length - 1;j++) {
				if(unsorted[j] > unsorted[j+1]) {
					int temp = unsorted[j];
					unsorted[j] = unsorted[j+1];
					unsorted[j+1] = temp;
				}
			}
		}
		return unsorted;
	}
	
	public int[] selectionSort(int[] unsorted) {
		for(int i = 0;i<unsorted.length ;i++) {
			int index = i;
			for(int j=i;j<unsorted.length;j++) {
				if(unsorted[j] < unsorted[index]) {
					index = j;
				}
			}
			int temp = unsorted[i];
			unsorted[i] = unsorted[index];
			unsorted[index] = temp;
		}
		return unsorted;
	}
}
