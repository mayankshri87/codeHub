package sortAStack;

import java.util.Stack;

public class SortAStack {

	public Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> auxillary = new Stack<Integer>();
		while(!stack.isEmpty()){
			int temp = stack.pop();
			while(!auxillary.isEmpty() && auxillary.peek()>temp){
				stack.push(auxillary.pop());
			}
			auxillary.push(temp);
		}
		
		return auxillary;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortAStack obj = new SortAStack();
		Stack<Integer> input = new Stack<Integer>();
	        input.add(34);
	        input.add(3);
	        input.add(31);
	        input.add(98);
	        input.add(92);
	        input.add(23);

	        Stack<Integer> tmpStack = obj.sort(input);
	        while(!tmpStack.isEmpty()){
	        	System.out.print(tmpStack.pop()+" ");
	        }

	}

}
