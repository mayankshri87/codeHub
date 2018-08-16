package smallestAndSecondSmallest;

/*Find the smallest and second smallest elements in an array
 * 
 * Input:  arr[] = {12, 13, 1, 10, 34, 1}
	Output: The smallest element is 1 and second Smallest element is 10
        */

public class SmallestAndSecondSmallest {
	int[] array;
	
	public SmallestAndSecondSmallest(int[] array)
	{
		this.array = array;
	}
	
	public void findSmallestAndSecondSmallest(){
		
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		/*Loop through array and find the smallest and secind smallest number*/
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<first)
			{
				second = first;
				first = array[i];
			}
			/*array[i] is between first and second i.e. array[i]< first but array[i]>second*/
			else if(array[i]<second && array[i]!=first)
			{
				second = array[i];
			}
		}
		
		System.out.println("Smallest = "+first+" second smallest = "+second);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {12, 13, 1, 10, 34, 1};
		
		SmallestAndSecondSmallest obj = new SmallestAndSecondSmallest(array);
		
		obj.findSmallestAndSecondSmallest();
	}

}
