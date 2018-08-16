package misc;

public class PrintAllKLenghtStrings {

	public void printAllKLenthStrings(String[] sfinal, int k, String winner) {
		printAllKlenghtStirngRecur(sfinal, "", sfinal.length, k, winner);
	}

	public void printAllKlenghtStirngRecur(String[] sfinal, String prefix, int n, int k, String winner) {
		if (k == 0) {
			/*
			 * if(prefix.equals(winner)) { // }
			 */

			System.out.println(" " + prefix);
			return;
		}

		for (int i = 0; i < n; ++i) {
			String newPrefix = prefix + sfinal[i];
			// System.out.println(newPrefix);
			printAllKlenghtStirngRecur(sfinal, newPrefix, n, k - 1, winner);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sfinal = { "orange", "apple", "apple", "banana", "orange", "orange", "apple", "avocado" };
		String winner = "orangeappleavocado";
		PrintAllKLenghtStrings obj = new PrintAllKLenghtStrings();
		obj.printAllKLenthStrings(sfinal, 3, winner);

	}

}
