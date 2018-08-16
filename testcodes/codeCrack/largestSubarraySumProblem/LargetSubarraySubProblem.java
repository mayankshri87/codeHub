package largestSubarraySumProblem;

public class LargetSubarraySubProblem {

	public int findLagestSubarraySum(int[] array)
	{
		int maximumSum  = array[0];
		int currentSum = array[0];
		
		
		for(int i=1 ; i<array.length;i++)
		{
			currentSum = Math.max(array[i], currentSum+array[i]);
			
			if(currentSum>maximumSum)
			{
				maximumSum = currentSum;
			}
		}
		
		return maximumSum;
	}
	
	public static void main(String[] arg)
	{
		int[] array =  {-2, -3, 4, -1, -2, 1, 5, -3};
		
		LargetSubarraySubProblem obj = new LargetSubarraySubProblem();
		System.out.println(" "+ obj.findLagestSubarraySum(array));
	}
}
