package interleavingOfTwoStrings;

import sun.security.util.Length;

/*Input: str1 = "AB",  str2 = "CD"
Output:
    ABCD
    ACBD
    ACDB
    CABD
    CADB
    CDAB

Input: str1 = "AB",  str2 = "C"
Output:
    ABC
    ACB
    CAB*/

public class InterleavingOfTwoStrings {

	/*Recursive method find interleaving of two strings*/
	public static void printInterleavingOfString(String firstString, String secondString,String interLeaving,int lengthOfFistString,int lengthOfSecondString)
	{
		//Base case - if the all the characters of the both the strings are accessed then print string
		if(firstString.length() == 0 && secondString.length()==0)
		{
			System.out.println("InterleavingString = "+interLeaving);
		}
		//First take string1 into consideration and then print all the possible interleaving by calling the method recusively.
		if(firstString.length()!=0){
			printInterleavingOfString(firstString.substring(1), secondString, interLeaving+firstString.charAt(0), lengthOfFistString-1,lengthOfSecondString);
		}
		//Take the second string into consideration and print all the possible interleaving strings
		if(secondString.length()!=0)
		{
			printInterleavingOfString(firstString, secondString.substring(1), interLeaving+secondString.charAt(0),lengthOfFistString ,lengthOfSecondString-1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstString = "AB";
		String secondString = "XY";
		printInterleavingOfString(firstString, secondString, "", firstString.length(), secondString.length());
	}

}
