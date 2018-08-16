package coloringProblem;

import org.apache.poi.ss.formula.functions.NumericFunction;
/**
 * Vertex coloring is the most common problem !!!
 * 	- The problem is, given m colors, find a way of coloring the vertices of a graph such that no two adjacent vertices are colored using same color
 *  - CHROMATIC NUMBER: The smallest number of colors needed to color a graph G is called its chromatic number
 *  - The problem to find chromatic number of a given graph is NP Complete
 *  
 *  	Several applications:
 *  		
 *  		1.) Making schedules // time tables
 *  
 *  				Suppose we want to make am exam schedule for a university. We have list different subjects and students enrolled in 
 *  		    	every subject. Many subjects would have common students (of same batch, some backlog students, etc). How do we schedule
 *  	        	the exam so that no two exams with a common student are scheduled at same time? How many minimum time slots are needed to
 *  		    	schedule all exams? This problem can be represented as a graph where every vertex is a subject and an edge between two vertices
 *  		    	mean there is a common student. So this is a graph coloring problem where minimum number of time slots is equal to the chromatic
 *  		    	number of the graph.
 *  
 *  		2.) Mobile Radio Frequency Assignment
 *  
 *  			 	When frequencies are assigned to towers, frequencies assigned to all towers at the same location must be different. How
 *  			    to assign frequencies with this constraint? What is the minimum number of frequencies needed? This problem is also an 
 *  				instance of graph coloring problem where every tower represents a vertex and an edge between two towers represents 
 *  				that they are in range of each other
 *  
 *  		3.) Map coloring 
 *  
 *  				Geographical maps of countries or states where no two adjacent cities cannot be assigned same color.
 *  				Four colors are sufficient to color any map
 *  
 *  		4.) Register Allocation
 *  
 *  				In compiler optimization, register allocation is the process of assigning a large number of target program
 *  				variables onto a small number of CPU registers. This problem is also a graph coloring problem
 * 
 * 	Here we implement the greedy algorithm: d+1 colort hasznal max -> d a legtobb fogszammal rendelkezo vertex eleinek szama
 * 			 It doesn’t guarantee to use minimum colors, but it guarantees an upper bound on the number of colors !!!
 * 
 */
public class ColoringProblem {
	
	
	private int numberOfvertices;
	//numberOfColors is the number of different colors given as input to print nodes in graph with certain conditions.
	private int numberOfColors;
	private int[][] adjacencyMatrix;
	//colors matrix will store as node as index and color as value i.e. colors[1] = 3 where 1(node0,node1...) is node and 3 color, here color is defined by the number e.g 1-red, 2-green.
	private int[] colors;
	
	public ColoringProblem(int[][] adjacencyMatrix, int numberOfcolors)
	{
		this.numberOfvertices = adjacencyMatrix.length;
		this.numberOfColors = numberOfcolors;
		this.adjacencyMatrix = adjacencyMatrix;
		this.colors = new int[adjacencyMatrix.length];
		
	}
	
	public void solve(){
		
		// We will start with the first node, node selection is random.
		if(findSolution(0)){	
			printResult();
			
		}else{
			System.out.println("No solution....");
		}
	}
	
	//printResult() method will print the nodes with their corresponding color assignment.
	private void printResult() {
		
		for(int i=0;i<numberOfvertices;i++)
			System.out.println("Node "+(i+1)+" has color "+(colors[i]+1));
		
	}

	//findSolution is the recursive method and will fill colors[] if there is a feasible solution array with index as node and value as color.
	private boolean findSolution(int nodeIndex) {
		
		//Base condition - If all the nodes are accessed or processed then we return otherwise will continue.
		if(nodeIndex==numberOfvertices)
		{
			return true;
		}
		
		//Looping through all the colors given in the problem to fill the graph. We will iterate till number of colors as we are not allowed to go beyond the given number of colors.
		for(int colorIndex=0;colorIndex<=numberOfColors;colorIndex++)
		{
			//Checking if the selected color can be assigned to the passed node index.
			if(isColorValid(nodeIndex,colorIndex)){
				//assigning color to the node index
				colors[nodeIndex]=colorIndex;
				
				//Calling method recursively for the next node.
				if(findSolution(nodeIndex+1)){
					return true;
				}
				
				//BackTrack - if there is no solution for the next node then will backtrack and consider the next color for the previous node.
			}
		}
		return false;
	}

	//isColorValid() method will check if the passed color can be assigned to the node.
	private boolean isColorValid(int nodeIndex, int colorIndex) {
		
		//For loop to check if there is any node which is adjacent to the passed node i.e. nodeIndex and has the same color then will return false else will return true.
		for(int i=0;i<numberOfvertices;i++){
			if(adjacencyMatrix[nodeIndex][i] == 1 && colors[i]==colorIndex)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		int[][] graphMatrix = new int[][]{
	    		{0,1,0,1,0},
	    		{1,0,1,1,0},
	    		{0,1,0,1,0},
	    		{1,1,1,0,1},
	    		{0,0,0,1,0}
	    };
	    
	    int numberOfcolors = 3;
	    ColoringProblem obj = new ColoringProblem(graphMatrix, numberOfcolors);
	    obj.solve();

	}

}
