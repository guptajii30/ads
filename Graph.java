package myGraph;
import java.util.Scanner;
public class Graph {
	private int [][]adjcencyMatrix;
	private int numVertices;
	
	public Graph (int numVertices) {
		this.numVertices = numVertices;
		adjcencyMatrix = new int[numVertices][numVertices];
	}
	//method to add an edge to the graph
	public void addEdge(int start, int end) {
		adjcencyMatrix[start][end]= 1;
		adjcencyMatrix[end][start]= 1;//for an unidirected graph
	}
	//Breadth First Search (BFS)
	public void bfs(int startVertex) {
		boolean[] visited = new boolean[numVertices];
		int[] queue = new int [numVertices];
		int front = 0, rear = 0;
		
		//mark the start vertex as visited and enqueue it
		visited[startVertex]= true;
		queue[rear++]= startVertex;
		
		System.out.println("BFS Traversal Starting From Vertex "+startVertex+":");
		while(front<rear) {
			int currentVertex = queue[front++];//Dequeue
			System.out.println(currentVertex+" ");
			
			//Enqueue all adjacent unvisited vertices
			for(int i = 0; i<numVertices; i++) {
				if (adjcencyMatrix[currentVertex][i]==1 && !visited[i]) {
					visited[i] = true;
					queue[rear++] = i;
				}
			}
		}
		System.out.println();
	}
	//depth first search(DFS)
	public void dfs(int startVertex) {
		boolean[] visited = new boolean[numVertices];
		int[] stack = new int [numVertices];
		int top = -1;
		
		//push the start vertex onto the stack and mark it as visited 
		stack[++top] = startVertex;
		visited[startVertex] = true;
		
		System.out.println("DFS Traversal Starting From Vertex "+startVertex+":");
		while(top>=0) {
			int currentVertex = stack[top--];//pop the stack\
			System.out.println(currentVertex+" ");
			
			//push all adjacent unvisited vertices onto the stack
			for(int i = numVertices-1; i>=0; i--) {
				//reverse order to the mimic recursion
				if (adjcencyMatrix[currentVertex][i] == 1 && !visited[i]) {
					visited[i] = true;
					stack[++top] = i;
				}
			}
		}
		System.out.println();
	}
	//method to display the adjacency matrix
	public void displayAdjacencyMatrix() {
		System.out.println("Adjacency Matrix: ");
		for(int i = 0; i<numVertices; i++) {
			for(int j = 0; j<numVertices; j++){//edges 
				System.out.print(adjcencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter The Number Of Vertices: ");
		int numVertices = sc.nextInt();
		
		Graph gh = new Graph(numVertices);
		
		System.out.println("Enetr The Number Of Edge: ");
		int numEdges = sc.nextInt();
		
		System.out.println("Enter The Edge (Source and Destination): ");
		for(int i = 0; i<numEdges; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			gh.addEdge(src, dest);
		}
		gh.displayAdjacencyMatrix();
		
		System.out.println("Enter the Start Vertex for BFS: ");
		int bfsStartVertex = sc.nextInt();
		gh.bfs(bfsStartVertex);
		
		System.out.println("Enetr the Start vertex for DFS: ");
		int dfsStartVertex = sc.nextInt();
		gh.dfs(dfsStartVertex);
		
		sc.close();
	}
}
