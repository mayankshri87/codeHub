package knightTourProblem;

import java.awt.Checkbox;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

public class KnightTour {

	private int[][] chessBoard;
	
	//xMoves(towards x axis) and yMoves(towards y axis) tells you how a knight(horse in chess) can move e.g. 2 forward 1 downward i.e. x=2 and y =1.
	private int[] xMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	
	public KnightTour(int boradSize){
		this.chessBoard = new int[boradSize][boradSize];
		initialize();		
	}
	
	//Initialize method to initialize the chessboard with some unique value.
	private void initialize() {
	
		for(int i=0;i<chessBoard.length;i++)
		{
			for(int j=0;j<chessBoard.length;j++)
				chessBoard[i][j] = Integer.MIN_VALUE;
		}
					
	}
	
	public void solve(){
		
		//Picking up the first block as a starting point for knight and marking it as 1 step
		chessBoard[0][0] = 1;
		
		//calling findSolution() method to for the next step
		if(!findSolution(2,0,0)){
			System.out.println("No solution.....");
			return;
		}
		
		printSolution();
	}

	//Recursive method to find solution of KnightTour problem.
	private boolean findSolution(int stepCounter, int x, int y) {
		
		//Base condition - If all the blocks of chessboard are already accessed that means there is a solution and will return true in this case.
	
		if(stepCounter == (chessBoard.length*chessBoard.length)+1){
			return true;
		}
		
		//Lopping through all the moves knight can move
		for(int i=0;i<xMoves.length;i++){
			//Moving toward x axis i.e. forward
			int nextX = x + xMoves[i];
			//Moving toward y axis i.e. downward thats how knight moves in chess
			int nextY = y + yMoves[i];
			
			//checking if this move feasible and be considered as a part of solution.
			if(isFeasibleMove(nextX,nextY)){

				//If it is feasible move then will mark the step count in the chessboard.
				chessBoard[nextX][nextY] = stepCounter;
				
				//Calling method recursively for the next step.
				if(findSolution(stepCounter+1, nextX, nextY))
				{
					return true;
				}
				//BackTrack - If there is no solution for the next move then we will backtrack and try for the another move.
				
				chessBoard[nextX][nextY] = Integer.MIN_VALUE;
			}
			
			
		}
		return false;
	}

	//This method will check condition if move is in inside the chessboard and has not been considered in solution before.
	private boolean isFeasibleMove(int x, int y) {
		
		if(x>=chessBoard.length || x<0) return false;
		if(y>=chessBoard.length || y<0) return false;
		if(chessBoard[x][y] != Integer.MIN_VALUE) return false;
		
		return true;
	}

	private void printSolution() {
		
		for(int i=0;i<chessBoard.length;i++)
		{
			for(int j=0;j<chessBoard.length;j++)
				System.out.print(chessBoard[i][j]+" ");
			
			System.out.println("");
		}
		
	}

	public static void main(String[] args) {

		int boradSize = 7;
		
		KnightTour obj = new KnightTour(boradSize);
		
		obj.solve();

	}

}
