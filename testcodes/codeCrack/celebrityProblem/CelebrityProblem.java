package celebrityProblem;

import java.util.Stack;

import org.apache.poi.hslf.record.Slide;

import sun.misc.Cleaner;

public class CelebrityProblem {

	private int[][] knowMatrix;
	
	public CelebrityProblem(int[][] knowMatrix)
	{
		this.knowMatrix = knowMatrix;
	}
	
	/*In this method, we will not use any data structure else we will ue two pointers, one will start from the begin and another ill start from end.*/
	public int findCelebrity(int numberOfguest)
	{
		int startPointer = 0;
		int endPointer = numberOfguest-1;
		
		while(startPointer<endPointer)
		{
			/*skipping guest based on the decision made*/
			if(know(startPointer, endPointer))
			{
				startPointer++;
			}else{
				endPointer--;
			}
		}
		
		for(int i=0;i<numberOfguest;i++)
		{
			if(i!=startPointer && (know(startPointer, i) || !know(i,startPointer)))
			{
				return -1;
			}
		}
		return startPointer;
	}
	
	/*Here in this case we are using to find the celebrity*/
	public int findCelebrityUsingStack(int numberOfguest)
	{
		//creating a celebrity stack and will push all the celebrities in to this stack
		Stack celebrityStack = new Stack<Integer>();
		
		for(int i=0 ; i<numberOfguest ; i++)
		{
			celebrityStack.push(i);
		}
		
		
		/*loop through all the elements until only one element left in the stack */
		while(celebrityStack.size()>1)
		{
			int A = (int) celebrityStack.pop();
			int B = (int) celebrityStack.pop();
			/*if A know B then discard A otherwise discard B*/
			if(know(A,B))
			{
				celebrityStack.push(B);
			}else{
				celebrityStack.push(A);
			}
		}
		
		int C = (int)celebrityStack.pop();
		
		/*Check if the last guest in the stack know any one and also check anyone who does not know the last guest,
		 * in this case, there is no celebrity present in the guests*/
		
		for(int i=0;i<numberOfguest;i++)
		{
			if(i!=C && (know(C, i) || !know(i,C)))
			{
				return -1;
			}
		}
		
		return C;
	}
	
	private boolean know(int a, int b) {

		boolean response = (knowMatrix[a][b]==1)?true:false;
		return response;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] knowMatrix = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 }, 
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
		
		CelebrityProblem obj = new CelebrityProblem(knowMatrix);
		System.out.println(obj.findCelebrity(4));

	}

}
