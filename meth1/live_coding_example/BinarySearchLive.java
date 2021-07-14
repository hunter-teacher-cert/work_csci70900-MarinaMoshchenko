import java.io.*;
import java.util.*;

public class BinarySearchLive{


	public static int binarySearchRecursive (int[] array, int target, int lowerBound, int upperBound){
		
		int middleNum = (lowerBound + upperBound) / 2;
		if (array[middleNum] == target){		//just right (Base Case)
			System.out.println("The searched element " + array[middleNum] + " has an index " + middleNum);
			return middleNum;
		}
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
		int [] numArray = {2,5,7,9,12, 17, 20};
		int binResult = binarySearchRecursive(numArray, 9, 0, numArray.length);
	}
}
	