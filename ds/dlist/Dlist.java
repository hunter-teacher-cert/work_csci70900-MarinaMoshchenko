import java.io.*;
import java.util.*;


public class Dlist{
  private Node front; // the front of the list
  private Node back; // the back of the list
  private int size; // instance variable for length of the list, updated in methods when length is affected


	  // constructor to intialize instance variables
	  public Dlist(){
		front = null; // initialize front to null
		back = null; //initialize back to null
	  }


/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ADD FRONT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ WORKS ~~~*/	

	  public void addFront(String data){ 	//adds a node at the front of the list
			Node newNode = new Node(data);
			newNode.setNext(front);
			
			if (front != null){
				front.setPrev(newNode);
			}
				
			front = newNode;
		size++;
		if (size == 1) {		//not to be left as null (back)
				back = front;
		}
	  } //end addFront
	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ADD BACK~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS!!!~~~~~	*/
	  
	   public void addBack(String data){ 	//adds a node from the back of the list
			Node newNode = new Node(data);
			newNode.setPrev(back);
			if (back != null){
				back.setNext(newNode);
			}
				
			back = newNode;
		size++;
		if (size == 1) {
				front = back;
		}
	  } //end addBack
	  
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ IS EMPTY? ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS~*/

 public boolean isEmpty(){
    return (front == null && back == null);	// both or one is enough???
  }

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ INSERT (INDEX, VALUE) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS*/

 public void insert(int index, String value){
    Node newNode = new Node(value);
    Node currentNode; // initialize new node
    int numItems = 0; // initialize counter variable
    currentNode = front; // set currentNode to front (1st node)
    while(currentNode != null) { // iterates through nodes in the list
      if (numItems == index - 1){ // if/when counter variable reaches node before the requested index...
        newNode.setNext(currentNode.getNext()); // ... point new Node at node one after current Node (one before specified index argument)
		currentNode.setNext(newNode); // ... point current node to new node, previous is repointed by setNext method
		newNode.setPrev(currentNode);
		currentNode.getNext().setPrev(newNode);
		break; // exit out of method
      }//end if statement
      numItems++;  // increments each time there is a new node
      currentNode = currentNode.getNext();
    } // end while
    size++; // increment size instance variable
  } // end method


/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVE (INDEX) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS~*/

public void remove(int index){
    int currentIndex = 0;
    Node currentNode = front;
    if (index > this.size){
      System.out.println("Index " + index + " is out of bounds " + this.size);
    } else {
      while (currentNode != null){

        if (currentIndex  == index -1){

          currentNode.setNext(currentNode.getNext().getNext());
		  currentNode.getNext().getNext().setPrev(currentNode);
          break;
        } //end if
        currentNode = currentNode.getNext();
        currentIndex++;
      } //end while
      size--; // decrement size instance variable
	}//end else

  }//end remove



/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GET SIZE ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS~*/
 public int getSize(){		//as an alternative to length(), initialized in the beginning, updated in each method when length is affected
    return size;
 }

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LENGTH FORWARD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

 public int length(){
    Node currentNode = front; // initialize new node
    int numItems = 0; // initialize counter variable
    while(currentNode != null) { // iterates through nodes in the list
      numItems++;  // increments each time there is a new node
      currentNode = currentNode.getNext(); // move to the next node in the list
    }
    return numItems; // return number of items in list;
	
	
  }
  
  /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LENGTH BACKWARD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  
  
   public int lengthBackward(){		//calculates length starting from the last node
    Node currentNode = back; // initialize new node
    int numItems = 0; // initialize counter variable
    while(currentNode != null) { // iterates through nodes in the list
      numItems++;  // increments each time there is a new node
      currentNode = currentNode.getPrev(); // move to the prev node in the list
    }
    return numItems; // return number of items in list;
	
	
  }

	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRINT FORWARD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS~*/	
	
	   public String toString(){		//printing list from the front (first node first)
			Node currentNode;
			currentNode = front;
			String result = "";
			while (currentNode != back){
			  result = result + currentNode + " <-> ";
			  currentNode = currentNode.getNext();
			}
			result = result + back + " -> null";
			return result;
	   } //end toString
	   
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRINT BACKWARD ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ WORKS!!! ~~*/
	
	   public String toStringBackward(){		//printing list from the back (last node first)
			Node currentNode;
			currentNode = back;
			System.out.println("Orig back: " + back.getData());
			String result = "null <- ";
			while (currentNode != front){
			  result = result  + currentNode + " <-> ";
			  currentNode = currentNode.getPrev();
			}
			result = result + front;
			return result;
	   } //end toStringBackward
	   
	   
  } //end class
  