package subsetProblem;

/*Given an S set of integer, Is there any non-empty subset whose sum is 0 or a given number.
 * e.g - if set is {5,2,1,3} and the sum is 9 then the answer is yes because the subset {5,3,1} sum is 9*/
public class SubsetProblem {

	private boolean[][] dpTable;
	private int[] numbers;
	private int sum;
	
	public SubsetProblem(int[] subset,int sum){
		
		//Initializing the table with row length as s.length+1 and columnLength as sum+1, because we are considering the base case if the sum is 0 and no items in the subset. 
		this.dpTable = new boolean[subset.length+1][sum+1];
		this.numbers = subset;
		this.sum = sum;
	}
	
	
	public void solve(){
		
		//Fill the first column of dpTable with true because or sum =0 we have a solution.
		for(int i=0;i<=numbers.length;i++){
			dpTable[i][0] = true;
			
			//Looping thought all the cells in the dpTable and filling the cell based on the decision take for every cell.
			//We starting with index 1 as we have already filled the index for 0 to consider the base case.
			for(int rowIndex=1;rowIndex<=numbers.length;rowIndex++){
				for(int columnIndex=1;columnIndex<=sum;columnIndex++){
					if(columnIndex<numbers[rowIndex-1]){
						this.dpTable[rowIndex][columnIndex] = this.dpTable[rowIndex-1][columnIndex];
					}else{
						/*We are including the current item from the subset because if we can have subset with previous number 
						 * where we can get the sum(columnIndex) then we can get it by including the current number from the subset e.g {5,2} we can get 7 by this subset,
						 * if include {5,2,1} then also we can get 7 by using the subset {5,2}*/
						if(dpTable[rowIndex-1][columnIndex]){
							dpTable[rowIndex][columnIndex] = true;
						}else{
							/*If we can not get the sum by previous set of number then check if we can get the sum by including current number.
							 * e.g. sum=6 previous set {5,2} and current number is 1 if we include include then we get 6.
							 * so check if can get sum-number with previous set i.e 6-1=5 with {5,2} if yes then its true other wise false.
							 * This can be checked by checking the value in the cell for sum 5 and numbers {5,2} i.e row =2 and column= sum - number */
							dpTable[rowIndex][columnIndex] = dpTable[rowIndex-1][columnIndex - numbers[rowIndex-1]];
						}
					}
					
				}
			}
		}
	}
	
	public void showResult(){
		
		
		
		if(dpTable[numbers.length][sum]){
			System.out.println("The solution is yes");
			
			for(int i=numbers.length,j=sum;i>0;){
				if(dpTable[i][j]!=dpTable[i-1][j]){
					System.out.println("we have numbers "+numbers[i-1]);
					j=j-numbers[i-1];
					i=i-1;
				}else{
					i=i-1;
					//System.out.println();
				}
			}
		}else{
			System.out.println("There is no solution exist");
		}
		
		/*for(int i =0;i<=numbers.length;i++){
			for(int j=0;j<=sum;j++)
			{
				System.out.print(" "+dpTable[i][j] );
			}
			System.out.println("");
		}*/
	}
	public static void main(String[] args) {

		int[] subset = {5,2,3,1};
		int sum = 9;
		
		SubsetProblem problem = new SubsetProblem(subset, sum);
		problem.solve();
		problem.showResult();

	}

}
