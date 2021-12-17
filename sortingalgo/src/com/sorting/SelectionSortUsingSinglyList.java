package com.sorting;

import com.sorting.SinglyLinkedList.Node;

public class SelectionSortUsingSinglyList {
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
