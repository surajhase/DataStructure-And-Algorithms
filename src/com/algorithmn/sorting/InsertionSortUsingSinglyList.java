package com.algorithmn.sorting;

import com.dataStructures.linkedList.SinglyLinkedList;
import com.dataStructures.linkedList.SinglyLinkedList.Node;

public class InsertionSortUsingSinglyList {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insert(12);
		list.insert(54);
		list.insert(65);
		list.insert(7);
		list.insert(23);
		list.insert(9);
//		list.insert(1);
//		list.insert(2);
//		list.insert(3);
//		list.insert(4);
//		list.insert(5);
//		list.insert(6);
		System.out.println("Before Insertion sort");
		list.display();
		list = insertionSort(list);
		System.out.println("After Insertion sort");
		list.display();
	}

	private static SinglyLinkedList insertionSort(SinglyLinkedList list) {
		Node head = list.getHead();
		Node pivot = head.getNext();
		head.getNext();
		int pass = 1;
		while (pivot != null) {
			Node current = head;
			while (current.getNext() != pivot) {
				if (pivot.getData() < current.getData()) {
					int temp = current.getData();
					current.setData(pivot.getData());
					pivot.setData(temp);
				}
				current = current.getNext();
			}
			System.out.println("After pass : " + pass++);
			list.display();
			pivot = pivot.getNext();
		}

		return list;
	}
}
