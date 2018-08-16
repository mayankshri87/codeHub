package minimumCostToTravelInMatrix;
/*
 * For example, in the following figure, what is the minimum cost path to (2, 2)?

	{{1,2,,3},
	 {4,8,2}
	 {1,5,3}}
	 
	 

The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). \
The cost of the path is 8 (1 + 2 + 2 + 3).

 * */
public class MinimumCostToTravelInMatrix {

	//Create a Dynamic Programming matrix that will store the minimum cos to reach to a cell
	int[][] dp;
	//cost matrix which hold the cost for every cell
	int[][] cost;
	
	int rows;
	int columns;
	
	public MinimumCostToTravelInMatrix(int[][] cost,int rows,int columns)
	{
		this.cost = cost;
		this.rows = rows;
		this.columns = columns;
				
		this.dp = new int[rows][columns];
	}
	
	public int findMinimCost(){
		//Base condition- minimum cost to reach to the first cell is equal to cost at first celll of the cost matrix
		dp[0][0] = cost[0][0];
		
		//filling the first row of the matrix
		for(int i=1;i<columns;i++)
		{
			dp[0][i] = dp[0][i-1]+cost[0][i];
		}
		
		//filling the first column
		for(int j=1;j<rows;j++)
		{
			dp[j][0] = dp[j-1][0]+cost[j][0];
		}
		
		for(int i=1;i<rows;i++)
		{
			for(int j=1;j<columns;j++)
			{
				//minimum cost will be the minimum of cells near to the current cells + cost of the curretn cell
				dp[i][j] = cost[i][j] + min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[rows-1][columns-1];
	}
	private int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(i<j)
		{
			if(i<k)
			{
				return i;
			}else{
				return k;
			}
		}else{
			if(j<k){
				return j;
			}else{
				return k;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		int cost[][] = { {1, 2, 3},
 						{4, 8, 2},
 						{1, 5, 3} };
 		
 		int rows = 3;
 		int columns = 3;
 		
 		MinimumCostToTravelInMatrix obj = new MinimumCostToTravelInMatrix(cost, rows, columns);
 		System.out.println(obj.findMinimCost());
	}

}
