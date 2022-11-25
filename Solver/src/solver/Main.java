package solver;

import java.util.Arrays;

public class Main {
	private static final int GRID_SIZE = 9;

	public static void main(String[] args) {
//		int[][] board = { 
//				{ 7, 0, 2, 0, 5, 0, 6, 0, 0 }, 
//				{ 0, 0, 0, 0, 0, 3, 0, 0, 0 },
//				{ 1, 0, 0, 0, 0, 9, 5, 0, 0 },
//				{ 8, 0, 0, 0, 0, 0, 0, 9, 0 },
//				{ 0, 4, 3, 0, 0, 0, 7, 5, 0 },
//				{ 0, 9, 0, 0, 0, 0, 0, 0, 8 },
//				{ 0, 0, 9, 7, 0, 0, 0, 0, 5 }, 
//				{ 0, 0, 0, 2, 0, 0, 0, 0, 0 }, 
//				{ 0, 0, 7, 0, 4, 0, 2, 0, 3 }
//
//		};
		int[][] board = { 
				{ 0, 1, 0, 0, 0, 0, 0, 8, 2 }, 
				{ 0, 0, 0, 0, 0, 3, 0, 0, 0 },
				{ 8,7,2, 0, 0, 4, 9, 0, 3 },
				{ 0, 3, 6, 0, 0, 0, 0, 0, 0 },
				{ 2, 0, 7, 0, 0, 6, 0, 0, 0 },
				{ 0, 0, 9, 4, 5, 0, 2, 0, 0 },
				{ 0, 9, 0, 0, 0, 8, 0, 1, 7 }, 
				{ 0, 4, 0, 3, 6, 0, 0, 0, 0 }, 
				{ 3, 2, 8, 0, 9, 1, 6, 0, 0 }

		};
		
		
		if(solveBoard(board)) {
			System.out.println("Solved successfuly");
		}
		else {
			System.out.println("Unsolvable Board");
		}
		
		printBoard(board);
		
		
//		System.out.print(Arrays.deepToString(board) + "\n");
//		;
//		// System.out.println(isNumberInKvadrat(board, 7, 0));
//		// System.out.println(isNumberInColumn(board,7,1));
////		System.out.println(isNumberInBox(board, 5, 2, 5));
//		System.out.println(board[1][1]);
//		System.out.println(isValidPosition(board,5, 1, 1));

//		for(int i=0;i<9;i++) {
//			System.out.print("{");
//			for(int j=0;j<9;j++) {
//				System.out.print(board[i][j]+"\t");
//			}
//			System.out.print("}");
//			System.out.println();
//		}

	}

	private static void printBoard(int[][] board) {
		for(int row=0;row<GRID_SIZE;row++) {
			if(row%3==0&&row!=0) {
				System.out.println("-----------");
			}
			for(int column=0;column<GRID_SIZE;column++) {
				if(column%3==0&column!=0) {
					System.out.print("|");
				}
				System.out.print(board[row][column]);
			}
			System.out.println();
		}
		
	}

	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {

			if (board[row][i] == number) {

				return true;

			}
		}
		return false;

	}

	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {

			if (board[i][column] == number) {

				return true;

			}
		}
		return false;

	}

	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;
		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
				if(board[i][j]==number) {
					return true;
				}

			}
		}

		return false;
	}
	private static boolean isValidPosition(int[][] board, int number, int row, int column) {
		
		
		
		return !isNumberInRow(board, number, row)&&
				!isNumberInColumn(board, number, column)&&
				!isNumberInBox(board, number, row, column);
	}
	
	private static boolean solveBoard(int[][] board) {
		for(int row=0;row<GRID_SIZE;row++) {
			for(int column=0;column<GRID_SIZE;column++) {
				if(board[row][column]==0) {
					for(int numberToTry=1;numberToTry<=GRID_SIZE;numberToTry++) {
						if(isValidPosition(board, numberToTry, row, column)) {
							board[row][column]=numberToTry;
							if(solveBoard(board)) {
								return true;
							}
							else {
								board[row][column]=0;
								
							}
						}
//						if(board[row][column]!=numberToTry) {
//							return true;
//						}
						
					}
					return false;
				}
				
			}
			
		}
		
		
		
		return true;
	};
}