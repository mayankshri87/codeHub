package minimumPalindromePartition;

public class MinimumPalindromePartition {

	boolean[][] dp;
	String str;
	int size;
	
	public MinimumPalindromePartition(String str) {
		this.dp = new boolean[str.length()][str.length()];
		this.str = str;
		this.size = str.length();
	}
	
	public int findMinimumPartition()
	{
		//when length of the string is 1 like 'a' is palindrome
		int[] cutsArray = new int[size];
		for(int i=0;i<size;i++)
			dp[i][i] = true;
		
		//when length of the string is 2 or more than 2
		for(int length=2;length<size;length++)
		{
			for(int startIndex=0;startIndex<size-length+1;startIndex++)
			{
				int endIndex = startIndex+length-1;
				if(str.charAt(startIndex)==str.charAt(endIndex) && length==2)
				{
					dp[startIndex][endIndex] = true;
				}
				else if(str.charAt(startIndex)==str.charAt(endIndex) && dp[startIndex+1][endIndex-1])
				{
					dp[startIndex][endIndex] = true;
					System.out.println(str.substring(startIndex, endIndex));
				}else
				{
					dp[startIndex][endIndex] = false;
				}
				
			}
			
			for(int k=0;k<size;k++)
			{
				if(dp[0][k])
				{
					cutsArray[k]=0;
				}else
				{
					cutsArray[k] = Integer.MAX_VALUE;
					
					for(int j=0;j<k;j++)
					{
						if(dp[j+1][k] && 1+cutsArray[j]<cutsArray[k])
						{
							cutsArray[k]= 1+cutsArray[j];
						}
					}
				}
			}
		}
		return cutsArray[size-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ababbbabbababa";
		
		MinimumPalindromePartition obj = new MinimumPalindromePartition(str);
		
		System.out.println(" "+obj.findMinimumPartition());
	}

}
