package com.sorting;

import com.sorting.SinglyLinkedList.Node;

public class BubbleSortUsingSinglyList {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

//		list.add(12);
//		list.add(54);
//		list.add(65);
//		list.add(7);
//		list.add(23);
//		list.add(9);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println("Before Bubble sort");
		list.display();
		list = bubbleSort(list);
		System.out.println("After Bubble sort");
		list.display();
	}

	private static SinglyLinkedList bubbleSort(SinglyLinkedList list) {
		Node head = list.getHead();
		Node passCurrent = head;
		head.getNext();
		int pass = 1;
		while (passCurrent.getNext() != null) {
			Node current = head;
			boolean isSorted = true;
			Node lastIndex = null;
			while (current.getNext() != lastIndex) {
				Node passNext = null;
				passNext = current.getNext();
				if (current.getData() > passNext.getData()) {
					int temp = current.getData();
					current.setData(passNext.getData());
					passNext.setData(temp);
					isSorted = false;
				}
				current = current.getNext();
			}
			lastIndex = current;
			System.out.println("After pass : " + pass++);
			list.display();
			if (isSorted)
				break;
			passCurrent = passCurrent.getNext();
		}

		return list;
	}
}
