package misc;

public class LongestCommonSubSequence {
	static void lcs(String X, String Y, int m, int n) {
		int[][] lcs = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		int index = lcs[m][n];
		int temp = index;
		char[] longestString = new char[index + 1];
		longestString[index] = '\0';

		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				longestString[index - 1] = X.charAt(i - 1);
				i--;
				j--;
				index--;
			} else if (lcs[i - 1][j] > lcs[i][j - 1])
				i--;
			else
				j--;

		}

		System.out.print("LCS of " + X + " and " + Y + " is ");
		for (int k = 0; k <= temp; k++)
			System.out.print(longestString[k]);

	}

	// driver program
	public static void main(String[] args) {
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		int m = X.length();
		int n = Y.length();
		lcs(X, Y, m, n);
	}
}
