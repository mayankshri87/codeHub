package misc;

public class NonContagiousSequenceWithMaximumSum {

	public static int getMaximumSum(int[] array, int n) {
		int[] max = new int[n + 1];

		max[0] = array[0];
		max[1] = (array[0] > array[1] ? array[0] : array[1]);
		// { -2,11,-4,13,-5,2 };
		// {-2,11,11,13}
		for (int i = 2; i < n; i++) {
			max[i] = (max[i - 1] > max[i - 2] + array[i] ? max[i - 1] : array[i] + max[i - 2]);
		}

		return max[n - 1];
	}

	public static void main(String[] arg) {

		int[] array = { -2, 11, -4, 13, -5, 2 };

		int n = array.length;
		int maxSum = getMaximumSum(array, n);
		System.out.println(maxSum);
	}

}
