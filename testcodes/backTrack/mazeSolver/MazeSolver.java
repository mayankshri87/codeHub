package mazeSolver;

/*MazeSolver problem is finding the path in a maze to get exit form starting point to exit point with any obastacle.*/
public class MazeSolver {

	private int[][] mazeTabel;
	private int[][] solutionTable;
	private int mazeSize;
	
	public MazeSolver(int[][] mazeTable)
	{
		this.mazeTabel = mazeTable;
		this.solutionTable = new int[mazeTable.length][mazeTable.length];
		
	}
	
	//Solve method to solve the maze problem
	public void solveMaze()
	{
		if(!solve(0,0))
		{
			System.out.println("No Solution!!!!!");
			return;
		}
		showSolution();
	}
	private void showSolution() {


		for(int i=0;i<solutionTable.length;i++){
			for(int j=0;j<solutionTable.length;j++)
			{
				if(solutionTable[i][j]==1)
				{
					System.out.print(" S ");
				}
				else{
					System.out.print(" - ");
				}
			}
			System.out.println("");
			
		}
		
	}

	private boolean solve(int x, int y) {
		
		if( isFinished(x,y) )
		{
			return true;
		}
		if( isValid(x,y) )
		{
			solutionTable[x][y] = 1; // it is valid so it is part of the solution
	
			if (solve(x + 1, y)){  
				return true;  // go forward in x direction 
			}
			
			if (solve(x, y + 1)) // If moving in x direction is not feasible: go down in y direction
				return true;

			solutionTable[x][y] = 0; // no feasible solution: backtrack
						
		}
		return false;
	}

	private boolean isValid(int x, int y) {

		if(x<0 || x>=mazeTabel.length) return false;
		if(y<0 || y>=mazeTabel.length) return false;
		if(   mazeTabel[x][y] != 1   ) return false;
		
		return true;
	}

	private boolean isFinished(int x, int y) {

		if(x==mazeTabel.length-1 && y==mazeTabel.length-1)
		{
		 solutionTable[x][y] = 1;
		 return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mazeTable[][] = { 
				  { 1, 1, 1, 1 ,1},
			      { 1, 0, 0, 1, 0},
			      { 0, 0, 0, 1, 0},
			      { 1, 1, 1, 1, 1},
			      { 1, 1, 1, 0, 1}
		        };

		MazeSolver obj = new MazeSolver(mazeTable);
		obj.solveMaze();
	}

}
