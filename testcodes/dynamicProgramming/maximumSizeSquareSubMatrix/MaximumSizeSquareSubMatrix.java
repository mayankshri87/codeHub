package maximumSizeSquareSubMatrix;
/*Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

For example, consider the below binary matrix.

						{0, 1, 1, 0, 1},
                        {1, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0}

*/import com.graphbuilder.curve.BinaryCurveApproximationAlgorithm;

public class MaximumSizeSquareSubMatrix {
	int[][] solutionMatrix;
	int[][] binaryMatirx;
	int rowSize;
	int columnSize;
	
	MaximumSizeSquareSubMatrix(int[][] binaryMatrix,int rowSize, int columnSize ) {
		this.binaryMatirx = binaryMatrix;
		this.solutionMatrix = new int[rowSize+1][columnSize+1];
		this.rowSize = rowSize;
		this.columnSize = columnSize;
	}
	
	public void maximumSquareSize(){
		
		for(int rowIndex=1;rowIndex<=rowSize;rowIndex++){
			for(int columnIndex=1;columnIndex<=columnSize;columnIndex++){
				if(binaryMatirx[rowIndex-1][columnIndex-1]==1){
					solutionMatrix[rowIndex][columnIndex] = Math.min(solutionMatrix[rowIndex-1][columnIndex], 
							Math.min(solutionMatrix[rowIndex][columnIndex-1],solutionMatrix[rowIndex-1][columnIndex-1]))+1;
				}else{
					solutionMatrix[rowIndex][columnIndex] = binaryMatirx[rowIndex-1][columnIndex-1];
				}
			}
		}
		
		//Printing the maximum size
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
