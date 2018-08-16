package countWaysToReachNthStair;

/*
 * We can easily find recursive nature in above problem. The person can reach n’th stair from either (n-1)’th stair or from (n-2)’th stair. Let the total number of ways to reach n’t stair be ‘ways(n)’. The value of ‘ways(n)’ can be written as following.

    ways(n) = ways(n-1) + ways(n-2)
The above expression is actually the expression for Fibonacci numbers, but there is one thing to notice, the value of ways(n) is equal to fibonacci(n+1).

ways(1) = fib(2) = 1
ways(2) = fib(3) = 2
ways(3) = fib(4) = 3
 * */
public class CountWaysToReachNthStair {

	
	
	public int findNumberOfWays(int numberOfStairs,int steps)
	{
		int[] ways = new int[numberOfStairs+1];
		
		ways[0] = 1;
		ways[1] = 1;
		
		for(int i=2;i<=numberOfStairs;i++)
		{
			ways[i]=0;
			for(int j=1;j<=steps && j<=i ; j++)
			{
				ways[i] += ways[i-j];
			}
		}
		
		return ways[numberOfStairs];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountWaysToReachNthStair obj = new CountWaysToReachNthStair();
		
		System.out.println(obj.findNumberOfWays(4, 2));
	}

}
