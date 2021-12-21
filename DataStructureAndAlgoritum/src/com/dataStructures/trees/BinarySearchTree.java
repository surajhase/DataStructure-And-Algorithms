package com.dataStructures.trees;

import com.algorithmn.searching.DepthFirstSearch;

public class BinarySearchTree<T> extends AbstractTree<T> {

	BinaryNode<T> root = null;

	@Override
	public BinaryNode<T> getRoot() {
		return root;
	}

	@Override
	public boolean insert(Comparable<T> obj) {
		BinaryNode<T> toInsert = new BinaryNode<T>(obj);
		if (root == null) {
			root = toInsert;
			return true;
		}
		BinaryNode<T> current = root;
		while (true) {
			if (current.getKey().compareTo((T) obj) < 0) {
				if (current.getRight() == null) {
					current.setRight(toInsert);
					return true;
				} else {
					current = current.getRight();
				}
			} else if (current.getKey().compareTo((T) obj) > 0) {
				if (current.getLeft() == null) {
					current.setLeft(toInsert);
					return true;
				} else {
					current = current.getLeft();
				}
			} else {
				System.out.println("Object Already Exist");
				return false;
			}
		}
	}

	@Override
	public boolean delete(Comparable<T> obj) {
		BinaryNode<T> current = root;
		BinaryNode<T> parent = null;
		boolean found = false;
		while (current != null) {
			if (current.getKey().compareTo((T) obj) < 0) {
				current = current.getRight();
				parent = current;
			} else if (current.getKey().compareTo((T) obj) > 0) {
				current = current.getLeft();
				parent = current;
			} else {
				found = true;
				// We have a match, get to work!
				// Case 1 : If the found node is leaf node
				if (current.getRight() == null && current.getLeft() == null) {
					if (parent.getKey().compareTo((T) current.getKey()) > 0) {
						parent.setLeft(null);
						// if parent < current value, make left child a right child of parent
					} else {
						parent.setRight(null);
					}
				}
				// Case 2: Node to be deleted has only one child.
				else if (current.getRight() == null || current.getLeft() == null) {
					if (parent.getKey().compareTo((T) current.getKey()) > 0) {
						if (current.getRight() == null)
							parent.setLeft(current.getLeft());
						else
							parent.setLeft(current.getRight());
					} else {
						if (current.getRight() == null)
							parent.setRight(current.getLeft());
						else
							parent.setRight(current.getRight());
					}
				}
				// Case 3: Node to deleted has 2 children
				// Find Minimum from right sub tree and copy the value to deleting node
				// Delete the duplicate node from right sub tree
				else {
					BinaryNode<T> traverse = current.getRight().getLeft();
					BinaryNode<T> minimimFromRightSubTree = current.getRight();
					BinaryNode<T> parentOfMinimimFromRightSubTree = current;
					while (traverse != null) {
						parentOfMinimimFromRightSubTree = minimimFromRightSubTree;
						minimimFromRightSubTree = traverse;
						traverse = traverse.getLeft();
					}
					current.setKey(minimimFromRightSubTree.getKey());
					parentOfMinimimFromRightSubTree.setLeft(minimimFromRightSubTree.getRight());
				}
			}
		}
		return found;
	}

	@Override
	public boolean search(Comparable<T> obj) {
		BinaryNode<T> current = root;
		while (current != null) {
			if (current.getKey().compareTo((T) obj) < 0) {
				current = current.getRight();
			} else if (current.getKey().compareTo((T) obj) > 0) {
				current = current.getLeft();
			} else {
				return true;
			}
		}
		return false;
	}

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
		System.out.println(bst.search(170));

		DepthFirstSearch<Integer> dfs = new DepthFirstSearch<Integer>();
		System.out.println("In order Traversal");
		System.out.println(dfs.dfsForBinaryTreeInOrder(bst.getRoot(), null));
		System.out.println("Pre order Traversal");
		System.out.println(dfs.dfsForBinaryTreePreOrder(bst.getRoot(), null));
		System.out.println("Post order Traversal");
		System.out.println(dfs.dfsForBinaryTreePostOrder(bst.getRoot(), null));
	}
}
