package com.dataStructures.trees;

public abstract class AbstractTree<T> {
	abstract BinaryNode<T> getRoot();
	abstract boolean insert(Comparable<T> obj);
	abstract boolean delete(Comparable<T> obj);
	abstract boolean search(Comparable<T> obj);
	abstract void printPreOrder(BinaryNode<T> node);
	abstract void PrintInOrder(BinaryNode<T> root);
	abstract void PrintPostOrder(BinaryNode<T> node);
}
