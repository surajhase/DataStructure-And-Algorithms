package com.dataStructures.trees;

public abstract class AbstractTree<T> {
	abstract Node<T> getRoot();
	abstract boolean insert(Comparable<T> obj);
	abstract boolean delete(Comparable<T> obj);
	abstract boolean search(Comparable<T> obj);
	abstract void traverseBFS(Node<T> node);
	abstract void traverseInOrder(Node<T> root);
	abstract void traverseDFS(Node<T> node);
}
