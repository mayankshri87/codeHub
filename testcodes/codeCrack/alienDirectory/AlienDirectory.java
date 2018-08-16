package alienDirectory;
import java.util.Iterator;
/*
 * 
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples:

Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is 'b', 'd', 'a', 'c'
Note that words are sorted and in the given language "baa" 
comes before "abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b

Algorithm

1) Create a graph g with number of vertices equal to the size of alphabet in the given alien language. For example, if the alphabet size is 5, then there can be 5 characters in words. Initially there are no edges in graph.

2) Do following for every pair of adjacent words in given sorted array.
…..a) Let the current pair of words be word1 and word2. One by one compare characters of both words and find the first mismatching characters.
…..b) Create an edge in g from mismatching character of word1 to that of word2.

3) Print topological sorting of the above created graph.
 * */
import java.util.LinkedList;
import java.util.Stack;

public class AlienDirectory {
	Graph graph;
	
	class Graph{
		//declaring number of vertices
		int v;
		//array of linkedlist 
		LinkedList<Integer>[] adjacencyList;
		
		Graph(int v){
			this.v = v;
			adjacencyList = new LinkedList[v];
			for(int i=0;i<v;i++){
				adjacencyList[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int vertex,int edge)
		{
			adjacencyList[vertex].add(edge);
		}
	}
	
	public void printOrder(String[] words, int numberOfAlphabets)
	{
		graph = new Graph(numberOfAlphabets);
		
		//Looping through the words and creating the graph
		for(int i=0;i<words.length-1;i++){
			String word1 = words[i];
			String word2 = words[i+1];
			
			for(int j=0;j<Math.min(word1.length(), word2.length());j++)	{
				
				if(word1.charAt(j)-'a'!=word2.charAt(j)-'a'){
					graph.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
					break;
				}
			}
			
		}
		
		
		topologicalSort(numberOfAlphabets);
		
	}

	private void topologicalSort(int numberOfAlphabets) {
		int[] visited = new int[numberOfAlphabets];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<numberOfAlphabets;i++){
			if(visited[i]!=1){
				topologicalSortUtil(visited,stack,i);
			}
		}
		
		while(!stack.isEmpty())
		{
			System.out.print((char)('a' + stack.pop()) + " ");
		}
		
	}

	
	private void topologicalSortUtil(int[] visited, Stack stack, int vertex) {
		visited[vertex]=1;
		
		Iterator<Integer> it = graph.adjacencyList[vertex].listIterator();
		while(it.hasNext())
		{
			int n = it.next();
			if(visited[n]!=1)
			{
				topologicalSortUtil(visited, stack, n);
			}
		}
		
		stack.push(vertex);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"caa", "aaa", "aab"};
		
		AlienDirectory directory = new AlienDirectory();
		directory.printOrder(words, 3);
	}

}
