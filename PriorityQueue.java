package myPQueue;

class Node4{
	Node4 next;
	int data;
	int priority;//lower values indicate =(lower value= higher priority)
	
	public Node4(int d, int p) {
		this.data = d;
		this.priority = p;
		this.next = null;
	}	
}

public class PriorityQueue {
	Node4 head;
	
	public PriorityQueue() {
		head = null;
	}
	public void add(int d, int p) {
		Node4 start = head;
		Node4 newNode = new Node4(d, p);
		if(head == null) {
			head = newNode;
			return ;
		}
		if(head.priority > p) {
			newNode.next = head;
			head = newNode;
		}else {
			 // Case 2: Traverse and find the correct position to insert the new node
			while (start.next != null && start.next.priority <= p) {
				start = start.next;
			}
			newNode.next = start.next;
			start.next = newNode;
		}
	}
		 // Method to remove the node with the highest priority (lowest priority value)
		public Node4 remove() {
			Node4 temp = head;
			head = head.next;
			temp = null;
			return head;
		}
		int getHeadData() {
			return head.data;
		}
		public boolean isEmpty() {
			return head == null;// Return true if the queue is empty
		}
		
		public void display() { 
			if(head == null) {
				System.out.println("Priority queue is empty !!!!!........");
				System.out.println("Data in Priority Queue: ");
				return;
			}
			Node4 start = head;
			while(start != null) {
				System.out.println("Data: " + start.data + ", Priority: " + start.priority);
				start = start.next;
			}     
			System.out.println("NULL\n");
	}
	public static void main (String args []) {
			PriorityQueue pq = new PriorityQueue();
			pq.add(0, 4); //(data: 0, priority: 4)
			pq.add(1, 3);
			pq.add(2, 2);
			pq.add(3, 1);
			pq.add(4, 0);
			
			//System.out.println("Head Node Data: "+pq.getHeadData());
			
			while(!pq.isEmpty()) {
				System.out.println("Head Node Data: "+pq.getHeadData());
				pq.remove();
				pq.display();
			}
			
		}
	}

