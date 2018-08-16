package kanpsackProblem;

public class KnapsackProblem {
	
	private int knapsackCapacity;
	private int[][] knapsackMatrix;
	private int[] weights;
	private int[] values;
	private int numberOfItems;
	private int totalBenefit;
	
	public KnapsackProblem(int numberOfItems, int knapsackCapacity, int[] weights, int[] values){
		
		this.knapsackCapacity = knapsackCapacity;
		this.numberOfItems = numberOfItems;
		this.weights = weights;
		this.values = values;
		
		/*initializing the matrix with size numberOfItems+1 and knapsackCapacity+1, 
		 * as we have consider first row and first column as 0 weight and 0 number of items*/
		this.knapsackMatrix = new int[numberOfItems+1][knapsackCapacity+1];
		
		for(int i=0;i<knapsackCapacity+1;i++)
			this.knapsackMatrix[0][i] = 0;
		
		for(int j=0;j<numberOfItems+1;j++)
			this.knapsackMatrix[j][0] = 0;

		
	}
	
	public void solve(){
		
		/*Looping through numberOfItems and weights, and apply knapsack formula*/
		for(int i = 1;i < numberOfItems+1;i++)
		{
			for(int w = 1;w < knapsackCapacity+1;w++)
			{
				//Getting the value for the weight from the previous row to compare with the item taken into consideration.
				int itemNotTaken = knapsackMatrix[i-1][w];
				//itemTaken i.e. if we consider the current item
				int itemTaken = 0;
				
				//check if the weight of the item is less than or equal to the weight(column) we are on. It should be less.
				if(weights[i]<=w)
				{
					//If we consider then value will be the value of the current item and value of item for the remaining weight.
					itemTaken = values[i] + knapsackMatrix[i-1][w-weights[i]];
				}
				//Applying knapsack formula to get the max of the itemNot taken and item taken.
				knapsackMatrix[i][w] = Math.max(itemNotTaken, itemTaken);
			}
		}
		//last item in the matrix will have the maximum value.
		totalBenefit = knapsackMatrix[numberOfItems][knapsackCapacity];
	}
	
	public void showResult(){
		
		System.out.println("Total benfit is - "+totalBenefit);
		
		/*Please check the notes for this formula*/
		for(int n=numberOfItems,w=knapsackCapacity;n>0;n--){
			
			if(knapsackMatrix[n][w]!=0 && knapsackMatrix[n][w]!=knapsackMatrix[n-1][w]){
				System.out.println("Items considered #"+n);
				w=w - weights[n];
			}
		}
	}

	public static void main(String[] args) {
		int numberOfItems = 3;
		int knapsackCapacity = 5;

		// int[] weightOfItems = {4,2,3};
		// int[] profitOfItems = {10,4,7};

		int[] weights = new int[numberOfItems + 1];
		weights[1] = 4;
		weights[2] = 2;
		weights[3] = 3;

		int[] values = new int[numberOfItems + 1];
		values[1] = 10;
		values[2] = 4;
		values[3] = 7;
		
		KnapsackProblem obj = new KnapsackProblem(numberOfItems, knapsackCapacity, weights, values);
		obj.solve();
		obj.showResult();

	}

}
