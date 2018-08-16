package misc;

/*
 Input : arr[] = {8, 3, 1, 2}
Output : 29
Explanation : Let us see all rotations
{8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11 
{3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29 - after 1 rotation - Here rotation is shifting elements to the left 
{1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27 - after 2nd rotation
{2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*1 = 17 - after 3rd rotation

Input : arr[] = {3, 2, 1}
{3,2,1} = 3*0 + 2*1 + 1*2 = 3
{2,1,3} = 2*0 + 1*1 + 3*2 = 7
{1,3,2} = 1*0 + 3*1 + 2*2 = 7
Output : 8
 * */
public class MaximumSumOfArrayAfterRotation {

	int[] array;

	public MaximumSumOfArrayAfterRotation(int[] array) {
		this.array = array;
	}

	/*
	 * In this method we will rotate the array and find the maximum sum with
	 * i*array[i]
	 */
	public int findMaximumSumForAllRotations() {
		int result = Integer.MIN_VALUE;

		// when i increases that means one rotation happened.
		for (int i = 0; i < array.length; i++) {
			int current_sum = 0;
			for (int j = 0; j < array.length; j++) {
				/*--This logic will give you the index after rotation. Consider a case {3,2,1} now i is 1 so the index is 1
				 * and the sum will be j*array[index] (j is 0 and array[index] = array[1] = 2 so it 2*0.)  */
				int index = (i + j) % (array.length - 1);
				current_sum = current_sum + j * array[index];

			}

			result = Math.max(result, current_sum);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 8, 3, 1, 2 };
		MaximumSumOfArrayAfterRotation maxSum = new MaximumSumOfArrayAfterRotation(array);

		System.out.println(maxSum.findMaximumSumForAllRotations());
	}

}
