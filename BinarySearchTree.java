package myStack;

import java.util.Scanner;

class Node0 {
    int data;
    Node0 left, right;

    Node0(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private Node0 root;
    static int count = 0;

    public BinarySearchTree() {
        this.root = null;
    }

    public static int nodeCounts() {
        return count;
    }

    // Insert node into Binary Search Tree
    public void insertNode(int val) {
        Node0 newNode = new Node0(val);
        if (root == null) {
            root = newNode;
            count++;
        } else {
            Node0 trav = root;
            Node0 hold = null;
            while (trav != null) {
                hold = trav;
                if (val > trav.data) {
                    trav = trav.right;
                } else if (val < trav.data) {
                    trav = trav.left;
                } else {
                    System.out.println("Duplicate data");
                    return;
                }
            }
            if (val > hold.data) {
                hold.right = newNode;
            } else {
                hold.left = newNode;
            }
            count++;
        }
    }

    // Inorder traversal
    public void inorder(Node0 root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    // Preorder traversal
    public void preorder(Node0 root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    // Postorder traversal
    public void postorder(Node0 root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postorder() {
        postorder(root);
    }

    // Finding the smallest element
    public void smallest() {
        Node0 trav = root;
        if (trav == null) {
            System.out.println("Tree is Empty!");
            return;
        }
        while (trav.left != null) {
            trav = trav.left;
        }
        System.out.println(trav.data);
    }

    // Finding the largest element
    public void largest() {
        Node0 trav = root;
        if (trav == null) {
            System.out.println("Tree is Empty!");
            return;
        }
        while (trav.right != null) {
            trav = trav.right;
        }
        System.out.println(trav.data);
    }

    // Search for a node
    public void search(int val) {
        Node0 trav = root;
        while (trav != null) {
            if (val > trav.data) {
                trav = trav.right;
            } else if (val < trav.data) {
                trav = trav.left;
            } else {
                System.out.println("Node with data " + val + " found.");
                return;
            }
        }
        System.out.println("Node with data " + val + " is not found.");
    }

    // Remove a node
    public void removeNode(int val) {
        root = removeNodeRecursive(root, val);
    }

    public Node0 removeNodeRecursive(Node0 root, int val) {
        if (root == null) {
            System.out.println("Node not found!");
            return root;
        }
        if (val < root.data) {
            root.left = removeNodeRecursive(root.left, val);
        } else if (val > root.data) {
            root.right = removeNodeRecursive(root.right, val);
        } else {
            if (root.left == null) {
                count--;
                return root.right;
            } else if (root.right == null) {
                count--;
                return root.left;
            }

            Node0 trav = root.left;
            while (trav.right != null) {
                trav = trav.right;
            }
            root.data = trav.data;
            root.left = removeNodeRecursive(root.left, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int data;
        int choice;

        System.out.println("Binary Search Tree\n");
        do {
            System.out.print("\n1. Insert Node\n");
            System.out.print("2. InOrder Traversal\n");
            System.out.print("3. PreOrder Traversal\n");
            System.out.print("4. PostOrder Traversal\n");
            System.out.print("5. Smallest Node\n");
            System.out.print("6. Largest Node\n");
            System.out.print("7. Count Nodes\n");
            System.out.print("8. Remove Node\n");
            System.out.print("9. Search Node\n");
            System.out.print("10. Exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nInsert Node - Enter data: ");
                    data = sc.nextInt();
                    bt.insertNode(data);
                    break;
                case 2:
                    System.out.print("\nInOrder Traversal: ");
                    bt.inorder();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("\nPreOrder Traversal: ");
                    bt.preorder();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("\nPostOrder Traversal: ");
                    bt.postorder();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("\nSmallest Node is: ");
                    bt.smallest();
                    break;
                case 6:
                    System.out.print("\nLargest Node is: ");
                    bt.largest();
                    break;
                case 7:
                    System.out.print("\nTotal node count: " + nodeCounts());
                    break;
                case 8:
                    System.out.print("\nRemove node - Enter key: ");
                    data = sc.nextInt();
                    bt.removeNode(data);
                    break;
                case 9:
                    System.out.print("\nSearch node - Enter Data: ");
                    data = sc.nextInt();
                    bt.search(data);
                    break;
                case 10:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.print("\nWrong choice! \n");
            }
        } while (choice != 10);
        sc.close();
    }
}
