package myStack;

class Node1{
	//java program to implements queue data structure using linked list 
	int data;
	Node1 next;
	
	Node1(int d) {
		this.data = d;
		this.next = null;
	}
}
class Queue{
	Node1 front, rear;
	
	Queue(){
		front = rear = null;
	}
	boolean isEmpty() {
		return front == null && rear == null;
	}
	void enqueue(int d) {
		Node1 new_node = new Node1(d);
		if(rear == null) {
			front = rear = new_node;
			return ;
		}
		rear.next = new_node;
		rear = new_node;
	}
	void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue UnderFlow!!!!");
			return ;
		}
		Node1 temp = front;
		front = front.next;
		if(front == null) {
			rear = null;
		}
	}
	public void displayQueue() {
		Node1 current = front;
		if(front == null) {
			System.out.println("\nStack is Empty !!!!......");
			return ;
		}
		System.out.println("\nThe Data in Queue !!!!!....");
		while(current != null) {
			System.out.print(current.data+" -> ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
}

public class QSll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		
		//Enqueue element into the queue
		q.enqueue(10);
		q.enqueue(20);
		
		q.displayQueue();
		
		q.dequeue();
		q.dequeue();
		
		q.displayQueue();
		
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		q.displayQueue();
		
	}

}
