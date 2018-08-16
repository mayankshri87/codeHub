package arrangePairs;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

/*
 * Minimum number of swaps required for arranging pairs adjacent to each other.
 * 
 * Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
 * */

public class ArrangePairs {
	
	//pairs map will hold the pairs such as if 1->3 then 1 is key and 3 is value;
	Map pairs;
	int[] array;
	Map indexes;
	
	public ArrangePairs(Map pairs,int[] array){
		this.pairs = pairs;
		this.array = array;
		
		this.indexes = new HashedMap<Integer,Integer>();
		
		for(int i=0;i<this.array.length;i++){
			this.indexes.put(array[i], i);
		}
	}

	/*this is the recursive method and will be called for each pair i.e. first consider 3 and 1 and next move to 4 and 5 and so on.
	 * int current is current index */
	public int findMinimumNumberOfSwaps(int current){
		
		//Base condition, if all the elements are accessed
		if(current==array.length)
		{
			return 0;
		}
		
		int firstElement = array[current];
		int secondElement = array[current+1];
		
		int pairElementFirst = (int) pairs.get(firstElement);
		int pairElementSecond = (int) pairs.get(secondElement);
		//if the elements are already pair to each other then do not arrange and move to next pair.
		if(pairElementFirst==secondElement)
		{
			return findMinimumNumberOfSwaps(current+2);
		}
		//getting the indexes for the elements to swap;
		int indexOfFirstElement = (int) indexes.get(firstElement);
		int indexOfSecondElement = (int) indexes.get(secondElement);
		int indexOfPairElementFirst = (int) indexes.get(pairElementFirst);
		int indexOfPairElementSecond = (int) indexes.get(pairElementSecond);
		/*when we swap second element with the pair element*/
		swap(indexOfSecondElement,indexOfPairElementFirst);
		//number of swaps if we swap second element for even unarranged pair
		int value1 = findMinimumNumberOfSwaps(current+2);
		//swapping back so that we can try if we select the firstElement for swap and find number of swaps
		swap(indexOfSecondElement, indexOfPairElementFirst);
		
		/*when swaping the first element and keeping the second as it is*/
		swap(indexOfFirstElement, indexOfPairElementSecond);
		int value2 = findMinimumNumberOfSwaps(current+2);
		swap(indexOfFirstElement, indexOfPairElementSecond);
		
		return 1+Math.min(value1, value2);
	}
	private void swap(int index1, int index2) {
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
		//updating the indexses map
		indexes.put(array[index1], index2);
		indexes.put(array[index2], index1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 5, 6, 4, 1, 2};
		 Map pairs = new HashedMap<Integer,Integer>();
		 //{1->3, 2->6, 4->5}
		 pairs.put(1, 3);
		 pairs.put(3, 1);
		 pairs.put(6, 2);
		 pairs.put(2, 6);
		 pairs.put(4, 5);
		 pairs.put(5, 4);
		 
		 ArrangePairs obj = new ArrangePairs(pairs, array);
		 
		 System.out.println("Number of minimum swap required is -- "+obj.findMinimumNumberOfSwaps(0));

	}

}
