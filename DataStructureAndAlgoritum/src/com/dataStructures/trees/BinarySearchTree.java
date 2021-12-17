package com.dataStructures.trees;

public class BinarySearchTree<T> extends AbstractTree<T> {

	Node<T> root = null;

	@Override
	public Node<T> getRoot() {
		return root;
	}
	@Override
	public boolean insert(Comparable<T> obj) {
		Node<T> toInsert = new Node<T>(obj);
		if (root == null) {
			root = toInsert;
			return true;
		}
		Node<T> current = root;
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
		Node<T> current = root;
		Node<T> parent = null;
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
					Node<T> traverse = current.getRight().getLeft();
					Node<T> minimimFromRightSubTree = current.getRight();
					Node<T> parentOfMinimimFromRightSubTree = current;
					while(traverse != null) {
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
		Node<T> current = root;
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

	@Override
	public void traverseBFS(Node<T> node) {
		if(node == null)
			return;
		traverseInOrder(node.getLeft());
		System.out.println(node.getKey());
		traverseInOrder(node.getRight());
	}

	@Override
	public void traverseInOrder(Node<T> node) {
		if(node == null)
			return;
		System.out.println(node.getKey());
		traverseInOrder(node.getLeft());
		traverseInOrder(node.getRight());
	}

	@Override
	public void traverseDFS(Node<T> node) {
		if(node == null)
			return;
		traverseInOrder(node.getLeft());
		traverseInOrder(node.getRight());
		System.out.println(node.getKey());
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
		bst.traverseInOrder(bst.getRoot());
	}
}