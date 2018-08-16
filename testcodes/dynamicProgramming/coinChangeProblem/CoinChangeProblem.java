package coinChangeProblem;
/*Find the maximum number of combination of coins in set for n coins to get the amount M e.g coinValues = {1,2,3} and amount is 4,
 * then 4 is the maximum number of combination where coins can be selected to get M amount,
 * Here we will consider base case as well as the formula
 * Base case
 * Case 1 - when amount is 0 then there will only 1 possible combination
 * case 3 - when there is no coin then 0 possible combination
 * 
 * dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j - coinValues[i-1]] --- if v[i]<=j
 * 
 * 			else
 * 
 * dpTable[i][j] = dpTable[i-1][j]  ---- if v[i]>j
 * 
 * i = number of coins considered 
 * j = amount 
 * 
 * */
public class CoinChangeProblem {

	private int[][] dpTable;
	private int[] coinValues;
	private int amount;
	
	public CoinChangeProblem(int[] coinValues,int amount){
		
		this.coinValues = coinValues;
		this.amount = amount;
		/*initializing the dpTable with rows as coinValues+1 and amount+1, 
		 * as we are considering the case when amount is 0 and there is no coin to select*/
		this.dpTable = new int[coinValues.length+1][amount+1];
		
		//Initializing the first row and first column for the dpTable
		for(int i = 0;i < coinValues.length+1;i++)
			dpTable[i][0] = 1;
		
		for(int j = 0;j < amount+1;j++)
			dpTable[0][j] = 0;
	}
	
	public void solveProblem()
	{
		//Looping through the rows to consider the number of coins and iterating through the amount one by one
		for(int i = 1;i < coinValues.length+1;i++)
		{
			for(int j = 1;j < amount+1;j++){
				 
				if(coinValues[i-1]<=j)
				{
					dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j - coinValues[i-1]];
				}else{
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
		
		for(int i = 0;i < coinValues.length+1;i++)
		{
			for(int j = 0;j < amount+1;j++){
				 System.out.print(dpTable[i][j]+" ");
			}
			 System.out.println();
		}
		System.out.println("Printing the maximum number of possible combination for amount " +amount+" #"+dpTable[coinValues.length][amount] );
	}
	public static void main(String[] args) {
		
		int[] coinValues = {41,34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11};
		int amount = 250;
		
		CoinChangeProblem change = new CoinChangeProblem(coinValues,amount);
		
		change.solveProblem();

	}

}
