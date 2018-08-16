package stockSpanProblem;
//https://www.geeksforgeeks.org/the-stock-span-problem/
import java.util.Stack;

public class StockSpanProblem {

	int[] array;
	int size;
	public StockSpanProblem(int[] array)
	{
		this.array = array;
		this.size = array.length;
	}
	
	// a linear time solution for stock span problem
    // A stack based efficient method to calculate stock span values
	public void printStockSpan()
	{
		// Create a stack and push index of first element to it
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		
		 // Span value of first element is always 1
		int[] spans = new int[size];
		spans[0] = 1;
		
		// Calculate span values for rest of the elements
		for(int i=1;i<size;i++)
		{
			// Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
			while (!(st.empty()) && (array[st.peek()]<=array[i]))
				st.pop();
					
			// If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
            // is greater than elements after top of stack
			spans[i] = (st.empty()) ? (i+1):(i-st.peek());
			// Push this element to stack
			st.push(i);
		}
		
		for(int i=0;i<size;i++)
		{
			System.out.print(" "+spans[i]);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {10, 4, 5, 90, 120, 80};
		
		StockSpanProblem object = new StockSpanProblem(array);
		
		object.printStockSpan();
	}

}
