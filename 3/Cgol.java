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

// It works now. It was a curly brace. 

public class Cgol{

  //initialize empty board (all cells dead)

  public static char[][] createNewBoard(int rows, int cols) {
   char [][]board = new char[rows][cols];
    for (int r=0; r<rows; r++){
      for (int c=0; c<cols; c++) {
        board [r][c]='O';
        }
    }
    board[2][3]='X';
    board[1][3]='X';
    board[3][3]='X';
    board[2][2]='X';
    board[2][4]='X';
   return board;
}

  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for (int r=0; r<board.length; r++){		//Printing by rows
      for (int c=0; c<board[r].length; c++){
        System.out.print(board[r][c] + " ");
		
    }
	System.out.println();
	}


  }
 
/*
  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
   // initialize the values,hard code r and c to have values of x inital screen
  board[r][c] = val;
  //}

 */

  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
   int LivCellCounter=0;
   if(board[r-1][c]=='X'){
     LivCellCounter++;
   }
   if(board[r+1][c]=='X'){
     LivCellCounter++;
   }
   if(board[r][c-1]=='X'){
     LivCellCounter++;
   }
   if(board[r][c+1]=='X'){
     LivCellCounter++;
   }
   System.out.print(LivCellCounter);
   return LivCellCounter;
   }
 // || board[r+1][c] || board[r][c-1] || board [r][c+1]){
     // LivCellCounter++

   // check the adjancent indices, i-1, i+1, j-1, j+1 and the use the counter ++
  //}

     //precond: given a board and a cell
     //postcond: return next generation cell state based on CGOL rules
     //(alive 'X', dead ' ')
  
   public static char getNextGenCell(char[][] board, int r, int c) {
    int LivCellCounter;
    LivCellCounter=countNeighbours(board,2,3);
    System.out.println("Number of neighbouring living ceels: " + LivCellCounter); //To be removed later
    for (r=0; r<board.length; r++){
      for (c=0; c<board[r].length; c++){
         if (board[r][c]=='X' && LivCellCounter==0){
          board[r][c]='O';
       }
   }

   }
   return 'A';
  }

/*
  //generate new board representing next generation
 // public static char[][] generateNextBoard(char[][] board) {
      
*/
  public static void main( String[] args )
  {
    char[][] board;
	  board=createNewBoard(5, 5);
  	printBoard(board);
    int LivCellCounter;
   LivCellCounter=countNeighbours(board,2,3);
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