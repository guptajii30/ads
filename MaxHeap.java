package myStack;


class Node7{
	int data;
	Node7 prev, next;
	
	Node7(int val){
		this.data=val;
		this.prev=null;
		this.next=null;
	}
}

public class MaxHeap {
	Node7 head, tail;
	
	public MaxHeap() {
		this.head=null;
		this.tail=null;
	}
	
	private void reheapUp(Node7 node) {
		Node7 parent = getParent(node);
		while(parent!= null&& node.data> parent.data) {
			int temp=node.data;
			node.data=parent.data;
			parent.data=temp;
			node=parent;
			parent=getParent(node);
		}
	}
	
	private void reheapDown(Node7 node) {
		while (node!=null) {
			Node7 leftChild=node.next;
			Node7 rightChild=(leftChild!=null)?leftChild.next:null;
			
			if(leftChild==null) {
				break;
			}
			
			Node7 maxChild=leftChild;
			if(rightChild!=null&&rightChild.data>leftChild.data) {
				maxChild=rightChild;
			}
			
			int temp=node.data;
			node.data=maxChild.data;
			maxChild.data=temp;
			node=maxChild;
		}
	}
	
	public void insert(int data) {
		Node7 newNode=new Node7(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			
			reheapUp(newNode);
		}
	}
	
	public void delete() {
		if(head==null) {
			System.out.println("Heap is empty!");
			return;
		}
		Node7 lastNode=tail;
		
		head.data=lastNode.data;
		
		if(tail.prev!=null) {
			tail=tail.prev;
			tail.next=null;
		}
		else {
			head=null;
		}
		reheapDown(head);
	}
	
	private Node7 getParent(Node7 node) {
		return node.prev;
	}
	
	public void printHeap() {
		Node7 temp=head;
		while(temp!=null) {
			System.out.println(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap maxHeap = new MaxHeap();
		
		System.out.println("\nInserting Valu into MaxHeap");
		maxHeap.insert(10);
		maxHeap.insert(20);
		maxHeap.insert(5);
		maxHeap.insert(8);
		maxHeap.printHeap();
		
		System.out.println("Deleting root node from MaxHeap:");
		maxHeap.delete();
		maxHeap.printHeap();
	}

}
