package sudoku;

public class SudokuSolve {
	
	private int[][] sudokuTable;
	private int maxNumber;
	private int minNumber;
	private int boxSize;
	
	//Initializing the sudoku table, min number, max number and boxSize, we considering box size as 3 because box size in soduku is 3.
	public SudokuSolve(int[][] sudokuTable)
	{
		this.sudokuTable = sudokuTable;
		this.maxNumber = 9;
		this.minNumber = 1;
		this.boxSize = 3;
	}
	
	public void solve()
	{
		if(solveSudoku(0,0))
		{
			showResult();
		}else{
			System.out.println("No Solution");
		}
	}

	//Reursive method to find the solution for the soduku table
	private boolean solveSudoku(int rowIndex, int columnIndex) {

		System.out.println("Before Called solve method: rowIndex=" + rowIndex+" colIndex=" + columnIndex);
		//Base condition - check whether all the rows and columns are accessed. Here in this case after checking this condition we are increasing the column by using ++columnIndex
		if(rowIndex == sudokuTable.length && ++columnIndex == sudokuTable.length )
		{
			return true;
		}
		
		//If all the rows are accessed then will setting the rowIndex as 0 for the next column.
		if(rowIndex == sudokuTable.length)
		{
			rowIndex = 0;
		}		
		
		System.out.println("After Called solve method: rowIndex=" + rowIndex+" colIndex=" + columnIndex);
		
		
		//Condition to check if the considered cell is not already filled, If already filled then will skip and check for the next row.
		if ( sudokuTable[rowIndex][columnIndex] != 0 ) { // skip filled cell
			return solveSudoku(rowIndex + 1, columnIndex);
		}
		
		//Looping through all the numbers and check if the number can be filled in cell considering all the constraints to fill the number.
		for(int number=minNumber;number<=maxNumber;number++)
		{
			//Calling is valid method if the number can be filled in cell
			if(isValid(number,rowIndex,columnIndex))
			{
				sudokuTable[rowIndex][columnIndex] = number;
				
				if(solveSudoku(rowIndex+1, columnIndex))
				{
					return true;
				}
				//Backtracking - setting back the filled cell as zero if there is no solution for the next number in the upper if.
				sudokuTable[rowIndex][columnIndex] = 0;
			}
			
		}
		
		return false;
	}


	private boolean isValid(int number, int rowIndex, int columnIndex) {
		
		//Checking if the umber is not already present in the column.
		for(int i=0;i<sudokuTable.length;i++){
			if(sudokuTable[i][columnIndex] == number)
			{
				return false;
			}
				
		}
		System.out.println(" ");
		
		//Checking if the number is not already present in the row
		for(int k=0;k<sudokuTable.length;k++){
			if(sudokuTable[rowIndex][k] == number)
			{
				return false;
			}
				
		}
		
		//Checking if the number is not present the in box of 3. Making row and column offset to reach to each box.
		int boxRowOffSet = (rowIndex/3)*boxSize;
		int boxColumnOffset = (columnIndex/3)*boxSize;
		
		for(int i=0;i<boxSize;i++)
		{
			for(int j=0;j<boxSize;j++)
			{
				if(sudokuTable[boxRowOffSet+i][boxColumnOffset+j] == number )
					return false;
			}
		}
		
		return true;
	}
	
	
	
	private void showResult() {
		for (int i = 0; i < sudokuTable.length; ++i) {
			
			if(i % 3 == 0) System.out.println(" ");
			
			for (int j = 0; j < sudokuTable.length; ++j) {
				
				if (j % 3 == 0) System.out.print(" ");
				System.out.print(sudokuTable[i][j]+" ");
			}
			
			System.out.println(" ");
		}	
		
	}
	public static void main(String[] args) {
		
		int sudokuTable[][] = {
				{3, 0, 6, 5, 0, 8, 4, 0, 0},
        		{5, 2, 0, 0, 0, 0, 0, 0, 0},
        		{0, 8, 7, 0, 0, 0, 0, 3, 1},
        		{0, 0, 3, 0, 1, 0, 0, 8, 0},
        		{9, 0, 0, 8, 6, 3, 0, 0, 5},
        		{0, 5, 0, 0, 9, 0, 6, 0, 0},
        		{1, 3, 0, 0, 0, 0, 2, 5, 0},
        		{0, 0, 0, 0, 0, 0, 0, 7, 4},
        		{0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		SudokuSolve obj = new SudokuSolve(sudokuTable);
		obj.solve();

	}

}
