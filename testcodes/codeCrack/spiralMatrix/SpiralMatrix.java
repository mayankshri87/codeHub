package spiralMatrix;
/*Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11*/
public class SpiralMatrix {

	int[][] matrix;
	int numberOfRows;
	int numberOfColumns;
	
	public SpiralMatrix(int[][] matrix, int numberOfRows, int numberOfColumns){
		this.matrix = matrix;
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
	}
	
	public void printSpiralMatrix()
	{
		int rowIndex = 0;
		int columnIndex = 0;
		/*In this while loop as we print the rows and columns we remove printed row and column */
		while(rowIndex < numberOfRows && columnIndex < numberOfColumns)
		{
			//print the first row and then remove that row from the matrix
			for(int i = columnIndex ; i < numberOfColumns ; i++)
			{
				System.out.print(" "+matrix[rowIndex][i]);
			}
			//increased rowIndex so that we remove already printed row
			rowIndex++;
			
			//print the last column and then remove the last column
			for(int j = rowIndex ; j < numberOfRows ; j++){
				System.out.print(" "+matrix[j][numberOfColumns-1]);
			}
			//removing the printed last column by decreasing the size of the number of columns
			numberOfColumns--;
			
			//print the row in the matrix and then remove it from the matrix
			if(rowIndex<numberOfRows)//if statement to avoid print of last row. if rowIndex is less than numberOfrows then only print
			{
				for(int k = numberOfColumns-1;k >= columnIndex;k--)
				{
					System.out.print(" "+matrix[numberOfRows-1][k]);
				}
				//removing the last row by decreasing the numberOfRows
				numberOfRows--;
			}
			
			
			//printing the first column and then remove the column from the matrix
			if(columnIndex<numberOfColumns)
			{
				for(int l = numberOfRows-1; l >= rowIndex; l--)
				{
					System.out.print(" "+matrix[l][columnIndex]);
				}
				//removing the first column by increasing the columnIndex
				columnIndex++; 
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
              };
		int numberOfRows = 3;
		int numberOfColumns = 6;
		
		SpiralMatrix spiral = new SpiralMatrix(matrix, numberOfRows, numberOfColumns);
		spiral.printSpiralMatrix();
	}

}
