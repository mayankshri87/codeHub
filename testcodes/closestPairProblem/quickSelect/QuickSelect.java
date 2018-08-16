package quickSelect;

import java.util.Random;

public class QuickSelect {
	
	private int[] nums;
	
	public QuickSelect(int[] nums){
		this.nums = nums;
	}
	
	public int select(int firstIndex,int lastIndex, int k){
		
		int pivot = partition(firstIndex, lastIndex);
		/*After the partition now greater elements are at the left side of the pivot and smaller elements are on the right side*/
		if(pivot>k)
		{
			/*Calling method recursively to avoid iterating through the whole list.*/
			return select(firstIndex,pivot-1,k);
		}else if(pivot<k)
		{
			return select(pivot+1,lastIndex,k);
		}
		return nums[k];
	}

	/*This method will return the pivot i.e. index where the all the elements in the left side of the partition are greater than the pivot index,
	 * and the right side items are smaller than pivot index*/
	private int partition(int firstIndex, int lastIndex) {
		
		/*Pivot will be decided on the basis of any random number selected between the first index and the last index*/
		
		int pivot = new Random().nextInt(lastIndex - firstIndex +1) + firstIndex;
		
		
		
		/*swap the pivot with the lastIndex and then iterate through the array and swap the element to the left side,
		 * with elements greater than the pivot*/
		swap(lastIndex,pivot);
		
		for(int i=firstIndex;i<lastIndex;i++)
		{
			if(nums[i]>nums[lastIndex]){
				swap(i,firstIndex);
				firstIndex++;
			}
		}
		swap(firstIndex,lastIndex);
		return firstIndex;
	}

	private void swap(int i, int j) {
		
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

	public static void main(String[] args) {
		
		int[] nums = {7,-2,5,8,1,6};
		//finding the second largest element
		int k = 2;
		QuickSelect obj = new QuickSelect(nums);
		
		System.out.println(obj.select(0, nums.length-1, k-1));
		
		

	}

}
