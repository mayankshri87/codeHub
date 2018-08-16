package hamiltonianCycle;

public class HamiltonianCycle {

	//numberOfVertex will denote the number of edges in the graph. Graph is represented by two dimensional matrix where 1 tells there is connection between nodes and 0 is for no connection.
	private int numberOfVertex;
	private int[][] adjacencyMatrix;
	//integer array will store the hamiltonina path e.g: if there is hamiltonian cycle then array will store 0,1,2,3.
	private int[] hamiltonianPath;
	
	//Constructor where we are initializing the member variable by passing the matrix.
	public HamiltonianCycle(int[][] adjacencyMatrix)
	{
		this.numberOfVertex = adjacencyMatrix.length;
		this.adjacencyMatrix = adjacencyMatrix;
		this.hamiltonianPath = new int[adjacencyMatrix.length];
		//we are setting 0 at 0 index of the array as we have already considered the first node as 0.
		this.hamiltonianPath[0] = 0;
	}
	
	public void solve()
	{
		if(findFeasibleSolution(1)){
			showHamiltonianPath();
		}else{
			System.out.println("There is no feasible solution available");
		}
	}
	//showHamiltonianPath will display the hamiltonian path in case there is hamiltonian cycle exist in the graph.
	private void showHamiltonianPath() {
		for(int i=0;i<hamiltonianPath.length;i++){
			System.out.print(" "+hamiltonianPath[i]);
		}
		System.out.print(" "+hamiltonianPath[0]);
		
	}
	/*This is a recursive method which will called to see if there is any feasible solution for it.*/
	private boolean findFeasibleSolution(int position) {
		
		//Base condition to check if all the vertexes has been accessed or considered.
		if(position == numberOfVertex)
		{
			//Condition that will check if the first node is connected with the last node. If the first node and the last node of the path are same then only it will have a hamiltonian cycle.
			if(adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]] == 1)
			{
				return true;
			}
		}
		
		//Looping thtough all the vertexes and check if that vertex can be considered to be put in hamitonianPath array.
		for(int vertexIndex=1;vertexIndex<numberOfVertex;vertexIndex++){
			if(isFeasible(vertexIndex,position)){
				//If the vertex is satisfying all the required conditions(metioned in the isFeasible() method) then we will put that vertex in hamitonian path array
				hamiltonianPath[position]=vertexIndex;
				//Calling the method recursively for the next position in hamiltonian path. Position is nothing but the position in hamiltonian path where next node will be placed.
				if(findFeasibleSolution(position+1)){
					return true;
				}
				//BackTrack -- If we the return is false from recursive call then we will back track and put the next vertex in the position.
			}
		}
		return false;
	}

	//iSFeasible method will return boolean based on the decision whether passed vertex can be considered in hamiltonian path or not.
	private boolean isFeasible(int vertexIndex, int actualPosition) {
		
		//check the current node is adjacent to the previous node i.e. connected to the previous node.
		if(adjacencyMatrix[hamiltonianPath[actualPosition-1]][vertexIndex] == 0)
			return false;
		//Check if node has not already been accessed.
		for(int i=0;i<actualPosition;i++)
			if(hamiltonianPath[i]==vertexIndex)
				return false;
		
		return true;
	}

	public static void main(String[] args) {
		/*
		 * 
		 * */
		int[][] matrix = {{0,1,1,1,0,0},
						  {1,0,1,0,1,0},
						  {1,1,1,1,0,1},
						  {1,0,1,0,0,1},
						  {0,1,0,0,0,1},
						  {0,1,1,1,1,1}};

		HamiltonianCycle obj = new HamiltonianCycle(matrix);
		obj.solve();
	}

}
