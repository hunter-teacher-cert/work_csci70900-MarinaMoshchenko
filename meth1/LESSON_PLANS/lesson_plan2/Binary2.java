import java.io.*;
import java.util.*;

public class Binary2{

    public static void main(String[] args) {
	int[] numArray = {1,2,3,4,5,6,7,8,9,1,0,11,12,13,14,15};
	long start, elapsed;
	
	start = System.currentTimeMillis(); 
	int myTarget = linearSearch (numArray, 3);
	elapsed = System.currentTimeMillis()-start;
	System.out.println("Elapsed time for linearSearch: " + elapsed + " misiseconds");
	System.out.println();
	
	start = System.currentTimeMillis();
	myTarget = binarySearchIterative(numArray, 3);
	elapsed = System.currentTimeMillis()-start;
	System.out.println("Elapsed time for binarySearchIterative: " + elapsed + " misiseconds");
	System.out.println();
	
	start = System.currentTimeMillis();
	boolean numTarget = binarySearchRecursive (numArray, 3, numArray[0], numArray.length-1);
	elapsed = System.currentTimeMillis()-start;
	System.out.println("Elapsed time for binarySearchRecursive: " + elapsed + " misiseconds");
	System.out.println();
	
	
	
	//test cases
	/* binarySearchRecursive (numArray, 18, numArray[0], numArray.length-1); 	//not in the array
	myTarget = linearSearch (numArray, 12); */
	}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LINEAR SEARCH ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	public static int linearSearch (int[] array, int target){
		int i;
		for (i = 0; i < array.length; i++){
			if (target == array[i]){
				System.out.println("Linear: the seached item " + target + " has an index: " + i);
				return i;
			}
		}
		System.out.println("The searched number is not in the array (linear)");
		return -1;
	}


   
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ BINARY SEARCH ITERATIVE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	public static int binarySearchIterative (int[] array, int target){
		int left = 0;
		int right = array.length - 1;
		System.out.println("Left: " + left);
		System.out.println("Right: " + right);
		System.out.println("target: " + target);
		System.out.println();
		while (left <= right){
			int mid = (left + right)/2;
			System.out.println("mid: " + mid);
			System.out.println("Middle element: " + array[mid]);
			if (target == array[mid]){	//just right, base case
				System.out.println("Iterative binary: the seached item " + target + " has an index: " + mid);
				return mid;
			}else if (target > array[mid]){	//too low
				left = mid +1;
				System.out.println("new left: " + left);
			}else {						//(target < array[mid]), too high
			right = mid - 1;
			}
		}	//end of loop
		System.out.println("The searched number is not in the array (binary iterative");
		return -1;
		
	} //end of method
	/*-----------------------------------------------*/



/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BINARY SEARCH RECURSIVE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	public static boolean binarySearchRecursive (int[] array, int target, int left, int right){
		if (left > right){
			System.out.println("The searched number is not in the array (binary recursive)");
			return false;
		}
		int mid = (left + right) / 2;
		if (array[mid] == target){	//base case
			System.out.println("Recursive binary: the searched item " + target + " has an index: " + mid);
			return true;
		}else if (target < array[mid]){
			return binarySearchRecursive(array, target, left, mid - 1);
		} else{
			return binarySearchRecursive(array, target, mid + 1, right);
		}
	}

	/*------------------------------*/
	} //end of class
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ELAPSED TIME ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/* start = System.currentTimeMillis();
	//method call
	elapsed = System.currentTimeMillis()-start;
	System.out.println("Elapsed time: " + elapsed + " misiseconds");
	System.out.println();
 */
