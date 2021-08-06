import java.io.*;		//Driver for Dlist
import java.util.*;

public class Driver{
    public static void main(String[] args) {


  Dlist myList = new Dlist();
 
		
		boolean empty = myList.isEmpty();
		System.out.println("List is empty: " + empty);
		
		myList.addFront("a");
		myList.addFront("b");
		myList.addFront("c");
		myList.addFront("d");
		myList.addFront("e");
	
		System.out.println("My list toString: " + myList.toString());
		System.out.println("Length forward: " + myList.length());
		System.out.println("My list toStringBackward: " + myList.toStringBackward());
		System.out.println("Length backward: " + myList.lengthBackward());
		empty = myList.isEmpty();
		System.out.println("List is empty: " + empty);
		
		myList.insert(2, "q");
		int size = myList.getSize();
		System.out.println("My list: " + myList);
		System.out.println("My list's size: " + myList.getSize());
		myList.remove(3);
		
		myList.addBack("x");
		myList.addBack("y");
		myList.addBack("z"); 
		System.out.println("List toString: " + myList.toString());
		System.out.println("My list: " + myList);
		
  }	//end main
} //end class
 
