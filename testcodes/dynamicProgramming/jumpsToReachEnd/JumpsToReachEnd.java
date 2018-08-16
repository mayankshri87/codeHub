package jumpsToReachEnd;
/*Minimum number of jumps to reach end
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)

Solution - We will solve this problem by using the dynamic programmming approach.
*/

public class JumpsToReachEnd {
	int[] array;
	
	public JumpsToReachEnd(int[] array)
	{
		this.array = array;
	}

	public int minimumNumberOfJumpRequired()
	{
		//create an array that will hold the numeber of jumbs required to reach index i
		
		if(array.length == 0 || array[0]==0)
		{
			return Integer.MAX_VALUE;
		}
		//creating a jump array which will store the number of jumps need to rech index for array
		int[] jump = new int[array.length];
		//initiating the index 0 with vakue 0 as it no steps are needed to reach first element for the array
		jump[0]=0;
		for(int i=1;i<array.length;i++)
		{
			jump[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++)
			{
				System.out.println("i = "+i);
				System.out.println(j+" + "+array[j]);
				if(i<=j+array[j] && jump[j]!=Integer.MAX_VALUE)
				{
					jump[i] = Math.min(jump[i], jump[j]+1);
					break;
				}
			}
		}
		return jump[jump.length-1];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		JumpsToReachEnd obj = new JumpsToReachEnd(array);
		
		System.out.println(obj.minimumNumberOfJumpRequired());
		
	}

}
