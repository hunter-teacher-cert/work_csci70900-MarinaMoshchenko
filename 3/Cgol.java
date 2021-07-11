import java.io.*;
import java.util.*;

/**
TEAM WORK: ERIC W., IULIAN, MARINA
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.

   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol{

		//initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
	   char [][]board = new char[rows][cols];
		for (int r=0; r<rows; r++){
		  for (int c=0; c<cols; c++) {
			board [r][c]='O';
			}	
		}
		return board;
  }
	/*
		board[2][3]='X';	//assignment of live cells
		board[1][3]='X';
		board[3][3]='X';
		board[1][2]='X';
		board[3][4]='X';
		board[2][2]='X';
		board[2][4]='X'; 
	   return board; */


		//print the board to the terminal
  public static void printBoard(char[][] board) {
    for (int r=0; r<board.length; r++){		//Printing by rows
      for (int c=0; c<board[r].length; c++){
        System.out.print(board[r][c] + " ");
    }
	System.out.println();
	}


  }
 

		//set cell (r,c) to live values
  public static void setCell(char[][] board, int r, int c, char val){
	  board[r][c] = val;
  }
		// initialize the values,hard code r and c to have values of x inital screen
  //board[r][c] = val;
  //}

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Number of Living Neighbours ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) { //single cell check for being live
	  int LivCellCounter=0; 	//add limitation to the board 5x5 will not check non-existing cells
	  
	  if ((r < 0 || c < 0) || (r > board.length || c > board[r].length)){ //beyond the board
		  return 0;
	  }
	
	  
	  if (r-1 < 0 || c-1 < 0){
	  }else{
			if(board[r-1][c-1]=='X'){	//diagonal top left 
			LivCellCounter++;
			}
	  }
	  if (r-1 < 0){
	  }else{
			if(board[r-1][c]=='X'){	//diagonal top
			LivCellCounter++;
			}
	  }
	  if (r-1 < 0 || c+1 > board[r].length){
	  }else{
			if(board[r-1][c+1]=='X'){	//diagonal top right
			LivCellCounter++;
			}
	  }
	  if (c-1 < board[r].length){
	  }else{
			if(board[r][c-1]=='X'){ 	//left
			LivCellCounter++;
			}
	  }
	  if (c+1 > board[r].length){
	  }else{
			if(board[r][c+1]=='X'){	//right
			LivCellCounter++;
			}
	  }
	  if ((r+1 > board.length) || (c-1 < board[r].length)){
	  }else{
			if(board[r+1][c-1]=='X'){	//diagonal bottom left
			LivCellCounter++;
			}
	  }
	  if (r+1 > board.length){
	  }else{
			if(board[r+1][c]=='X'){		//bottom
			LivCellCounter++;
			}
	  }
	  if ((r+1 > board.length) || (c+1 > board[r].length)){
	  }else{
			if(board[r+1][c+1]=='X'){		//diagonal bottom right
			LivCellCounter++;
			}
	  }	
	  
	   System.out.println("LiveCellCounter: " + LivCellCounter);
	   return LivCellCounter;
	   }


 // || board[r+1][c] || board[r][c-1] || board [r][c+1]){
     // LivCellCounter++

   // check the adjancent indices, i-1, i+1, j-1, j+1 and use the counter ++
  //}

     //precond: given a board and a cell
     //postcond: return next generation cell state based on CGOL rules
     //(alive 'X', dead ' ')
	
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Next Generation Cell State ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  

  public static char getNextGenCell(char[][] board, int r, int c) {
		int LivCellCounter;
		LivCellCounter=countNeighbours(board,r,c);
		//System.out.println("Number of neighbouring living cells: " + LivCellCounter); //To be removed later
			
			if (board[r][c]=='X' && (LivCellCounter<2 || LivCellCounter>3)){	//Cell will not live...
				 return 'O';
			 }
			if (board[r][c]=='X' && (LivCellCounter==2 || LivCellCounter==3)){	//Cell will live
				return 'X';
			 }
			if (board[r][c]=='O' && LivCellCounter==3){		//Cell will be born
				return 'X';
			}else{
			return 'O';
	   }
  }

	  
	


		//generate new board representing next generation
	public static char[][] generateNextBoard (char [][] board){
		char [][] newBoard = new char [board.length][board[0].length];
		for (int r=0; r<board.length; r++){
			for (int c=0; c<board[r].length; c++){
					newBoard[r][c]=getNextGenCell(board, r, c);
			   }
		   }
		 return newBoard;
	}

 /*
public static char[][] generateNextBoard(char[][] board) {
	char[][] newBoard = new char[board.length][board[0].length]; //board.length: rows, board[0].length:columns
	for(int i = 0; i < board.length; i++)
	{
		for(int j = 0; j < board[i].length; j++)
		{
			newBoard[i][j] = getNextGenCell(board, i, j);
		}
	}
	return newBoard;
  }
*/  
  
  
  
  
  
  
 // public static char[][] generateNextBoard(char[][] board) {
      
	  
  public static void main(String[] args ){
		char[][] board;
		board=createNewBoard(5, 5);
		//int[][] dataChart = new int [15][8];
		setCell(board, 0, 0, 'X');
		setCell(board, 0, 1, 'X');
		setCell(board, 1, 0, 'X');
		
		System.out.println("Gen X:");
		printBoard(board);
		System.out.println("--------------------------\n\n");
		
		board = generateNextBoard(board);
		
		System.out.println("Gen X+1:");
		printBoard(board);
		System.out.println("--------------------------\n\n");
  }
		
		
	/*	char[][] board;
		board=createNewBoard(5, 5);
		printBoard(board);
		System.out.println("--------------------------\n\n");
		//int LivCellCounter;
		//board = getNextGenCell(board,2,3);
		char[][]newBoard;
		newBoard = generateNextBoard(board);
		printBoard(newBoard);
	   
		}

  
 /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

 //
 int[][] dataChart = new int [15][8];
  ^new 2d array called dataChart that has 15 row, 8 col
  
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');

    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)

    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");

    board = generateNextBoard(board);

    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

}//end class