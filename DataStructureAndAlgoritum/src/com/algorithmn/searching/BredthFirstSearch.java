package com.algorithmn.searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dataStructures.trees.BinaryNode;
import com.dataStructures.trees.BinarySearchTree;

public class BredthFirstSearch {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(9);
		bst.insert(4);
		bst.insert(6);
		bst.insert(20);
		bst.insert(170);
		bst.insert(15);
		bst.insert(1);
		bst.insert(170);
		BredthFirstSearch bs = new BredthFirstSearch();
		System.out.println("BFS : " + bs.bfsForBinaryTree(bst.getRoot()));
	}

	public <T> List<Comparable<T>> bfsForBinaryTree(BinaryNode<T> root) {
		List<Comparable<T>> bfs = new ArrayList<Comparable<T>>();
		Queue<BinaryNode<T>> que = new LinkedList<BinaryNode<T>>();
		que.add(root);
		while (que.size() > 0) {
			BinaryNode<T> currentNode = que.poll();
			bfs.add(currentNode.getKey());
			if (currentNode.getLeft() != null)
				que.add(currentNode.getLeft());
			if (currentNode.getRight() != null)
				que.add(currentNode.getRight());
		}
		return bfs;
	}
}
