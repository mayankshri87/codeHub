package maximumDifferenceBetweenIndex;
/*
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
 * 
 * 
 * To solve this problem, we need to get two optimum indexes of arr[]: left index i and right index j. 
 * For an element arr[i], we do not need to consider arr[i] for left index if there is an element smaller than arr[i] on left side of arr[i]. 
 * Similarly, if there is a greater element on right side of arr[j] then we do not need to consider this j for right index. 
 * So we construct two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the smallest element on left side of arr[i] including arr[i], 
 * and RMax[j] holds the greatest element on right side of arr[j] including arr[j]. 
 * After constructing these two auxiliary arrays, we traverse both of these arrays from left to right. While traversing LMin[] and RMa[] if we see that LMin[i] is greater than RMax[j], then we must move ahead in LMin[] (or do i++) because all elements on left of LMin[i] are greater than or equal to LMin[i]. Otherwise we must move ahead in RMax[j] to look for a greater j – i value.
 * */
public class MaximumDifferenceBetweenIndex {
	
	int[] array;
	int size;
	
	MaximumDifferenceBetweenIndex(int[] array)
	{
		this.array = array;
		this.size = array.length;
	}

	
	public int findDifference()
	{
		/* Construct leftMin[] such that leftMin[i] stores the minimum value
	       from (array[0], array[1], ... array[i]) */
		int[] leftMin = new int[size];
		leftMin[0] = array[0];
		for(int i=1;i<size;i++)
		{
			leftMin[i] = min(array[i], leftMin[i-1]);
		}
		
		int[] rightMax = new int[size];
		rightMax[size-1] = array[size-1];
		
		for(int j=size-2;j>=0;j--)
		{
			rightMax[j] = max(array[j],rightMax[j-1]);
		}
		
		int i=0;
		int j=0;
		int maxDifference = -1;
		

	    /* Traverse both arrays from left to right to find optimum j - i
	        This process is similar to merge() of MergeSort */
		while(i<size && j<size)
		{
			if(leftMin[i]<rightMax[j])
			{
				if(maxDifference<j-i)
				{
					maxDifference = j-i;
				}
				j= i+1;
			}else{
				i = i+1;
			}
		}
		
		return maxDifference;
	}
	
	int min(int a, int b)
	{
		if(a>b)
		{
			return b;
		}else{
			return a;
		}
	}
	
	int max(int a,int b)
	{
		if(a>b)
		{
			return a;
		}else{
			return b;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
