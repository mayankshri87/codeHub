package DynamicProgramming.Fibonacci;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.varia.FallbackErrorHandler;

public class Fibonacci {
	
	private Map memorizeMap;
	
	public Fibonacci()
	{
		this.memorizeMap = new HashMap<>();
		this.memorizeMap.put(0, 0);
		this.memorizeMap.put(1, 1);
	}
	
	//This is the recursive method, taht will be called and store the solution of the sub problem in the memorize map.
	public int findSolution(int number){
		
		//If memorize map already has the solution of the subproblem then return the solution
		if(memorizeMap.containsKey(number))
			return (int) memorizeMap.get(number);
		//Calling this method recursively to store the solution of the subproblem,
		//here in this case we need to find the solution for number-1 and number-2 to the solution for number and store those solutions in the memorize map.
		memorizeMap.put(number-1, findSolution(number-1));
		memorizeMap.put(number-2,findSolution(number-2));
		
		//In the above line we have already find the solution for the subproblems and stored in the memorize map,
		//so we easily calculate solution from the given number be getting solution for the subproblem stored in memorize map.
		int calculatedNumber = (int)memorizeMap.get(number-1)+(int)memorizeMap.get(number-2);		
		
		//After getting the problem for number we store it in the memorize table.
		memorizeMap.put(number, calculatedNumber);
		
		//returning the solution.
		return calculatedNumber;
	}

	public static void main(String[] args) {


		Fibonacci obj = new Fibonacci();
		System.out.println(obj.findSolution(6));

	}

}
