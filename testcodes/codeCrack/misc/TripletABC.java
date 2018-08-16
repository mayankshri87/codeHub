package misc;

// find triplet a = b+c
public class TripletABC {

	public static void main(String[] arg) {
		Integer[] arr = { 1, 2, 3, 4, 5 };

		for (int i = arr.length - 1; i > 0; i--) {

			for (int j = i - 1; j > 0; j--) {

				if (arr[i] == arr[j] + arr[j - 1]) {
					System.out.println("printing first number  " + arr[j] + " secind number " + arr[j - 1]);
				}
			}

		}
	}
}
