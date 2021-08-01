import java.io.*;
import java.util.*;

/*
Setup:
 1.Make a folder under your work repo named: ds
 2. Make another folder under that named sort1
 3. Copy this file and SortDemoDriver.java into the ds/sort1 folder

Lab:
Part 1:
  1. Analyze the two constructors - try to figure out how they work.
  2. Compile and run the program (SortDemoDriver.java and SortDemo.java) and confirm
   the behavior of the constructors.
Part 2:
  1. Read the description of findSmallestIndex and complete the method.
  2. Uncomment the lines in SortDemoDriver to test.
Part 3:
  1. Complete the sort method - read comments for description
  2. Uncomment the lines in sortDemoDriver to test.
*/

public class SortDemo{

    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data (an Array List of integers)
    private Random r; // a random integer is the other instance variable

    //this is the default constructor and will initialize an ArrayList of random integers between 0 and 19 of length 15
    public SortDemo(){
	data = new ArrayList<Integer>(); //{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} (an array list of zeroes)
	r = new Random();
	for (int i=0;i<15;i++){
	    data.add(r.nextInt(20));  //{array list of 15 elements is now full of random numbers between 0 and 19}
	}

    }

    //this is the value (parameterized) constructor and will initialize an ArrayList of random integers between 0 and 19 of length size
    public SortDemo(int size){
	data = new ArrayList<Integer>();
	r = new Random();
	for (int i=0;i<size;i++){
	    data.add(r.nextInt(20));
	}

    }

    public int get(int index){
      return this.data.get(index);
    }

    /*
      return the index of the ArrayList data from index start to the end
      Example, if the arraylist has:
      index: 0 1  2  3 4
             5 3 10  6 8
      if start was 2 (start at index 2, value 10) then it would return 3 which is the index of the value
      6 which is the index with the smallest value from start to end
    */
    public int findSmallestIndex(int start){
	int smallIndex = start;

	// start a variable at the one after start
	int next = start + 1;

	// loop from that variable to end and update smallIndex as needed
	for(int i = next; i < data.size(); i++){
    if (data.get(i) < data.get(smallIndex)){
      smallIndex = i;
    }
  }
	return smallIndex;

    }



    public void sort(){
      int start, smallestIndex, temp;
    	for (start = 0; start < data.size() - 1; start++){
    	    // find the smallest index from i to end
          smallestIndex = findSmallestIndex(start);
    	    // swap the item at that index and i
          temp = this.data.get(start); //equivalent of temp = data[start]
          this.data.set(start, this.data.get(smallestIndex)); //equivalent of data[start] = data[smallestIndex]
          this.data.set(smallestIndex, temp);//equivalent of data[smallestIndex] = temp
  	     }
    }

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LINEAR SEARCH~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

        public int linearSearch(int value){		//linear search
		for (int i=0; i < data.size(); i++){
			if (value == data.get(i)){
				System.out.println("Linear search result: the searched item " + value + " has an index: " + i);
				return i;
			}
		}
		System.out.println("Linear search: the searched item " + value + " is not in the array");
		return -1; // item is not in the array		
	
	// loop through the ArrayList data
	// and if the value you're searchign for is in the ArrayList, return it.
	// return -1 if it isn't there.


	
    }

	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BINARY SEARCH ITERATIVE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	
	
    public int binarySearch(int value){			//ITERATIVE
	//boolean (upperIndex < lowerIndex)=false;
	int lowerIndex = 0;
	int upperIndex = data.size();
		
		
	//if (lowerIndex > upperIndex){
		//
		//return -1;

	/* if upper crosses lower it's not there and the loop should exit the loop
	   and if the item is at middle you should exit the loop

           you have to replace the "replacethiswithrealexpression" boolean
           with a correct expression based on lowerIndex and upperIndex
	*/
		while (lowerIndex <= upperIndex){
			int middleIndex = ((lowerIndex + upperIndex)/2);
				if (value == data.get(middleIndex)){		//base case
				System.out.println("Binary iterative search: the searched item " + value + " has an index: " + middleIndex);
				return middleIndex;
			}else if (value > data.get(middleIndex)){		//too low
				lowerIndex = middleIndex + 1;
			}else {						//(value < data.get(middleIndex), too high
				upperIndex = middleIndex - 1;
			}
		}
		System.out.println("The searched item " + value + " is not in the array (binary iterative)");
		return -1; 
	}
		
/*--------------------------------------------*/
    
	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~BINARY SEARCH RECURSIVE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/	

	public int binarySearch(int value, int lowerIndex, int upperIndex){
		
		int middleIndex = (lowerIndex + upperIndex)/2;
		if (lowerIndex > upperIndex){
			System.out.println("Binary recursive search: The searched item " + value + " is not in the array");
			return -1;
		}
		if (data.get(middleIndex) == value){		//base case, just right
			System.out.println("Binary recursive search: the searched item " + value + " has an index: " + middleIndex);
			return middleIndex;
		}
		if (value < data.get(middleIndex)){			//too high
			return binarySearch(value, lowerIndex, middleIndex-1);
		}
		if (value > data.get(middleIndex)){			//too low
			return binarySearch(value, middleIndex+1, upperIndex);
		}
		return -1;
		}


	public String toString(){
	return ""+data;
    }

	
}
