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
			
			//System.out.println("front orig: " + front);
			newNode.setNext(front);
			
			if (front != null){
				front.setPrev(newNode);
				//System.out.println("front.getPrev: " + front.getPrev());
			}
				
			front = newNode;
			
			//System.out.println("new front: " + front.getData());
			//System.out.println("front.getNext: " + front.getNext());
		size++;
		if (size == 1) {		//
				back = front;
		}
	  } //end addFront
	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ADD BACK~~~~~~~~~~~~~~~~~~~~~~~~~~~~WORKS!!!~~~~~	*/
	  
	   public void addBack(String data){ 	//adds a node at the front of the list
			Node newNode = new Node(data);
			//back = front;
			//System.out.println("back orig: " + back);
			newNode.setPrev(back);
			//System.out.println("newNode.getPrev: " + newNode.getPrev());	//expect 
			if (back != null){
				back.setNext(newNode);
				System.out.println("orig back.getNext (cond): " + back.getNext());
			}
				
			back = newNode;
			//System.out.println("new back: " + back.getData());
			//System.out.println("new back.getNext: " + back.getNext());
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
        //System.out.println("New Node Next: " + newNode.getNext());
		currentNode.setNext(newNode); // ... point current node to new node, previous is repointed by setNext method
        //System.out.println("Current node Next: " + currentNode.getNext());
		newNode.setPrev(currentNode);
		//System.out.println("New node Prev: " + newNode.getPrev());
		currentNode.getNext().setPrev(newNode);
		//System.out.println("After current node Prev: " + currentNode.getNext().getPrev());
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
		  //System.out.println("Current node Next: " + currentNode.getNext());
		  currentNode.getNext().getNext().setPrev(currentNode);
		  //System.out.println("After next node Prev: " + currentNode.getNext().getPrev());
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
    return numItems; // return n umber of items in list;
	
	
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
  