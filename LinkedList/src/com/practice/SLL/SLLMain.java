package com.practice.SLL;

public class SLLMain {
        public static void main(String[] args) {
		  SLLOperations sllops = new SLLOperations();
		  sllops.insertAtBegin(1);
		  sllops.insertAtBegin(2);
		  sllops.insertAtEnd(3);
		  sllops.insertAtBegin(4);
		  sllops.displayLL();
		  sllops.deleteNodeByIndex(0);
		  System.out.println("after deleting index");
		  sllops.displayLL();
		  sllops.deleteNumber(3);
		  sllops.deleteNumber(1);
		  sllops.deleteNumber(2);
		  System.out.println("after deleting number");
		  sllops.displayLL();
		  sllops.insertAtBegin(1);
		  sllops.insertAtBegin(2);
		  sllops.insertAtEnd(3);
		  sllops.insertAtBegin(4);
		  sllops.insertAtEnd(5);
		  sllops.displayLL();
		  sllops.reverseIterative();
		  System.out.println("after reversing");
		  sllops.displayLL();
		  sllops.reverseRecursive(sllops.getHead(), sllops.getHead());
		  System.out.println("after reversing");
		  sllops.displayLL();
		  
		}
}
