package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {
	
	public static boolean flag = false;
	
	//insert into BST recursive
	public BSTNode insertRecursive(BSTNode root,int data){
		if(root == null){
			root = getNewBSTNode(data);
		}
		else if(data <= root.getData()){
			 root.setLeft(insertRecursive(root.getLeft(),data));
		}
		else{
			 root.setRight(insertRecursive(root.getRight(),data));
		}
		return root;
	}
	
	//insert into BST iterative
	public BSTNode insertIterative(BSTNode root,int data){
		if(root == null){
			root = getNewBSTNode(data);
			return root;
		}
		BSTNode rootNode = root;
		
		while(true){
			if(data <= root.getData()){
				if(root.getLeft() != null){
					root = root.getLeft();
				}
				else{
				root.setLeft(getNewBSTNode(data));
				break;
				}
			}
			else{
				if(root.getRight() != null){
					root = root.getRight();
				}
				else{
				root.setRight(getNewBSTNode(data));
				break;
				}
			}
		}
		
		return rootNode;
	}

	private BSTNode getNewBSTNode(int data) {
		BSTNode newNode = new BSTNode();
		newNode.setData(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		return newNode;
	}
	
	//search BST recursive
	public boolean searchRecursive(BSTNode root,int data){
		if(root == null ){
			return false;
		}
		if(root.getData() == data){
			return true;
		}
		if(data < root.getData()){
			return searchRecursive(root.getLeft(), data);
		}
		else{
			return searchRecursive(root.getRight(), data);
		}
	}
	
	//search BST iterative
	public boolean searchIterative(BSTNode root,int data){
		while(true){
			if(root == null){
				return false;
			}
			if(root.getData() == data){
				return true;
			}
			if(data < root.getData()){
				root = root.getLeft();
			}
			else{
				root = root.getRight();
			}
		}
	}
	
	//delete BSTNode recursive
	public BSTNode deleteNodeRecursive(BSTNode root,int data){
		if(root == null){
			return root;
		}
		else if(data < root.getData()){
			root.setLeft(deleteNodeRecursive(root.getLeft(), data));
		}
		else if(data > root.getData()){
			root.setRight(deleteNodeRecursive(root.getRight(), data));
		}
		else{
			if(root.getLeft() == null && root.getRight() == null){
				root = null;
			}
			else if(root.getLeft() != null && root.getRight() == null){
				BSTNode temp = root;
				root = root.getLeft();
				temp = null;
			}
			else if(root.getLeft() == null && root.getRight() != null){
				BSTNode temp = root;
				root = root.getRight();
				temp = null;
			}
			else{
				BSTNode min = FindMin(root.getRight());
				root.setData(min.getData());
				root.setRight(deleteNodeRecursive(root.getRight(), min.getData()));
			}
		}
		return root;
	}

	private BSTNode FindMin(BSTNode root) {
		while(root.getLeft() != null){
			root = root.getLeft();
		}
		return root;
		
	}
	
	//find height of tree recursive
	public int findHeightRecursive(BSTNode root){
		if(root == null){
			return -1;
		}
		
		return findMax(findHeightRecursive(root.getLeft()),findHeightRecursive(root.getRight())) + 1;
	}

	private int findMax(int findHeight, int findHeight2) {
		return findHeight > findHeight2 ? findHeight : findHeight2;
	}
	
	//print in preOrder 
	public void printPreOrder(BSTNode root){
		if(root == null){
			return;
		}
		System.out.print(root.getData() + ",");
		printPreOrder(root.getLeft());
		printPreOrder(root.getRight());
	}
	//print in InOrder 
	public void printInOrder(BSTNode root){
		if(root == null){
			return;
		}
		printInOrder(root.getLeft());
		System.out.print(root.getData() + ",");
		printInOrder(root.getRight());
	}
	
	//common LCA
	public BSTNode commonLCA(BSTNode root,int a,int b){
		if(root == null || root.getData() == a || root.getData() == b){
			return root;
		}
		
		BSTNode left = commonLCA(root.getLeft(), a, b);
		BSTNode right = commonLCA(root.getRight(), a, b);
		
		if(left != null && right != null){
			return root;
		}
		
		if(left != null){
			return left;
		}
		return right;
	}
	
	//cloned binary tree
	public void cloneBinaryTree(BSTNode root){
		if(root == null){
			return;
		}
		cloneBinaryTree(root.getLeft());
		cloneBinaryTree(root.getRight());
		if(root != null && (root.getLeft() != null || root.getRight() != null)){
			BSTNode temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
	}
	
	//print level that has maximum sum
	
	public int maxSumLevel(BSTNode root){
		if(root == null){
			return -1;
		}
		
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.offer(root);
		int level = 0;
		int sum = 0;
		int maxSum = 0;
		int maxLevel = 0;
		
		while(!q.isEmpty()){
			int count = q.size();
			while(count != 0){
				BSTNode node = (BSTNode) q.poll();
				sum = sum + node.getData();
				if(node.getLeft() != null){
					q.offer(node.getLeft());
				}
				if(node.getRight() != null){
					q.offer(node.getRight());
				}
				count--;
			}
			if(sum > maxSum){
				maxSum = sum;
				maxLevel = level;
			}
			sum = 0;
			level++;
		}
		return maxLevel;
	}
	
	//size of tree
	public int countNodes(BSTNode root,int count){
		if(root == null){
			return count;
		}
		count++;
		count = countNodes(root.getLeft(),count);
		count = countNodes(root.getRight(), count);
		return count;
	}
	
	//Inorder successor recursive
	public BSTNode inorderSuccessor(BSTNode root,int data,BSTNode successor){
		if(root == null){
			return successor;
		}
		successor = inorderSuccessor(root.getLeft(),data,successor);
		if(flag){
			flag = false;
			successor = root;
			return successor;
		}
		if(root.getData() == data && flag == false){
			flag = true;
		}
		successor = inorderSuccessor(root.getRight(),data,successor);
		return successor;
	}
	
	

}
