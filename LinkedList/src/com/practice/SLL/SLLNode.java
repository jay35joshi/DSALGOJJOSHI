package com.practice.SLL;

public class SLLNode {
private int data;
private SLLNode next;

SLLNode(int data){
	this.data = data;
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public SLLNode getNext() {
	return next;
}
public void setNext(SLLNode next) {
	this.next = next;
}
}
