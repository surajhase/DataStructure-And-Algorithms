package com.sorting;

import com.sorting.SinglyLinkedList.Node;

public class InsertionSortUsingSinglyList {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.add(12);
		list.add(54);
		list.add(65);
		list.add(7);
		list.add(23);
		list.add(9);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);
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
