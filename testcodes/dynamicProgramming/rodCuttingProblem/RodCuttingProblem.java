package rodCuttingProblem;

/*Given a rod of certain length. Given the prices of different length. How to cut a rod in order to maximize the profit.
 * eg-if the length of the rod is 5 M. and prices for the cut is {2,5,7,3} for 1m cut, 2m cur, 3m cut and 4 m cut.
 * Maximum profit will to cut the rod in 2m,2m,1 i.e.  $12*/

public class RodCuttingProblem {
	
	private int[][] dpTable;
	private int[] prices;
	private int lengthOfRod;
	
	public RodCuttingProblem(int lengthOfRod, int[] prices)
	{
		this.dpTable = new int[prices.length+1][lengthOfRod+1];
		this.prices = prices;
		this.lengthOfRod = lengthOfRod;
	}
	
	
	public void solve()
	{
		//creating the base case, if the length is 0 then the price for the 0m cut is 0 and if the there is only $0 price available then the price of all the cuts is 0. 
		
		
		for(int rowIndex=1 ; rowIndex<prices.length+1 ; rowIndex++)
		{
			for(int columnIndex=1 ; columnIndex<lengthOfRod+1 ; columnIndex++)
			{
				if(rowIndex<=columnIndex)
				{
					dpTable[rowIndex][columnIndex] = Math.max(dpTable[rowIndex-1][columnIndex],(prices[rowIndex-1]+dpTable[rowIndex-1][columnIndex - rowIndex]));
				}else{
					dpTable[rowIndex][columnIndex]  = dpTable[rowIndex-1][columnIndex];
				}
			}
		}
		
	}
	
	public void showResult(){
		
		System.out.println("Maximum profit is -- "+dpTable[prices.length][lengthOfRod]);
		
		for(int n=prices.length,w=lengthOfRod;n>=0 && w>=0;)
		{
			if(dpTable[n][w]!=0 && dpTable[n][w]!=dpTable[n-1][w])
			{
				System.out.println("we make cut "+n+"m");
				w=w-n;
			}
			n=n-1;
		}
		
		/*for(int i =0;i<=prices.length;i++){
			for(int j=0;j<=lengthOfRod;j++)
			{
				System.out.print(" "+dpTable[i][j] );
			}
			System.out.println("");
		}*/
	}
	
	public static void main(String[] args) {
		int lengthOfRod = 5;
		int[] prices = {2,5,7,3};
		
		RodCuttingProblem cutting = new RodCuttingProblem(lengthOfRod, prices);
		cutting.solve();
		cutting.showResult();

	}

}
