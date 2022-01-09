package com.algorithmn.searching;

import java.util.ArrayList;
import java.util.List;

import com.dataStructures.trees.BinaryNode;

public class DepthFirstSearch<T> {

	public List<Comparable<T>> dfsForBinaryTreeInOrder(BinaryNode<T> node, List<Comparable<T>> dfsInOrder) {
		if (null == dfsInOrder)
			dfsInOrder = new ArrayList<Comparable<T>>();
		if (node != null) {
			dfsForBinaryTreeInOrder(node.getLeft(), dfsInOrder);
			dfsInOrder.add(node.getKey());
			dfsForBinaryTreeInOrder(node.getRight(), dfsInOrder);
		}
		return dfsInOrder;
	}

	public List<Comparable<T>> dfsForBinaryTreePreOrder(BinaryNode<T> node, List<Comparable<T>> dfsPreOrder) {
		if (null == dfsPreOrder)
			dfsPreOrder = new ArrayList<Comparable<T>>();
		if (node != null) {
			dfsPreOrder.add(node.getKey());
			dfsForBinaryTreePreOrder(node.getLeft(), dfsPreOrder);
			dfsForBinaryTreePreOrder(node.getRight(), dfsPreOrder);
		}
		return dfsPreOrder;
	}

	public List<Comparable<T>> dfsForBinaryTreePostOrder(BinaryNode<T> node, List<Comparable<T>> dfsPostOrder) {
		if (null == dfsPostOrder)
			dfsPostOrder = new ArrayList<Comparable<T>>();
		if (node != null) {
			dfsForBinaryTreePostOrder(node.getLeft(), dfsPostOrder);
			dfsForBinaryTreePostOrder(node.getRight(), dfsPostOrder);
			dfsPostOrder.add(node.getKey());
		}
		return dfsPostOrder;
	}
}
