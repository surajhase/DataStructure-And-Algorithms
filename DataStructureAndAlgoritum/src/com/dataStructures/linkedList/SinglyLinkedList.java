package com.dataStructures.linkedList;

public class SinglyLinkedList {
	// Represent a node of the singly linked list
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Represent the head and tail of the singly linked list
	public Node head = null;
	public Node tail = null;
	int size = 0;

	// addNode() will add a new node to the list
	public void insert(int data) {
		// Create a new node
		Node newNode = new Node(data);

		// Checks if the list is empty
		if (head == null) {
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tail.next = newNode;
			// newNode will become new tail of the list
			tail = newNode;
		}
		size++;
	}

	// addNode() will add a new node to the list
	public void insert(int data, int index) {
		if (index < 0) {
			insertFirst(data);
			return;
		}
		if (index > size) {
			insert(data);
			return;
		}
		// Create a new node
		Node newNode = new Node(data);
		int counter = 0;
		Node current = head;
		while (counter != index - 1) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		size++;
	}

	// addNode() will add a new node to the list
	public void insertFirst(int data) {
		// Create a new node
		Node newNode = new Node(data);

		// Checks if the list is empty
		if (head == null) {
			// If list is empty, both head and tail will point to new node
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public boolean delete() {
		if (head == null) {
			System.out.println("List is empty");
			return false;
		}
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			current.next = null;
		}
		size--;
		return true;
	}

	public boolean delete(int index) {
		if (index < 0) {
			return deleteFirst();
		}
		if (index > size) {
			return delete();
		}
		// Create a new node
		int counter = 0;
		Node current = head;
		while (counter != index - 1) {
			current = current.next;
		}
		Node nodeToDelete = current.next;
		current.next = nodeToDelete.next;
		size--;
		return true;
	}

	public boolean deleteFirst() {

		if (head == null) {
			System.out.println("List is empty");
			return false;
		}
		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
		size--;
		return true;
	}

	// display() will display all the nodes present in the list
	public void display() {
		// Node current will point to head
		Node current = head;

		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			// Prints each node by incrementing pointer
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void displayReverse() {
		// Node current will point to head
		Node current = head;
		Node end = tail;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		if (head == tail) {
			System.out.print(current.data + " ");
			return;
		}
		while (current != end) {
			while (current.next != end) {
				current = current.next;
			}
			System.out.print(end.data + " ");
			end = current;
			current = head;
		}
		System.out.print(current.data + " ");
		System.out.println();
	}

	public void reverse() {
		// Node current will point to head
		Node current = head;
		Node next = null;
		Node prev = null;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Reversing");
		if (head == tail) {
			return;
		}
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		tail = head;
		head = prev;
	}

	public static void main(String[] args) {

		SinglyLinkedList sList = new SinglyLinkedList();

		// Add nodes to the list
		sList.insert(1);
		sList.insert(2);
		sList.insert(3);
		sList.insert(4);

		// Displays the nodes present in the list
		sList.display();
		sList.displayReverse();
		sList.reverse();
		sList.display();

		sList.reverse();
		sList.display();
	}
}