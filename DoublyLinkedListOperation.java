package myStack;
import java.io.*;
//Java program for the above approach 

class Node2 { 
	Node2 prev; 
	int data; 
	Node2 next; 

	// A constructor is called here 
	Node2(int value) 
	{ 
		// By default previous pointer is 
		// pointed to NULL 
		prev = null; 

		// Value is assigned to the data 
		data = value; 

		// By default next pointer is pointed 
		// to NULL 
		next = null; 
	} 
} 
public class DoublyLinkedListOperation{ 
	// Declaring an empty doubly linked list 
	static Node2 head = null; 
	static Node2 tail = null; 
	static void insertAtBeginning(int data) 
	{ 
		Node2 temp = new Node2(data); 
		if (head == null) { 
			head = temp; 
			tail = temp; 
		} 
		else { 
			temp.next = head; 
			head.prev = temp; 
			head = temp; 
		} 
	} 
	static void insertAtEnd(int data) 
	{ 
		Node2 temp = new Node2(data); 
		if (tail == null) { 
			head = temp; 
			tail = temp; 
		} 
		else { 
			tail.next = temp; 
			temp.prev = tail; 
			tail = temp; 
		} 
	} 
	static void insertAtPosition(int data, int position) 
	{ 
		Node2 temp = new Node2(data); 
		if (position == 1) { 
			insertAtBeginning(data); 
		} 
		else { 
			Node2 current = head; 
			int currPosition = 1; 
			while (current != null
				&& currPosition < position) { 
				current = current.next; 
				currPosition++; 
			} 
			if (current == null) { 
				insertAtEnd(data); 
			} 
			else { 
				temp.next = current; 
				temp.prev = current.prev; 
				current.prev.next = temp; 
				current.prev = temp; 
			} 
		} 
	} 
	static void deleteAtBeginning() 
	{ 
		if (head == null) { 
			return; 
		} 
		if (head == tail) { 
			head = null; 
			tail = null; 
			return; 
		} 
		Node2 temp = head; 
		head = head.next; 
		head.prev = null; 
		temp.next = null; 
	} 
	static void deleteAtEnd() 
	{ 
		if (tail == null) { 
			return; 
		} 

		if (head == tail) { 
			head = null; 
			tail = null; 
			return; 
		} 

		Node2 temp = tail; 
		tail = tail.prev; 
		tail.next = null; 
		temp.prev = null; 
	} 
	static void deleteAtSpecificPosition(int pos) 
	{ 
		if (head == null) { 
			return; 
		} 
		if (pos == 1) { 
			deleteAtBeginning(); 
			return; 
		} 
		Node2 current = head; 
		int count = 1; 

		while (current != null && count != pos) { 
			current = current.next; 
			count++; 
		} 
		if (current == null) { 
			System.out.println("Position wrong"); 
			return; 
		} 
		if (current == tail) { 
			deleteAtEnd(); 
			return; 
		} 
		current.prev.next = current.next; 
		current.next.prev = current.prev; 
		current.prev = null; 
		current.next = null; 
	} 
	static void display(Node2 head) 
	{ 
		Node2 temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " --> "); 
			temp = temp.next; 
		} 
		System.out.println("NULL"); 
	} 
	// Drivers code 
	public static void main(String[] args) 
	{ 
		insertAtEnd(1); 
		insertAtEnd(2); 
		insertAtEnd(3); 
		insertAtEnd(4); 
		insertAtEnd(5); 

		System.out.print("After insertion at tail: "); 
		display(head); 

		System.out.print("After insertion at head: "); 
		insertAtBeginning(0); 
		display(head); 

		insertAtPosition(6, 2); 
		System.out.print( 
			"After insertion at 2nd position: "); 
		display(head); 

		deleteAtBeginning(); 
		System.out.print( 
			"After deletion at the beginning: "); 
		display(head); 

		deleteAtEnd(); 
		System.out.print("After deletion at the end: "); 
		display(head); 

		deleteAtSpecificPosition(2); 
		System.out.print( 
			"After deletion at 2nd position: "); 
		display(head); 
	} 
}
