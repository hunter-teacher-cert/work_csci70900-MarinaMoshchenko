import java.io.*;
import java.util.*;
//TEAMWORK: Benson, Michelle P, Marina


public class Mode{
  private ArrayList<Integer> inputData; //instant variable for array ArrayList
  //private ArrayList<Integer> inputFreq; //array list to count the frequency of each item in it
  private Random r; //random number
  private int maxVal = 50;
    
  public Mode(){  //constructor
    r = new Random(); //new random number
    inputData = new ArrayList<Integer>(); //generates new Array list, empty
    
    for (int i=0; i < 20; i++){ //array list of size of 20 items
        inputData.add(r.nextInt(maxVal)); //list is populated with random numbers from 0 to value of maxVal
    }//end for
  }//end Mode()
    
  public Mode(int size){  //value (parametized) constructor 
      r = new Random(); //new random number
      inputData = new ArrayList<Integer>(); //generates an array list of a specific size
      
      for (int i=0; i < size; i++){ // array list size = user input
          inputData.add(r.nextInt(maxVal));  //populate an array list with random numbers 0 to maxVal     
      }//end for
  }//end Mode(int size)

    /**
     * Warmup 1
     Find and return the smallest value in  InputData.
    */

  public int findSmallestValue(){
    int smallestValue = inputData.get(0);
    for (int i=1; i < inputData.size(); i++){
      if (inputData.get(i) < smallestValue){
        smallestValue = inputData.get(i);
      }//end if
    }//end for

	  return smallestValue; //returns minimum value in dataset
	
  }//end findSmallestValue()
	
    /**
     Warmup 2
     Returns the frequency of value in inputData, that is, how often value appears
  */
  public int frequency(int value){
    int count=0;
    for (int i=0; i < inputData.size(); i++){
      if (value == inputData.get(i)){
        count++;
      }//end if
    }//end for
    return count;
  }//end frequency
    


    /**
     * 
     This function should calculate and return the mode of inputData. 
     The mode is the value that appears most frequently so if inputData contained
     5,3,8,2,5,9,12,5,12,6,5, the mode would return 5 since 5 appears four times. 
     If there are multiple modes such as in the case with this data set: 5,5,2,9,9,6 you should return
     either of them (the 5 or the 9).
     Note: you will probably use the frequency function you wrote in
     this solution but not findSmallestValue. the findSmallestValue
     function will help you find a strategy for approaching finding the mode.
    */
   
  public int calcMode(){	//calculates mode - number, most appeared in the ArrayList
	    int modeSoFar = inputData.get(0);		//starts with the first element in the ArrayList, gets value of sub zero element and assigns it to modeSoFar
	    int countSoFar = frequency(modeSoFar);	//counter countSoFar counts how many times number modeSoFar appears in ArrayList
	    for (int i=0 ; i < inputData.size() ; i++){		//loops through all the elements of ArrayList
		int f = frequency(inputData.get(i));		//f is set to how many times i-th element is present in the ArrayList,
		if (f > countSoFar){						//if f is greater then value of the number of appearances of modeSoFar 
		    countSoFar = f;			//countSoFar is set to a larger value f
		    modeSoFar = inputData.get(i);		//modeSoFar is now set to the value of the next element in the ArrayList
		}
	    }
	    
	    return modeSoFar;
	}


   public int fastMode(){		//calculates mode using tallies
	int[] tallies = new int[maxVal];	//array talies has a size of maxVal
	int i;
	for (i = 0; i < maxVal; i++){		//populates the array tallies with 0
	    tallies[i]=0;
	}

	for (i = 0; i < inputData.size(); i++){		//loops through each element of an ArrayList
	    int v = inputData.get(i);			//gets value of element with index i
	    tallies[v] = tallies[v] + 1;		//increases tallies for i-th element by 1 with each occuurance of that element in ArrayList
	}


	int maxIndex = 0;		//index of the number appeared the maximum number of times, initialized to 0
	int maxCount = tallies[0];		//counter is set to the number of accurances of the first element (sub 0) 
	for (i=0;i<maxVal;i++){			//loops through all the elements of an ArrayList
	    if (tallies[i] > maxCount){		//if number of occurances of i-th element is greater then the valuse of maxCount,
		maxCount = tallies[i];		//maxCount is now set to a larger value - number of times i-th element appeasres in ArrayList
		maxIndex = i;			//index of the number appeared the maximum number of times is now set to i of that element.
	    }
	}
	return maxIndex;
	


    }

  public String toString(){
	  return ""+inputData;
  }//end toString

}//end class