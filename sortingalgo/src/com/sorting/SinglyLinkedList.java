package com.sorting;

public class SinglyLinkedList {
	private Node head; // head of list
	private int size = 0;

	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public static class Node {
		private int data;
		private Node next;

		Node(int d) {
			data = d;
			next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	/* This function prints contents of the linked list starting from head */
	public void display() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("");
	}

	/* This function prints contents of the linked list starting from head */
	public void add(int x) {
		Node n = head;
		if (head == null) {
			head = new Node(x);
		} else {
			while (n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(new Node(x));
		}
		size++;
	}

	/* method to create a simple linked list with 3 nodes */
	public static void main(String[] args) {
		/* Start with the empty list. */
		SinglyLinkedList list = new SinglyLinkedList();

		list.add(12);
		list.add(54);
		list.add(65);
		list.add(7);
		list.add(23);
		list.add(9);
		list.display();
	}
}
