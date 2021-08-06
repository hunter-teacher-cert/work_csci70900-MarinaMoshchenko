import java.io.*;
import java.util.*;

public class Binary1{

    public static void main(String[] args) {
	int[] numArray = {1,2,3,4,5,6,7,8,9,1,0,11,12,13,14,15};
	
	
	int myTarget = linearSearch (numArray, 3);
	myTarget = binarySearchIterative(numArray, 3);
	
	//test cases
		
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
		System.out.println("The searched number is not in the array (binary iterative)");
		return -1;
		
	} //end of method
	/*-----------------------------------------------*/




	} //end of class
	