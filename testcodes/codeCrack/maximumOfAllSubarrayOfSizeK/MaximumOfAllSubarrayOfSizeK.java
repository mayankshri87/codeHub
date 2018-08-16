package maximumOfAllSubarrayOfSizeK;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.internal.InexactComparisonCriteria;

/*Examples:

Input :
arr[] = {1, 2, 1, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90*/
public class MaximumOfAllSubarrayOfSizeK {

	int array[];
	int size;
	
	public MaximumOfAllSubarrayOfSizeK(int[] array, int size)
	{
		this.array = array;
		this.size = size;
	}
	
	/*A Dequeue (Double ended queue) based method for printing maixmum element of all subarrays of size k*/
	public void printMaxium()
	{
		// Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window
		Deque<Integer> indexQueue = new LinkedList<Integer>();
		
		/*loop for elements*/
		int i;
		for(i=0;i<size;i++)
		{
			/*Run while loop and check if element at index [i] i.e. array[i] is greater that element at index store in Queue at last i.e. array[inexQueue.peekLast()],
			 * and remove last element. So that the last element will be the */
			while(!indexQueue.isEmpty() && array[indexQueue.peekLast()]<array[i])
			{
				indexQueue.removeLast();
			}
			indexQueue.addLast(i);
		}
		for(;i<array.length;i++){
			
			/*print the element in from array for first index that is indexQueue. indexQueue.peek() will give the element at the front*/
			System.out.print(" "+array[indexQueue.peek()]);
			
			//remove index from the front of indexQueue if it is out of window size.
			while(!indexQueue.isEmpty() && indexQueue.peek() <= i - size)
			{
				indexQueue.removeFirst();
			}
			
			while(!indexQueue.isEmpty() && array[i]>array[indexQueue.peekLast()])
			{
				indexQueue.removeLast();
			}
			indexQueue.addLast(i);
			
		}
		if(!indexQueue.isEmpty())
		{
			System.out.print(" "+array[indexQueue.peek()]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {1, 2, 1, 1, 4, 5, 2, 3, 6};
		int size = 3;
		
		MaximumOfAllSubarrayOfSizeK obj = new MaximumOfAllSubarrayOfSizeK(array,size);
		
		obj.printMaxium();
	}

}
