package com.algorithmn.sorting;

import com.dataStructures.linkedList.SinglyLinkedList;
import com.dataStructures.linkedList.SinglyLinkedList.Node;

public class SelectionSortUsingSinglyList {
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
		System.out.println("Before Selection sort");
		list.display();
		list = selectionSort(list);
		System.out.println("After Selection sort");
		list.display();
	}

	private static SinglyLinkedList selectionSort(SinglyLinkedList list) {
		Node head = list.getHead();
		Node passCurrent = head;
		head.getNext();
		int pass = 1;
		while (passCurrent.getNext() != null) {
			Node current = passCurrent.getNext();
			Node minValueNode = passCurrent;
			while (current != null) {
				if(minValueNode.getData() > current.getData())
					minValueNode = current;
				current = current.getNext();
			}
			if(passCurrent != minValueNode) {
				int temp = passCurrent.getData();
				passCurrent.setData(minValueNode.getData());
				minValueNode.setData(temp);
			}
			System.out.println("After pass : " + pass++);
			list.display();
			passCurrent = passCurrent.getNext();
		}

		return list;
	}
}
