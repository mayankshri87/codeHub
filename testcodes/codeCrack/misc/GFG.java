package misc;
//A Dynamic Programming based Java
//program to find minimum of coins
//to make a given change V
import java.io.*;

class GFG 
{
	// m is size of coins array 
	// (number of different coins)
	static int minCoins(int coins[], int m, int V)
	{
		// table[i] will be storing 
		// the minimum number of coins
		// required for i value. So 
		// table[V] will have result
		int table[] = new int[V + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= V; i++)
		table[i] = Integer.MAX_VALUE;

		// Compute minimum coins required for all
		// values from 1 to V
		for (int i = 1; i <= V; i++)
		{
			// Go through all coins smaller than i
			for (int j = 0; j < m; j++)
			if (coins[j] <= i)
			{
				int sub_res = table[i - coins[j]];
				System.out.println(sub_res);
				if (sub_res != Integer.MAX_VALUE 
					&& sub_res + 1 < table[i])
				System.out.println("new sub= "+(sub_res+1));
					table[i] = sub_res + 1;
						
				
			}
			
		}
		return table[V];
		
	}

	// Driver program 
	public static void main (String[] args) 
	{
		int coins[] = {1,2};
		int m = coins.length;
		int V = 6;
		System.out.println ( "Minimum coins required is "
							+ minCoins(coins, m, V));
	}
}

//This article is contributed by vt_m.
