import java.io.*;
import java.util.*;
//TEAMWORK: Benson, Michelle P, Marina


public class Mode{
  private ArrayList<Integer> inputData; //instant variable for array ArrayList
  private ArrayList<Integer> inputFreq; //array list to count the frequency of each item in it
  private Random r; //random number
    
  public Mode(){  //constructor
    r = new Random(); //new random number
    inputData = new ArrayList<Integer>(); //generates new Array list, empty
    
    for (int i=0; i < 20; i++){ //array list of size of 20 items
        inputData.add(r.nextInt(20)); //list is populated with random numbers from 0-19
    }//end for
  }//end Mode()
    
  public Mode(int size){  //value (parametized) constructor 
      r = new Random(); //new random number
      inputData = new ArrayList<Integer>(); //generates an array list of a specific size
      
      for (int i=0; i < size; i++){ // array list size = user input
          inputData.add(r.nextInt(50));  //populate an array list with random numbers 0-49     
      }//end for
  }//end Mode(int size)

    /**
     * Warmup 1
     Find and return the smallest value in  InputData.
    */

  public int findSmallestValue(){
    int min = inputData.get(0);
    for (int i=1; i < inputData.size(); i++){
      if (inputData.get(i) < min){
        min = inputData.get(i);
      }//end if
    }//end for

	  return min; //return minimum value in dataset
	
  }//end findSmallestValue()
	
   public int findLargestValue(){
    int max = inputFreq.get(0);
    for (int i=1; i < inputFreq.size(); i++){
      if (inputFreq.get(i) > max){
        max = inputFreq.get(i);
      }//end if
    }//end for

	  return max; //return minimum value in dataset
	
  }//end findLargestValue()

  /**
     Warmup 2
     Returns the frequency of value in inputData, that is, how often value appears
  */
  public int frequency(int value){
    int counterVal=0;
    for (int i=1; i < inputData.size(); i++){
      if (inputData.get(i) == value){
        counterVal++;
      }//end if
    }//end for
    return counterVal;
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
  public int calcMode(){
    inputFreq = new ArrayList<Integer>(); //empty array list 
    for (int i = 0; i < inputFreq.size(); i++){
      inputFreq.set(i) = inputData.frequency(inputData.get(i));
    }//end for
    int index = findLargestValue();
      
    
    return inputFreq;
  }//end calcMode

  public String toString(){
	  return ""+inputData;
  }//end toString

}//end class