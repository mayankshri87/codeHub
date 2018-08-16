package numberOfIsland;
/*
 * A group of connected 1s forms an island. For example, the below matrix contains 5 islands

                    {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
 * */
public class NumberOfIsland {

	int[][] matrix;
	//visits will track if the island has already visited or not
	int[][] visits;
	int rowSize;
	int columnSize;
	int numberOfones;
	public NumberOfIsland(int[][] matrix, int rowSize, int columnSize)
	{
		this.matrix = matrix;
		this.visits = new int[rowSize][columnSize];
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		this.numberOfones = 0;
	}
	
	public int findNumberOfIslands()
	{
		int numberOfIsland = 0;
		
		for(int row=0;row<rowSize;row++)
		{
			for(int column=0;column<columnSize;column++)
			{
				//check if the cell has value 1 and not visited yet(if already visited then we will put 1 for that cell)
				if(matrix[row][column]==1 && visits[row][column]!=1)
				{
					checkNeigbours(matrix,visits,row,column);
					numberOfIsland = numberOfIsland+1;
				}
			}
		}
		
		return numberOfIsland;
	}
	
	private void checkNeigbours(int[][] matrix, int[][] visits, int row, int column) {
		   // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        
        visits[row][column] = 1;
        
        //looping through all the neighbors and check if they together form an island
        for(int k=0;k<rowNbr.length;k++)
        {
        	if(isPartOfIsland(matrix,visits,row+rowNbr[k],column+colNbr[k])){
        		checkNeigbours(matrix,visits,row+rowNbr[k],column+colNbr[k]);
        	}
        }
		
	}

	//This method will check if the particular cell can be considered as a part of island.
	/*Following are the conditions which are required to check for a cell to be a part of island
	 * 1. row and column should not be out of window of matrix
	 * 2. cell should have the value as 1 if considere as a part of island
	 * 3. cell has not been visited already*/
	private boolean isPartOfIsland(int[][] matrix, int[][] visits, int row, int column) {
	
		return (row>=0 && row<rowSize && column>=0 && column<columnSize && matrix[row][column]==1 && visits[row][column]!=1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	int[][] matrix =  new int[][] {{1, 1, 0, 0, 0},
							            {0, 1, 0, 0, 1},
							            {1, 0, 0, 1, 1},
							            {0, 0, 0, 0, 0},
							            {1, 0, 1, 0, 1}};*/
		
		int[][] matrix =  new int[][]	{{1, 0, 1, 1, 0},
		{1, 1, 0, 0, 1},
		{0, 1, 1, 1, 0},
		{0, 0, 0, 0, 1},
		{1, 1, 1, 0, 0}};
	int rowSize = 5;
	int columnSize = 5;
	
	NumberOfIsland islands = new NumberOfIsland(matrix, rowSize, columnSize);
	
	System.out.println("number of islands are = "+islands.findNumberOfIslands());
	}

}
