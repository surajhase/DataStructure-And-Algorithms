package com.dataStructures.trees;

public class Node<T> {

	Comparable<T> key;
	Node<T> left, right;

	public Comparable<T> getKey() {
		return key;
	}

	public void setKey(Comparable<T> key) {
		this.key = key;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node(Comparable<T> key2) {
		key = key2;
		left = right = null;
	}
}
