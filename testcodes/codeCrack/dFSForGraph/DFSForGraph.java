package dFSForGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//create a class graph
class Graph{
	//v-> number of vertex
	int v;
	//array[] -> represents the array of linkedList as one vextex will be connected to miltiple node so using the linkedList for the connected Vertices.
	LinkedList<Integer> array[];
	
	Graph(int v){
		this.v = v;
		//initializing the array of linkedList
		array = new LinkedList[v];
		//Initializing the linked list for every index of array
		for(int i=0;i<v;i++){
			array[i] = new LinkedList<Integer>();
		}
		
	}
	
	void add(int vertex,int neighbourVertex)
	{
		array[vertex].add(neighbourVertex);
	}
}
public class DFSForGraph {
	Graph graph;

	int[] visited;
	Stack st;
	DFSForGraph(Graph graph){
		this.graph = graph;
		visited = new int[graph.v];
		st = new Stack<Integer>();
	}
	
	public void DFSUtil(int vertex)
	{
		visited[vertex] = 1;
		System.out.print(vertex+" ");
		
		//looping through the  vertices and calling DFSUtil recursively
		Iterator<Integer> itr = graph.array[vertex].listIterator();
		while(itr.hasNext())
		{
			int n = itr.next();
			if(visited[n]!=1)
			{
				DFSUtil(n);
			}
		}
	}
	
	public void DFSUndirectedGraph(int numberOfVetices){
		//if the graph is undirected then loop through all the vertex
		for(int i=0;i<numberOfVetices;i++)
		{
			DFSUndirectedGraph(i);
		}
	}
	
	/* In topological sorting, we use a temporary stack. 
	 * We don’t print the vertex immediately, 
	 * we first recursively call topological sorting for all its adjacent vertices, then push it to a stack. 
	 * Finally, print contents of stack. 
	 * Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in stack.*/
	public void TopologicalSort(int numberOfVetices)
	{
		for(int i=0;i<numberOfVetices;i++)
		{
			if(visited[i]!=1)
			{
				topologicalSortUtil(i);
			}	
		}
		
		while(!st.isEmpty())
		{
			System.out.print(st.pop()+" ");
		}
	}
	
	private void topologicalSortUtil(int vertex) {
		visited[vertex] = 1;
		
		Iterator<Integer> it = graph.array[vertex].listIterator();
		while(it.hasNext())
		{
			int n = it.next();
			if(visited[n]!=1)
			{
				topologicalSortUtil(n);
			}
		}
		
		st.push(vertex);
	}

	public static void main(String[] args) {

		Graph graph = new Graph(4);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 2);
		graph.add(2, 0);
		graph.add(2, 3);
		graph.add(3, 3);
		
		DFSForGraph dfs = new DFSForGraph(graph);
		
		dfs.DFSUtil(2);

	}

}
