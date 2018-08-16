package longestPalindromeSubString;

public class LongestPalindromeSubString {

	int[][] dp;
	String str;
	int n;
	
	public LongestPalindromeSubString(String str) {
		this.dp = new int[str.length()][str.length()];
		this.str = str;
		this.n = str.length();
	}
	
	public int findLenghtOfLongestPalindrome()
	{
		// Strings of length 1 are palindrome of lentgh 1
		for(int i=0;i<n;i++)
		{
			dp[i][i] = 1;
		}
		
		for(int lenghtOfString=2;lenghtOfString<=n;lenghtOfString++)
		{
			for(int startIndex=0;startIndex<n-lenghtOfString+1;startIndex++)
			{
				int endIndex = startIndex + lenghtOfString -1;
				
				if(str.charAt(startIndex)==str.charAt(endIndex) && lenghtOfString==2)
				{
					dp[startIndex][endIndex] = 2;
				}else if(str.charAt(startIndex)==str.charAt(endIndex))
				{
					dp[startIndex][endIndex] = dp[startIndex+1][endIndex-1]+2;
				}else{
					dp[startIndex][endIndex] = Math.max(dp[startIndex][endIndex-1],dp[startIndex+1][endIndex]);
				}
			}
		}
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "BANANA";
		LongestPalindromeSubString obj = new LongestPalindromeSubString(str);
		
		System.out.println(" "+obj.findLenghtOfLongestPalindrome());
	}

}
