package misc;

import java.util.Arrays;
import java.util.Collections;

public class KlargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] array = { 1, 2, 3, 4, 5, 6 };

		System.out.println("printing the kth element " + KlargestElement(array, 2));

	}

	public static int KlargestElement(Integer[] array, int k) {

		Arrays.sort(array, Collections.reverseOrder());
		int largestElement = array[2];
		return largestElement;
	}

}
