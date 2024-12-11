package myStack;
//java program to implement singly linked list
import java.util.Scanner;

class Node4{
	int data;
	Node4 next;

	public Node4(int data) {
		this.data = data;
		this.next = null;
	}
}

public class SinglyLinkedList {
	// defining the head and tail of a singly linked list
		Node4 head;
		Node4 tail;

		public SinglyLinkedList() {
			head = null;
			tail = null;
		}

		public boolean isEmpty() {
			return (head == null);
		}

		// function to add a node to the list
		public void insert(int data) {
			Node4 newNode = new Node4(data);
			// if(isEmpty()){}
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}

		// function to add a node at head
		public void insertAtHead(int data) {
			Node4 newNode = new Node4(data);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
		}

		// function to add a node at tail
		public void insertAtTail(int data) {
			Node4 newNode = new Node4(data);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}

		// insert node between head and tail
		public void insertAtPosition(int pos, int data) {
			Node4 newNode = new Node4(data);
			int totalNodes = countNodes();

			Node4 prev = null, current = head;
			// if list is empty
			if (head == null) {
				head = newNode;
				tail = newNode;
			}
			// insert at head
			else if (pos == 1) {
				newNode.next = head;
				head = newNode;
			}
			// Insert at position
			else if (pos > 1 && pos <= totalNodes + 1) {
				// insert node at tail
				if (pos == totalNodes + 1) {
					tail.next = newNode;
					tail = newNode;
				}
				// Insert node between head and tail
				else {
					for (int i = 1; i < pos; i++) {
						prev = current;
						current = current.next;
					}
					newNode.next = current;
					prev.next = newNode;
				}
			} else {
				System.out.println("Invalid node position!");
			}
		}

		// delete node at head
		public void deleteAtHead() {
			if (head == null) {
				System.out.println("Singly linked list is empty!");
			} else {
				// If there's only one node in teh list, head and tail both become null
				if (head == tail) {
					head = tail = null;
				} else {
					// Otherwise, move the head pointer to the next node
					Node4 temp = head;
					head = head.next;
					temp = null;
				}
			}
		}

		// delete node at tail
		public void deleteAtTail() {
			if (head == null) {
				System.out.println("Singly linked list is empty!");
			} else if (head == tail) {
				// If there's only one node in the list, head and tail both become null

				head = tail = null;
			} else {
				Node4 current = head;
				while (current.next != tail) {
					current = current.next;
				}
				current.next = null; // Remove the last node
				tail = current; // Update the tail to the second last node
			}
		}
		
		// deleting node between head and tail
		public void deleteAtPosition(int pos) {
			Node4 prev = null, current = head;
			int totalNodes = countNodes();
			// if list is empty
			if(head == null) {
				System.out.println("Singly linked list is empty");
			}
			// if head is to be deleted
			else if (pos == 1) {
				Node4 temp=head;
				head = head.next;
				if(head==null) {
					// if there's only one node left
					tail = null;
				}
				temp = null;
			}
			else if(pos>1 && pos <=totalNodes) {
				for(int i=1;i<pos;i++) {
					prev = current;
					current = current.next;
				}
				//deleting last node
				if(current.next== null) {
					prev.next =null;
					tail = prev;
				}
				// Delete specific node between head and tail 
				else {
					prev.next = current.next;
				}
			}
			else {
				System.out.println("Invalid node position!");
			}
		}
		
		// function to display the data in the list
		public void displayList() {
			// Pointing the head to the node called current
			Node4 current = head;
			
			if(head == null) {
				System.out.println("The given list is empty!");
				return;
			}
			System.out.println("The data in the given list are: ");
			
			while(current!=null) {
				// Printing each data in the list and next pointer pointing to the next node
				System.out.print(current.data+" --> ");
				current = current.next;
			}
			System.out.print("Null");
			System.out.println();
		}

		//Function to count total nodes
		public int countNodes() {
			int count = 0;
			Node4 current = head;
			while(current!=null) {
				//Increment the count by 1 for each node
				count++;
				current = current.next;
			}
			return count;
		}
		
		// Reverse the node of list and print it
		public void reverseList() {
			Node4 curr = head, prev = null, temp;
			tail = curr;
			// Checks if list is empty
			if(head==null) {
				System.out.println("list is empty");
				return;
			}
			// Traverse all the nodes of linked list
			while(curr != null) {
				// Store next node in temp
				temp = curr.next;
				
				// Reverse current node's next pointer
				curr.next = prev;
				
				// Move pointers one position ahead
				prev =  curr;
				curr = temp;
			}
			head = prev; // prev is head
		}
		
		// printing nodes in reverse order 
//		public void displayListReverse() {
//			// Pointing the head to the node called current
//			Node current = head;
//			
//			if(head == null) {
//				System.out.println("The given list is empty!");
//				return;
//			}
//			System.out.println("The data in the given list are: ");
//			
//			while(current!=null) {
//				// Printing each data in the list and next pointer pointing to the next node
//				System.out.println(current.data+" --> ");
//				current = current.next;
//			}
//			System.out.println("Null");
//			System.out.println();
//		}
	//	
		
		// search key in linked list
		public void search(int key) {
			Node4 current = head;
			int flag=0;
			int pos = 1;
			while(current!=null) {
				if(current.data==key) {
					System.out.println("The "+key+" is found at "+pos+" position!");
					flag=1;
				}
				current=current.next;
				pos++;
			}
			
			if(flag==0) {
				System.out.println(key+" not found!");
			}
		}
		
		public static void main(String args[]) {
			SinglyLinkedList sll = new SinglyLinkedList();
			Scanner sc = new Scanner(System.in);
			int data, pos;
			int choice;
			
			do {
				System.out.println("1. Insert");
				System.out.println("2. Insert At Head");
				System.out.println("3. Insert At Tail");
				System.out.println("4. Insert At Position");
				System.out.println("5. Delete At Head");
				System.out.println("6. Delete at Tail");
				System.out.println("7. Delete At Position");
				System.out.println("8. Reverse List");
				System.out.println("9. Search for key");
				System.out.println("10. Total nodes");
				System.out.println("11. Display list");
				System.out.println("12. Exit");
				System.out.println("\nPlease Enter your choise: ");
				choice = sc.nextInt();
				switch (choice) {
				case 1: 
					System.out.println("\n Enter data: ");
					data = sc.nextInt();
					sll.insert(data);
					sll.displayList();
					break;
				case 2:
					System.out.println("\n Insert Node at head - Enter data: ");
					data = sc.nextInt();
					sll.insertAtHead(data);
					sll.displayList();
					break;
				case 3:
					System.out.println("\n Insert Node at Tail - Enter data: ");
					data = sc.nextInt();
					sll.insertAtTail(data);
					sll.displayList();
					break;
				case 4:
					System.out.println("\n Insert Node at Position - Enter position: ");
					pos = sc.nextInt();
					System.out.println("Enter the data: ");
					data = sc.nextInt();
					sll.insertAtPosition(pos, data);
					System.out.println();
					sll.displayList();
					break;
				case 5:
					System.out.println("\n Delete node at head: ");
					sll.deleteAtHead();
					sll.displayList();
					break;
				case 6:
					System.out.println("\n Delete node at tail: ");
					sll.deleteAtTail();
					sll.displayList();
					break;
				case 7:
					System.out.println("\n Delete node at position - Enter position: ");
					pos = sc.nextInt();
					sll.deleteAtPosition(pos);
					sll.displayList();
					break;
				case 8: 
					System.out.println("Reverse the SLL: ");
					sll.reverseList();
					sll.displayList();
					break;
				case 9:
					System.out.println("Enter a key to search:");
					int key = sc.nextInt();
					sll.search(key);
					break;
				case 10:
					System.out.println("Total nodes in SLL: "+sll.countNodes());
					break;
				case 11:
					System.out.println("Print all nodes in SLL: ");
					sll.displayList();
					break;
				case 12:
					System.out.println("Exiting the program.");
					break;
				default:
					System.out.println("You entered wrong choice!");
				}
			}while(choice!=12);
			sc.close();
			
		}
	}
	
