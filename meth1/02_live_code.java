//LIVE CODING, BINARY SEARCH
//Students are expected to have a conceptual understanding of binary search algorithm and have programmed binary search iterative before this lesson activity

import java.io.*;
import java.util.*;

public class BinarySearchLive{

	//this line is given
	public static int binarySearchRecursive (int[] array, int target, int lowerBound, int upperBound){
		
		//students are being asked to identify a necesary variable, meaningful name for it and initial value
		int middleNum = (lowerBound + upperBound) / 2;
		//students will come up with conditions 
		if (array[middleNum] == target){		//just right (Base Case)
			System.out.println("The searched element " + array[middleNum] + " has an index " + middleNum);
			return middleNum;
		}
		//students were previously asked to identify repeating steps applied on each new part (half) of the array
		//students are asked to identify the changes of the lower and upper bounds to pass as parameters in "too high" and "two low" cases
		if (target < array[middleNum]){		//too high
			return binarySearchRecursive(array, target, lowerBound, middleNum - 1);
		}
		if (target > array[middleNum]){ 		//too low
			return binarySearchRecursive(array, target, middleNum + 1, upperBound);
		}
		System.out.println("The searched element " + target + " is not in the array");
		return -1;
	}
	
	public static void main(String[] args) {
		//students will come up with integers for the array (with the emphasize that an array must to be sorted) and a target number
		//cases to be tested: number is in the array, number is not in the array
		int [] numArray = {2,5,7,9,12, 17, 20};
		int binResult = binarySearchRecursive(numArray, 9, 0, numArray.length);
	}
}
	