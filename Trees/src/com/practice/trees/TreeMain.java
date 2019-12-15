package com.practice.trees;

public class TreeMain {

	public static void main(String[] args) {
		TreeOperations ops = new TreeOperations();
		BSTNode root = ops.insertRecursive(null, 6);
		root = ops.insertIterative(root, 4);
		root = ops.insertRecursive(root, 7);
		root = ops.insertIterative(root, 3);
		root = ops.insertRecursive(root, 5);
		root = ops.insertIterative(root, 2);
		root = ops.insertRecursive(root, 11);
		root = ops.insertIterative(root, 10);
		
		ops.printPreOrder(root);
		System.out.println();
		ops.printInOrder(root);
		System.out.println();
		int height = ops.findHeightRecursive(root);
		System.out.println("height of tree: " + height);
		ops.deleteNodeRecursive(root, 7);
		System.out.println("Node with data 7 deleted");
		ops.printInOrder(root);
		System.out.println();
		System.out.println("data 7 found == " + ops.searchRecursive(root, 7));
		System.out.println("data 11 found == " + ops.searchIterative(root, 11));
		
		//System.out.println(ops.commonLCA(root, 7, 11).getData());
		//ops.cloneBinaryTree(root);
		System.out.println("Binary tree cloned inorder traversal is as below");
		ops.printInOrder(root);
		System.out.println();
		System.out.println("Binary tree cloned preorder traversal is as below");
		ops.printPreOrder(root);
		System.out.println();
		System.out.println("max level --> " + ops.maxSumLevel(root));
		
		System.out.println("Size of tree: " + ops.countNodes(root, 0));
		BSTNode successor = ops.inorderSuccessor(root, 11, null);
		if(successor != null){
		System.out.println("INORDER SUCCESSOR -->" + successor.getData());
		}
		
		
	}
}
