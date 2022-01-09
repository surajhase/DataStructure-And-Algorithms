package com.algorithmn.sorting;

public class BinaryTree {
	private BinaryTreeNode root;
	public BinaryTreeNode getRoot() {
		return root;
	}

	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	public BinaryTreeNode delete(int value) {
		if(root == null) {
			return null;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode prev = null; 
		while(current !=null) {
			if(value == current.getData()) {
				//if node to be deleted is leaf node
				if(current.getLeft() == null && current.getRight() == null) {
					if(prev.getLeft() == current) {
						prev.setLeft(null);
					}else {
						prev.setRight(null);
					}
					return current;
				}
				else {
					if(current.getLeft() != null && current.getRight() != null){
						//Has two childrens. find inorder successor
						BinaryTreeNode inOrderSuccessor = current;
						while(inOrderSuccessor !=null) {
							
						}
					}else {
						//Has only once child
						BinaryTreeNode nodeToAppend = null;
						if(current.getLeft() == null) {
							nodeToAppend = current.getRight();
						}else {
							nodeToAppend = current.getRight();
						}
						if(prev.getLeft() == current) {
							prev.setLeft(nodeToAppend);
						}else {
							prev.setRight(nodeToAppend);
						}
					}
				}
			}else if(current.getData() < value) {
				prev = current;
				current = current.getLeft();
			}else {
				prev = current;
				current = current.getRight();
			}
		}
		return null;
	}

	private BinaryTreeNode addRecursive(BinaryTreeNode current, int value) {
	    if (current == null) {
	        return new BinaryTreeNode(value);
	    }

	    if (value < current.getData()) {
	        current.setLeft(addRecursive(current.getLeft(), value));
	    } else if (value > current.getData()) {
	        current.setRight(addRecursive(current.getRight(), value));
	    } else {
	        return current;
	    }

	    return current;
	}

	
	public static void preOrderTraversal(BinaryTreeNode bt) {
		if(bt !=null) {
			System.out.print(bt.getData() + " ");
			preOrderTraversal(bt.getLeft());
			preOrderTraversal(bt.getRight());
		}
	}
	public static void postOrderTraversal(BinaryTreeNode bt) {
		if(bt !=null) {
			postOrderTraversal(bt.getLeft());
			postOrderTraversal(bt.getRight());
			System.out.print(bt.getData() + " ");
		}
	}
	public static void inOrderTraversal(BinaryTreeNode bt) {
		if(bt !=null) {
			inOrderTraversal(bt.getLeft());
			System.out.print(bt.getData() + " ");
			inOrderTraversal(bt.getRight());
		}
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    System.out.println("\nPre Order travelsal");
	    preOrderTraversal(bt.getRoot());
	    System.out.println("\nPost Order travelsal");
	    postOrderTraversal(bt.getRoot());
	    System.out.println("\nIn Order travelsal");
	    inOrderTraversal(bt.getRoot());
	    System.out.println("\nIs BST = " + isBST(bt));
	}
	
	static boolean isBST(BinaryTree bt) {
		BinaryTreeNode rootNode = bt.getRoot();
		return checkRecurrsively(rootNode);
	}

	private static boolean checkRecurrsively(BinaryTreeNode node) {
		if(node != null) {
			/* False if left is > than node */
		    if (node.getLeft() != null && node.getLeft().getData() > node.getData())
		        return false;
		     
		    /* False if right is < than node */
		    if (node.getRight() != null && node.getRight().getData() < node.getData())
		        return false;
		     
		    /* False if, recursively, the left or right is not a BST */
		    if (!checkRecurrsively(node.getLeft()) || !checkRecurrsively(node.getRight()))
		        return false;
		     
		    /* Passing all that, it's a BST */
		    return true;
		} else {
			return true;
		}
	}

	
}
