package com.practice.SLL;

public class SLLOperations {
private SLLNode head;
private int length = 0;

public SLLNode getHead() {
	return head;
}
public void setHead(SLLNode head) {
	this.head = head;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}

public SLLNode createNewNode(int data){
	return new SLLNode(data);
}

public void insertAtBegin(int data){
	SLLNode newNode = createNewNode(data);
	
	if(head == null){
		head = newNode;
		length++;
		return;
	}
	newNode.setNext(head);
	head = newNode;
	length++;
	return;
}

public void insertAtEnd(int data){
	SLLNode newNode = createNewNode(data);
	
	if(head == null){
		head = newNode;
		length++;
		return;
	}
	
	SLLNode currentNode = head;
	while(currentNode.getNext() != null){
		currentNode = currentNode.getNext();
	}
	currentNode.setNext(newNode);
	length++;
	return;
}

public boolean searchNumber(int data){
	if(head == null){
		return false;
	}
	SLLNode currentNode = head;
	while(currentNode != null){
		if(currentNode.getData() == data){
			return true;
		}
		currentNode = currentNode.getNext();
	}
	return false;
}

public boolean deleteNumber(int data){
	if(head == null){
		return false;
	}
	if(length == 1){
		if(head.getData() == data){
			head = null;
			length--;
			return true;
		}
		return false;
	}
	if(head.getData() == data){
		head = head.getNext();
		length--;
		return true;
	}
	SLLNode currentNode = head;
	SLLNode prevNode = null;
	while(currentNode != null && currentNode.getData() != data){
		prevNode = currentNode;
		currentNode = currentNode.getNext();
	}
	if(currentNode == null){
		return false;
	}
	prevNode.setNext(currentNode.getNext());
	currentNode.setNext(null);
	length--;
	return true;
	
}

public boolean deleteNodeByIndex(int index){
	if(index < 0 || index > length -1 || head == null){
		return false;
	}
	
		if(length == 1){
			if(index == 0){
				head = null;
				length--;
				return true;
			}
			return false;
		}
		
		if(index == 0){
			head = head.getNext();
			length--;
			return true;
		}
		
	int indexPtr  = 0;
	SLLNode currentNode = head;
	SLLNode prevNode = null;
	while(currentNode != null && indexPtr != index){
		prevNode = currentNode;
		currentNode = currentNode.getNext();
		indexPtr++;
	}
	prevNode.setNext(currentNode.getNext());
	currentNode.setNext(null);
	length--;
	return true;
}

public void reverseRecursive(SLLNode currentNode,SLLNode prevNode){
	if(currentNode.getNext() != null){
		head = currentNode.getNext();
		reverseRecursive(currentNode.getNext(), currentNode);
	}
	currentNode.setNext(prevNode);
	prevNode.setNext(null);
}

public void reverseIterative(){
	if(length == 1 || head == null){
		return;
	}
	SLLNode prevNode = null;
	SLLNode nextNode = head;
	SLLNode currentNode = head;
	
	while(nextNode != null){
		nextNode = currentNode.getNext();
		currentNode.setNext(prevNode);
		prevNode = currentNode;
		currentNode = nextNode;
	}
	head =prevNode;
}

public void displayLL(){
	if(head == null){
		System.out.println("Linked List is Empty");
		return;
	}
	
	SLLNode currentNode = head;
	while(currentNode != null){
		System.out.print(currentNode.getData() + "-->");
		currentNode = currentNode.getNext();
	}
	System.out.println("length" + length);
}

}
