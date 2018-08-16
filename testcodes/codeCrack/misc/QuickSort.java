package misc;

import java.util.Random;

/*find the kth largest element in an array.*/
public class QuickSort {

	int[] array = { 1, 5, 4, 8, -2 };

	public int quickSort(int firstIndex, int lastIndex, int k) {
		int pivot = partition(firstIndex, lastIndex);

		if (pivot > k) {
			return quickSort(firstIndex, pivot - 1, k);
		} else if (pivot < k) {
			return quickSort(pivot + 1, lastIndex, k);
		}

		return array[k];
	}

	public int partition(int firstIndex, int lastIndex) {
		int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;

		swap(pivot, lastIndex);

		for (int i = firstIndex; i < lastIndex; i++) {
			if (array[i] > array[lastIndex]) {
				swap(i, firstIndex);
				firstIndex++;
			}
		}
		swap(firstIndex, lastIndex);
		return firstIndex;
	}

	public void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] arg) {
		int firstIndex = 0;
		QuickSort quickSort = new QuickSort();
		int lastIndex = quickSort.array.length - 1;
		System.out.println("secind highest number is " + quickSort.quickSort(firstIndex, lastIndex, 2));
	}
}
