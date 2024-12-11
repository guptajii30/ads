package myGraph;
import java.util.Scanner;

class Edge {
    int src, dest, weight;

    // Constructor
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class KruskalAlogrithm {
    private int v; // Number of vertices
    private int e; // Number of edges
    private Edge[] edges; // Array of edges
    private int edgeCount = 0; // Counter for added edges

    // Constructor
    public KruskalAlogrithm(int vertices, int edgeCount) {
        this.v = vertices;
        this.e = edgeCount;
        edges = new Edge[edgeCount];
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        if (edgeCount < e) {
            edges[edgeCount++] = new Edge(src, dest, weight);
        } else {
            System.out.println("Cannot add more edges than declared. Check input!");
        }
    }

    // Find the parent of a vertex (with path compression)
    private int findParent(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = findParent(parent, parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    // Perform union of two sets
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = findParent(parent, x);
        int rootY = findParent(parent, y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // Sort the edges by weight using bubble sort
    private void sortEdge() {
        for (int i = 0; i < e - 1; i++) {
            for (int j = 0; j < e - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    // Kruskal's algorithm to find the MST
    public void kruskalMST() {
        // Sort edges by weight
        sortEdge();

        // Arrays for union-find
        int[] parent = new int[v];
        int[] rank = new int[v];

        // Initialize union-find structure
        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        Edge[] mst = new Edge[v - 1]; // Array to store the MST edges
        int mstIndex = 0; // Index for MST edges
        int mstWeight = 0; // Total weight of the MST

        // Iterate through the sorted edges
        for (int i = 0; i < e && mstIndex < v - 1; i++) {
            Edge edge = edges[i];
            int srcParent = findParent(parent, edge.src);
            int destParent = findParent(parent, edge.dest);

            // If adding this edge doesn't form a cycle
            if (srcParent != destParent) {
                mst[mstIndex++] = edge; // Include the edge in MST
                mstWeight += edge.weight;
                union(parent, rank, srcParent, destParent); // Merge sets
            }
        }

        // Print MST
        System.out.println("Edges in the MST:");
        System.out.println("Source -> Destination : Weight");
        for (int i = 0; i < mstIndex; i++) {
            System.out.println(mst[i].src + " -- " + mst[i].dest + " == " + mst[i].weight);
        }
        System.out.println("Total Weight of MST: " + mstWeight);
    }

    // Main method to test the program
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Vertices: ");
        int v = sc.nextInt();

        System.out.println("Enter the Number of Edges: ");
        int e = sc.nextInt();

        KruskalAlogrithm graph = new KruskalAlogrithm(v, e);

        System.out.println("Enter the Edges in the Format: Source Destination Weight");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            // Validate input
            if (src >= 0 && src < v && dest >= 0 && dest < v) {
                graph.addEdge(src, dest, weight);
            } else {
                System.out.println("Invalid edge: vertices must be in range [0, " + (v - 1) + "]. Please re-enter:");
                i--; // Re-enter this edge
            }
        }

        graph.kruskalMST();
        sc.close();
    }
}
