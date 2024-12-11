package myStack;

class Node{
	//java program to implements stack using Singly linked list 
	int data;
	Node next;
	
	Node(int d) {
		this.data = d;
		this.next = null;
	}
}

class Stack{
	Node head;
	
	Stack() {
		this.head = null;
	}
	Boolean isEmpty(){
		return head == null;
	}
	void push(int d) {
		Node newNode = new Node(d);
		if (newNode == null) {
			System.out.println("\nStack is OverFlow !!!!!!.......");
			return ;
		}
		newNode.next = head;
		head = newNode;
	}
	void pop() {
		if(isEmpty()) {
			System.out.println("\nStack is UnderFlow !!!!....");
			return ;
		}else {
			Node temp = head;
			head = head.next;
			temp = null;
		}
	}
	int peek() {
	    if (!isEmpty()) { // Check if the stack is NOT empty
	        return head.data;
	    } else {
	        System.out.println("\nStack is Empty !!!!.....");
	        return Integer.MIN_VALUE;
	    }
	}
	public void displayStack() {
		Node current = head;
		if(head == null) {
			System.out.println("\nStack is Empty !!!!......");
			return ;
		}
		System.out.println("\nThe Data in Stack !!!!!....");
		while(current != null) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
}

public class StackSll {
	public static void main(String args []) {
		Stack st = new Stack();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.displayStack();
		System.out.println("Top Element is "+st.peek());
		
		st.pop();
		st.pop();
		st.displayStack();
		System.out.println("Top Element is "+st.peek());
		
	}
}
