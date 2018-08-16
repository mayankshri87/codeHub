package wildCardPatternMatching;

import java.util.Arrays;

/*
Text = "baaabab",
Pattern = “*****ba*****ab", output : true
Pattern = "baaa?ab", output : true
Pattern = "ba*a?", output : true
Pattern = "a*ab", output : false 
 * */
public class WilcardPatternMatching {

	boolean[][] solutionMatix;
	String text;
	String pattern;
	int rowSize;
	int columnSize;
	
	WilcardPatternMatching(String text, String pattern) {
		
		this.text = text;																								
		this.pattern = pattern;
		this.rowSize = text.length() +1;
		this.columnSize = pattern.length() +1;
		this.solutionMatix = new boolean[rowSize][columnSize];
		

	}
	
	public boolean checkIfPatternMatches(){
		
		//Initialize the solution matrix to false
		for(int i=0;i<rowSize;i++){
			Arrays.fill(solutionMatix[i], false);
		}
		
		//Condition 1 - pattern and text is null or empty 
		solutionMatix[0][0] = true;
		
		//condition 2 - if the pattern is '*'
		for(int j=1;j<columnSize;j++){
			if(this.pattern.charAt(j-1)=='*'){
				solutionMatix[0][j] = solutionMatix[0][j-1];
			}
		}
		
		
		for(int i=1;i<rowSize;i++){
			for(int j=1;j<columnSize;j++){
				
				 // Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
				if(this.pattern.charAt(j-1)==this.text.charAt(i-1)||this.pattern.charAt(j-1)=='?'){
					solutionMatix[i][j] = solutionMatix[i-1][j-1];
				}
				// Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
				else if(this.pattern.charAt(j-1)=='*'){
					solutionMatix[i][j] = solutionMatix[i-1][j] || solutionMatix[i][j-1];
				}else{
					solutionMatix[i][j] = false;
				}
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "baaabab";
		String pattern = "ba*a?";
		
		
		WilcardPatternMatching patternMatching = new WilcardPatternMatching(text, pattern);
		
		if(patternMatching.checkIfPatternMatches()){
			System.out.println("Pattern is matching");
		}else{
			System.out.println("Pattern is not matching with the string");
		}
	}

}
