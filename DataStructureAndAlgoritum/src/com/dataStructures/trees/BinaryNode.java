package com.dataStructures.trees;

public class BinaryNode<T> {

	Comparable<T> key;
	BinaryNode<T> left, right;

	public Comparable<T> getKey() {
		return key;
	}

	public void setKey(Comparable<T> key) {
		this.key = key;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	public BinaryNode(Comparable<T> key2) {
		key = key2;
		left = right = null;
	}
}
