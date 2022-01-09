package com.algorithmn.sorting;

import com.dataStructures.linkedList.SinglyLinkedList;
import com.dataStructures.linkedList.SinglyLinkedList.Node;

public class BubbleSortUsingSinglyList {
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
