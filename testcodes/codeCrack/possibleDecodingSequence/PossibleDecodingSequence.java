package possibleDecodingSequence;
/*Count Possible Decodings of a given Digit Sequence
 * Input:  digits[] = "121"
Output: 3
The possible decodings are "ABA", "AU", "LA"

Input: digits[] = "1234"
Output: 3
The possible decodings are "ABCD", "LCD", "AWD"
 * 
 * This problem is recursive and can be broken in sub-problems. We start from end of the given digit sequence. We initialize the total count of decodings as 0. We recur for two subproblems.
1) If the last digit is non-zero, recur for remaining (n-1) digits and add the result to total count.
2) If the last two digits form a valid character (or smaller than 27), recur for remaining (n-2) digits and add the result to total count.
 * */
public class PossibleDecodingSequence {


	/*recursive method to find the possible decoding sequence*/
	public int findPossibleDeconding(char[] digits,int n){
		
		//base condition - if the length of the array is 0 or 1 then only 1 decoding sequence is possible.
		if(n == 0 || n == 1)
		{
			return 1;
		}
		//initialize the count with and then keep on incrementing the count
		int count = 0;
		//if the last digit is greater than zero then recur for the n-1 digits
		if(digits[n-1] > '0')
		{
			count = findPossibleDeconding(digits, n-1);
		}
		
		/*if the last two digit of the array forms a valid character then recur for the rest n-2 digits*/
		if(digits[n-2]=='1' || (digits[n-2]=='2' && digits[n-1]<'7'))
		{
			count+= findPossibleDeconding(digits, n-2);
		}
	return count;	
		
	}
	/*in this method store the result in array of count*/
	public int findPossibleDecoidingSequenceDynamicProgramming(char[] digits,int n){
		int[] count = new int[n+1];
		
		//Base condition - count[0] = 1 && count[1] = 1 if the length of the array is 0 or 1 then the only 1 decoding is possible.
		count[0] = 1;
		count[1] = 1;
		
		for(int i = 2;i < n;i++)
		{
			if(digits[i-1]>'0')
			{
				count[i]=count[i-1];
			}
			if(digits[i-2]=='1' || (digits[i-2]=='2' && digits[i-1]<'7'))
			{
				count[i]+=count[i-2];
			}
		}
		return count[n-1];
	}
	public static void main(String[] arg)
	{
		char digits[] = {'1', '2', '3', '4'};
	    int n = digits.length;
	    
	    PossibleDecodingSequence obj = new PossibleDecodingSequence();
	    System.out.println(obj.findPossibleDeconding(digits, n));
	    System.out.println(obj.findPossibleDecoidingSequenceDynamicProgramming(digits, n));
	}
}
