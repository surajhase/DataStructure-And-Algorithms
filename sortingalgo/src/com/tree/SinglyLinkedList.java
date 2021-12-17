package com.tree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class SinglyLinkedList {
	private Node head = null;
	int size = 0;

	class Node {
		int x;
		Node next;

		Node(int x) {
			this.x = x;
			this.next = null;
		}
	}

	int size() {
		return size;
	}

	void print() {
		Node current = head;
		while (current != null) {
			System.out.print(current.x + " ");
			current = current.next;
		}
	}

	void add(int x) {
		Node n = new Node(x);
		if (head == null) {
			head = n;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = n;
		}
		size++;
	}

	void deleteAtPosition(int x) throws Exception {
		Node temp = head;
		if (size == 0 || x > size) {
			throw new Exception("Index out of bound");
		}
		if (x == 1) {
			head = temp.next;
		} else {
			for (int i = 0; i < x - 2; i++) {
				temp = temp.next;
			}
			Node temp2 = temp;
			temp = temp.next;
			temp2.next = temp.next;
		}
	}

	void reverse() {
		Node current = head;
		Node next = null;
		Node prev = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public static void main(String[] args) throws Exception {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(12);
		list.add(1);
		list.add(22);
		list.add(45);
		list.add(67);
		list.print();
		System.out.println("");
		list.deleteAtPosition(3);
		list.print();
		System.out.println("");
		list.reverse();
		list.print();

		String rexp = "[*+/-]";
		String str = "((A+B)*C-D)*E";
		//String str = "A*(B+c)";
		ArrayList<Character> result = new ArrayList<Character>();
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (Pattern.matches(rexp, ch.toString())) {
				while (!s.isEmpty() && !s.peek().equals('(') && hasHigherPresedence(s.peek(), ch)) {
					result.add(s.pop());
				}
				s.push(ch);
			} else if (ch.equals(')')) {
				while (!s.isEmpty() && (!s.peek().equals('('))) {
					result.add(s.pop());
				}
				if (!s.isEmpty() && s.peek().equals('(')) {
					s.pop();
				}
			} else if (ch.equals('(')) {
				s.push(ch);
			} else {
				result.add(ch);
			}
		}
		while (!s.empty()) {
			result.add(s.pop());
		}
		System.out.println(result);
	}

	private static boolean hasHigherPresedence(Character peek, Character ch) {
		if ((ch.equals('*') || ch.equals('/')) && (peek.equals('+') || peek.equals('-'))) {
			return false;
		}
		return true;
	}
}
