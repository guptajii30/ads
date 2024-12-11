package myPoly;

//addition of polynomial Equation using LinkedList
class Node3{
	int coeff;
	int pow;
	Node3 next;
	
	public Node3(int c,int p) {
		coeff = c;
		pow = p;
		next = null;
	}
}
public class PolyAdd {
	static Node3 addPolynomial(Node3 head1, Node3 head2) {
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		if(head1.pow > head2.pow) {
			Node3 nextPtr = addPolynomial(head1.next, head2);
			head1.next = nextPtr;
			return head1;
		}
		else if(head1.pow<head2.pow) {
			Node3 nextPtr = addPolynomial(head1, head2.next);
			head2.next = nextPtr;
			return head2;
		}
		Node3 nextPtr = addPolynomial(head1.next, head2.next);
		head1.coeff = head1.coeff + head2.coeff;
		head1.next = nextPtr;
		return head1;
	}
	static void printPloynomialAddition(Node3 head) {
		Node3 current = head;
		while(current != null) {
			System.out.print(current.coeff+"X"+ current.pow+" --> ");
			
			current = current.next;
		}
		System.out.print(" NULL");
	}
	public static void main(String args[]) {
		//create first polynomial equation 
		Node3 head1 = new Node3(4, 3);
		head1.next = new Node3(3, 2);
		head1.next.next = new Node3(3 , 0);
		
		Node3 head2 = new Node3(2 , 1);
		head2.next = new Node3(-7, 0);
		
		Node3 head = addPolynomial(head1, head2);
		printPloynomialAddition(head);
	}
}
