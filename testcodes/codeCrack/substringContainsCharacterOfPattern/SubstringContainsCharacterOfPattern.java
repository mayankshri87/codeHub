package substringContainsCharacterOfPattern;

/*Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"
Explanation: "t stri" contains all the characters
              of pattern.

Input :  string = "geeksforgeeks"
         pattern = "ork" 
Output :  Minimum window is "ksfor

Algorithm - 
we solve this problem by following the window approach

1. Create two arrays of 256 characters and store the occurrence of characters in array.
2. Now we start from the beginning(window size will start with 1 and will keep on increasing) of the string and match the character of array with character of pattern if matches then will,
increase the counter by 1.
3. if count of counter reaches to the length of the pattern then will start removing unwanted characters which are not in patter.
*/
public class SubstringContainsCharacterOfPattern {
 
	//creating array of 256 characters and storing the occurrence of characters in the these arrays.
	int[] hash_pat = new int[256];
	int[] hash_str = new int[256];
	public void finsSubstring(String str,String pattern)
	{
		for(int i=0;i<pattern.length();i++){
			/*at the index of the character increase the count. if first is t then increase the index of t in 256 size of array,
			 * index of t in 256 size of array will be somewhere 110*/
			
			hash_pat[pattern.charAt(i)]++;   
		}
		
	
		int count=0, start=0, startIndex=-1,minLength = Integer.MAX_VALUE;
		//Starting from start and initialize the window with size 1 and will keep on increasing the window till all chars of patters are matched.
		for(int j=0;j<str.length();j++)
		{
			hash_str[str.charAt(j)]++;
			/*this is the way of matching the characters as we have already stored the occurrence in array, so if the char_patter array at the index of char is not zero,
			 * that means character is present in pattern and occurrence if more than occurrence in char_str array.*/
			if(hash_pat[str.charAt(j)]!=0 && hash_pat[str.charAt(j)]>=hash_str[str.charAt(j)]){
				count++;
			}
			
			if(count==pattern.length())
			{
				//keep on find the start index by removing the extra 
				while(hash_pat[str.charAt(start)]==0||hash_str[str.charAt(start)]>hash_pat[str.charAt(start)])
				{
					//if the matched characters are less in char_pattern than char_str then we will remove the extra characters.
					if(hash_str[str.charAt(start)]>hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}
				
				int len_window = (j - start) + 1;
				if(len_window<minLength)
				{
					minLength=len_window;
					startIndex=start;
				}
				
			}
		}
		if(startIndex==-1)
		{
			System.out.println("There is no such substring exist");
			return;
		}
		
		System.out.println(" "+str.substring(startIndex, startIndex+minLength));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "this is a test string";
        String pattern = "tist";
        SubstringContainsCharacterOfPattern obj = new SubstringContainsCharacterOfPattern();
        obj.finsSubstring(str, pattern);
	}

}
