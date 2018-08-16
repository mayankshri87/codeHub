package greatestCommonSubSequence;

import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.xssf.XLSBUnsupportedException;

public class LongestCommonSubSequence {

	//Declaring the dynamicProgramming table
	private int[][] dpTable;
	private String X;
	private String Y;
	
	public LongestCommonSubSequence(String X,String Y)
	{
		/*Initiating the dynamic table with x.length+1 and y.length+1 to consider the base case X is empty string or 
		 * Y is empty string*/
		
		this.X = X;
		this.Y = Y;
		this.dpTable = new int[X.length()+1][Y.length()+1];
		
	}
	
	public void findLogestCommonSubsequence()
	{
		for(int rowIndex=1;rowIndex<=X.length();rowIndex++)
		{
			for(int columnIndex=1;columnIndex<=Y.length();columnIndex++)
			{
				if(Y.charAt(columnIndex-1)==X.charAt(rowIndex-1))
				{
					dpTable[rowIndex][columnIndex] = 1 + dpTable[rowIndex-1][columnIndex-1];
				}else{
					dpTable[rowIndex][columnIndex] = Math.max(dpTable[rowIndex-1][columnIndex], dpTable[rowIndex][columnIndex-1]);
				}
			}
		}
		
		for(int i=X.length(),j=Y.length();i>0 && j>0;){
			
			if(dpTable[i][j]==dpTable[i-1][j]){
				i=i-1;
			}else{
				System.out.print(" "+X.charAt(i-1));
				i=i-1;
				j=j-1;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String X = "AGGTAB";
	     String Y = "GXTXAYB";
	     LongestCommonSubSequence obj = new LongestCommonSubSequence(X, Y);
	     
	     obj.findLogestCommonSubsequence();

	}

}
