package maxRactangleInMatrix;
/*
 * Input :  0 1 1 0
          	1 1 1 1
          	1 1 1 1
          	1 1 0 0

	Output :1 1 1 1
          	1 1 1 1
          	
Step 1: Find maximum area for row[0]
Step 2:
    for each row in 1 to N - 1
        for each column in that row
            if A[row][column] == 1
              update A[row][column] with
                A[row][column] += A[row - 1][column]
    find area for that row
    and update maximum area so far 
 * */
import java.util.Stack;

public class MaxRactangleInMatrix {
	int[][] matrix;
	int rows;
	int columns;
	
	public MaxRactangleInMatrix(int[][] matrix,int rows, int columns) {
		this.matrix = matrix;
		this.rows = rows;
		this.columns = columns;
	}
/*Every row will be considered as the histogram, We try to find out the maximum ractangle in the histogram(bar chart)
 * Algorithm to find the max area in a histogram
 * 1) Create an empty stack.

2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
	a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
	b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).

3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 * 
 * */	
	public int histogram(int[] arr){
		int maxArea = -1;
		int area = 0;
		Stack<Integer> st = new Stack<Integer>();
		int i = 0;
		/*
		 * 1. If the stack is empty or the 
		 * */
		while(i<columns){
			if(st.isEmpty()||arr[st.peek()] <= arr[i]){
				st.push(i++);
			}else{
				int top = arr[st.peek()];
				st.pop();
				area = i*top;
				
				if(!st.isEmpty()){
					area = top *(i - st.peek() - 1);
				}
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while(!st.isEmpty()){
			int top = arr[st.peek()];
			st.pop();
			area = top*i;
			
			if(!st.isEmpty()){
				area = top * (i-st.peek()-1);
			}
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
	}
	
	public int findAreaOfMaxRactanle(){
		
		int result = histogram(matrix[0]);
		
		for(int rowIndex=1;rowIndex<rows;rowIndex++){
			for(int columnIndex=0;columnIndex<columns;columnIndex++){
				if(matrix[rowIndex][columnIndex]==1){
					matrix[rowIndex][columnIndex] = matrix[rowIndex][columnIndex] + matrix[rowIndex-1][columnIndex];
				}
			}
			//Finding max area for every row i.e. histogram(Each row will be a histogram)
			result = Math.max(result, histogram(matrix[rowIndex]));
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int rows = 4;
	     int columns = 4;
	 
		int[][] matrix = {
						{0, 1, 1, 0},
                		{1, 1, 1, 1},
                		{1, 1, 1, 1},
                		{1, 1, 0, 0}
                		};
		
		MaxRactangleInMatrix maxRactangle = new MaxRactangleInMatrix(matrix, rows, columns);
		
		System.out.println(maxRactangle.findAreaOfMaxRactanle());

	}

}
