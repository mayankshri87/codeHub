package queensProblem;

/*Nqueens problem is place n queens in n*n chesstable so that no queen can attack each other.*/
public class NQueensProblem {
	
	private int numberOfQueens;
	private int[][] chessTable;
	
	//constructor to create object of NQueens and setting the member variables.
	public NQueensProblem(int numberOfQueens)
	{
		this.numberOfQueens = numberOfQueens;
		this.chessTable = new int[numberOfQueens][numberOfQueens];
	}
	
	public void solve()
	{
		//calling setQueens method for the first column.
		if(setQueens(0))
		{
			printQueens();
		}else{
			System.out.println("There is no feasible solution available");
		}
	}
	/*setQueens() is a recursive method will get called for every column in the chess table*/
	private boolean setQueens(int columnIndex) {
		
		//base condition, If in case all the columns have been access and get placed with queens then all queens are placed successfully.
		if(columnIndex==numberOfQueens)
		{
			return true;
		}
		//Looping though all the rows to place queen
		for(int rowIndex=0;rowIndex<chessTable.length;rowIndex++){
			//checking if queen is able to place by considering the condition that no queens attack each other.
			if(isPlaceValid(rowIndex,columnIndex))
			{
				//setting the value as one to specify that queen is already been placed.
				chessTable[rowIndex][columnIndex]=1;
				//calling method recursively for the next column.
				if(setQueens(columnIndex+1)){
					//return statement will take you back to the previous call and keep on taking back to 1st method call.
					return true;
				}
				/*Backtracking if the queen is not able place in any of the row for the considered column,
				 * then we backtrack and remove the queen which we already set in the previous call try for the next row.*/
				chessTable[rowIndex][columnIndex]=0;
			}
		}
		
		return false;
	}
	//isPlaceValide method will check if no queen is attacking eachother.
	private boolean isPlaceValid(int rowIndex,int columnIndex) {
		//checking if there is any queen already place in the same row
		for(int i=0;i<columnIndex;i++){
			if(chessTable[rowIndex][i]==1)
				return false;
		}
		//checking if there is any queen already place diagonally in backward direction.
		for(int i=rowIndex,j=columnIndex;i>=0 && j>=0;i--,j--){
			if(chessTable[i][j]==1)
				return false;
		}
		//checking if there is any queen already place diagonally in forward direction.
		for(int i=rowIndex,j=columnIndex;i>=0 && j<chessTable.length;i--,j++)
			if(chessTable[i][j]==1)
				return false;
		return true;
	}

	private void printQueens() {
		for(int i=0;i<chessTable.length;i++)
		{
			for(int j=0;j<chessTable.length;j++){
				if(chessTable[i][j]==1){
					System.out.print(" * ");
				}else{
					System.out.print(" - ");
				}
			}
			System.out.println("");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensProblem obj = new NQueensProblem(4);
		obj.solve();
	}

}
