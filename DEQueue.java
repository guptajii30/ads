package myPQueue;

import java.util.Scanner;

class Node6 {
    int data;
    Node6 prev, next;

    public Node6(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DEQueue {
    Node6 front;
    Node6 rear;
    int size;

    public DEQueue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    // Return the number of elements in the deque
    public int getSize() {
        return size;
    }

    // Insert an element at the front end
    public void insertFront(int data) {
        Node6 newNode = new Node6(data);
        if (newNode == null) {
            System.out.println("Overflow!!!!!\n");
        } else {
            // If deque is empty
            if (front == null) {
                rear = front = newNode;
            } else {
                newNode.next = front;
                front.prev = newNode;
                front = newNode; // Update front to the new node
            }
            size++; // Increment count of elements
        }
    }

    // Insert an element at the rear end
    public void insertRear(int data) {
        Node6 newNode = new Node6(data);
        if (newNode == null) {
            System.out.println("Overflow!!!!\n");
        } else {
            // If deque is empty
            if (rear == null) {
                front = rear = newNode;
            } else {
                newNode.prev = rear;
                rear.next = newNode;
                rear = newNode; // Update rear to the new node
            }
            size++; // Increment count of elements
        }
    }

    // Delete the element from the front end
    public void deleteFront() {
        // If deque is empty
        if (isEmpty()) {
            System.out.println("Underflow - Deque is Empty!!!\n");
        } else {
            front = front.next;
            // If only one element was present
            if (front == null) {
                rear = null;
            } else {
                front.prev = null;
            }
            size--; // Decrement count of elements
        }
    }

    // Delete the element from the rear end
    public void deleteRear() {
        // If deque is empty
        if (isEmpty()) {
            System.out.println("Underflow - Deque is Empty!!\n");
        } else {
            rear = rear.prev;
            // If only one element was present
            if (rear == null) {
                front = null;
            } else {
                rear.next = null;
            }
            size--; // Decrement count of elements
        }
    }

    // Return the element from the front end
    public int getFront() {
        // If deque is empty, return -1
        if (isEmpty())
            return -1;
        return front.data;
    }

    // Return the element at the rear end
    public int getRear() {
        // If deque is empty, return -1
        if (isEmpty())
            return -1;
        return rear.data; // Corrected to return rear.data
    }

    // Display the elements in the deque
    public void display() {
        Node6 current = front;
        if (current == null) {
            System.out.println("The Double Ended Queue Is Empty!!!!!");
            return;
        }
        System.out.print("The Data in Double Ended Queue are: ");
        System.out.print("Null <-- ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("Null\n");
    }

    // Delete all nodes in the deque
    public void deleteAllNodes() {
        rear = null;
        while (front != null) {
            front = front.next;
        }
        size = 0;
    }

    public static void main(String[] args) {
        DEQueue dq = new DEQueue();
        Scanner sc = new Scanner(System.in);

        int data;
        int choice;
        do {
            System.out.print("\n1. Insert At Front\n");
            System.out.print("2. Insert At Rear\n");
            System.out.print("3. Delete At Front\n");
            System.out.print("4. Delete At Rear\n");
            System.out.print("5. Delete All Nodes\n");
            System.out.print("6. Display List\n");
            System.out.print("7. Exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nInsert at Front - Enter data: ");
                    data = sc.nextInt();
                    dq.insertFront(data);
                    dq.display();
                    break;
                case 2:
                    System.out.print("\nInsert at Rear - Enter data: ");
                    data = sc.nextInt();
                    dq.insertRear(data);
                    dq.display();
                    break;
                case 3:
                    System.out.print("\nDelete at Front\n");
                    dq.deleteFront();
                    dq.display();
                    break;
                case 4:
                    System.out.print("\nDelete at Rear\n");
                    dq.deleteRear();
                    dq.display();
                    break;
                case 5:
                    System.out.print("\nDelete All Nodes\n");
                    dq.deleteAllNodes();
                    dq.display();
                    break;
                case 6:
                    System.out.print("\nDisplay List:\n");
                    dq.display();
                    break;
                case 7:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("\nWrong choice!");
            }
        } while (choice != 7);
        sc.close();
    }
}
