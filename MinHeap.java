package myStack;

class Node6 {
    int data;
    Node6 prev, next;

    // Constructor to create a new node
    public Node6(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class MinHeap {
    Node6 head, tail;

    public MinHeap() {
        this.head = null;
        this.tail = null;
    }

    // Insert a new node into the heap
    public void insert(int data) {
        Node6 newNode = new Node6(data);
        if (head == null) {
            // If the heap is empty, make this node the head and tail
            head = newNode;
            tail = newNode;
        } else {
            // Add the new node to the end of the list (tail)
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

            // Reheap Up from the newly added node
            reheapUp(newNode);
        }
    }

    // Get parent of a node (linked list implementation)
    private Node6 getParent(Node6 node) {
        if (node == null || node == head) {
            return null; // Head has no parent
        }

        // Calculate index of the current node
        int index = 0;
        Node6 temp = head;
        while (temp != null && temp != node) {
            temp = temp.next;
            index++;
        }

        // Parent index formula for a binary heap
        int parentIndex = (index - 1) / 2;

        // Traverse to the parent node
        temp = head;
        while (parentIndex-- > 0 && temp != null) {
            temp = temp.next;
        }

        return temp;
    }

    // Reheap Up for MinHeap
    private void reheapUp(Node6 node) {
        Node6 parent = getParent(node);

        while (parent != null && node.data < parent.data) {
            // Swap the node with its parent
            int temp = node.data;
            node.data = parent.data;
            parent.data = temp;

            node = parent;
            parent = getParent(node);
        }
    }

    // Reheap Down for MinHeap
    private void reheapDown(Node6 node) {
        while (node != null) {
            Node6 leftChild = getLeftChild(node);
            Node6 rightChild = getRightChild(node);

            // If there are no children, stop
            if (leftChild == null) {
                break;
            }

            // Find the smaller of the two children
            Node6 minChild = leftChild;
            if (rightChild != null && rightChild.data < leftChild.data) {
                minChild = rightChild;
            }

            // If the node is less than or equal to its smallest child, stop
            if (node.data <= minChild.data) {
                break;
            }

            // Swap node with the smallest child
            int temp = node.data;
            node.data = minChild.data;
            minChild.data = temp;

            node = minChild;
        }
    }

    // Get left child of a node
    private Node6 getLeftChild(Node6 node) {
        int index = 0;
        Node6 temp = head;

        // Find index of the current node
        while (temp != null && temp != node) {
            temp = temp.next;
            index++;
        }

        // Left child index formula for a binary heap
        int leftChildIndex = 2 * index + 1;

        // Traverse to the left child node
        temp = head;
        while (leftChildIndex-- > 0 && temp != null) {
            temp = temp.next;
        }

        return temp;
    }

    // Get right child of a node
    private Node6 getRightChild(Node6 node) {
        int index = 0;
        Node6 temp = head;

        // Find index of the current node
        while (temp != null && temp != node) {
            temp = temp.next;
            index++;
        }

        // Right child index formula for a binary heap
        int rightChildIndex = 2 * index + 2;

        // Traverse to the right child node
        temp = head;
        while (rightChildIndex-- > 0 && temp != null) {
            temp = temp.next;
        }

        return temp;
    }

    // Remove and return the minimum element (root)
    public int removeMin() {
        if (head == null) {
            throw new IllegalStateException("Heap is empty");
        }
        int minData = head.data;

        if (head == tail) {
            // If there's only one element
            head = null;
            tail = null;
        } else {
            // Replace head with tail's data
            head.data = tail.data;

            // Remove the tail node
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            // Reheap Down from the head
            reheapDown(head);
        }
        return minData;
    }

    // Print the heap
    public void printHeap() {
        Node6 temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        // Insert values into MinHeap
        System.out.println("Inserting values into MinHeap:");
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.printHeap(); // Print the heap in valid MinHeap order
        // Delete root from MinHeap
        System.out.println("Deleting root node from MinHeap:");
        System.out.println("Removed: " + minHeap.removeMin());
        minHeap.printHeap(); // Should print the heap after root node deletion
    }
}
