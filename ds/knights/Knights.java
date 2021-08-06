import java.io.*;
import java.util.*;

public class Knights{


    
    private int[][] board;
    private int rows = 5;
    private int cols = 5;
    private int size=5;
    private String clearScreen="[0;0H\n";	//animating the board 

    private void delay(int n)
    {
	try 
	    {Thread.sleep(n);} 
	catch(InterruptedException e)
	    {}

    }
 
    public Knights(int size){
	rows = size;
	cols = size;
	this.size=size;
	int row,col;

	// Notice that the board is 4 bigger in both directions with 0's
	// in the middle and a 2 row/col border of -1.
	// Why are we doing this? - to exclude from possible moves
	board = new int[cols+4][rows+4];
	for (row = 0; row < rows+4; row++){
	    for (col = 0; col < cols+4 ; col++){
		board[col][row] = -1;
	    }
	}
	for (row = 2; row < rows+2; row++){
	    for (col = 2; col < cols+2 ; col++){
		board[col][row] = 0;
	    }
	}

	
    }

    public String toString(){
	int row,col;
	int value;
	String result = "";
	for (row = 0; row < rows+4; row++){
	    for (col = 0; col < cols+4; col++){
		value = board[col][row];
		//System.out.println("value of board col: " + col + ", row: " + row + " is " + value);

		// Why do we have this if as opposed to 
		// just adding the next value to the string?
		if (value < 10 && value >= 0){
		    result = result + "0" + value+ " "; //to display numbers 1-9 with leading zeros
		} else {
		    result = result + value + " ";	//to display just a two digit number 
		}
	    }
	    result = result +"\n";
	}
	return result;
    }

    public boolean solve(int col,int row, int count){	//
		boolean solved = false;
		//count ++;


		if (count>(row*col)){  //row*col
	    System.out.println("All the possible moves are done");
	    return true;
	}


	
	//we are tracking our moves in the board
	// and also built that border of -1 values.
	if ((board[col][row] != 0) || (board[col][row] == -1)){		//not -1 and not visited
	    return false;
	}
	
	
	
		board[col][row] = count;
		System.out.println("Count: " + count);
		count++;
		
		delay(200);
		System.out.println(clearScreen+this);


	
	solved = solve(row-2, col+1, count);
	if (!solved){
		solved = solve(row-1, col+2, count++);
	}
	/* for (r,c)
		(r-2, c+1)	//top right quadrant
		(r-1, c+2)	*/
	
	if (!solved){
		solved = solve(row+1, col+2, count++);
	}
	if (!solved){
		solved = solve(row+2, col+1, count++);
	}
		/* (r+1, c+2)	//bottom right quadrant
		(r+2, c+1) */
		
	if (!solved){
		solved = solve(row+2, col-1, count++);
	}
	if (!solved){
		solved = solve(row+1, col-2, count++);
	}
		/* (r+2, c-2)	//bottom left quadrant
		(r+1, c-2) */
	if (!solved){
		solved = solve(row-1, col-2, count++);
	}
	if (!solved){
		solved = solve(row-2, col-1, count++);
	}
	
		/* (r-1, c-2)	//top left quadrant
		(r-2, c-1) */

	

	// Here we unset where we were for the backtracking
	
	board[col][row]=0;
	return solved;
    }

    

    
}
