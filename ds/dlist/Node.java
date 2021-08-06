import java.io.*;
import java.util.*;

public class Node {		//for doubly linked list

    private String data;
    private Node next;		//pointer to the next node
	private Node prev;		//pointer to the previous node

    public Node() {
		data = "";
		next = null;
		prev = null;
    }//default constructor

    public Node(String value) {

	data = value;
	next = null;
	prev = null;
    }//constructor(value)

    public Node(String value, Node next, Node prev) {
		data = value;
		this.next = next;
		this.prev = prev;
    }//constructor(value, next, prev)

    public void setData(String value) {
		data = value;
		}//setData

		public void setNext(Node n) {
		next = n;
		//if (n != null) {
		//n.setPrev(this); 	//points next's node prev to this node
		//System.out.println("n.setPrev(this): " + n.getPrev(this));
		//}
	
	}//setNext
	
	public void setPrev(Node n) {
		prev = n;
		/*if (n != null) {
		n.setNext(this); 	//points prev's node next to this node
		}
		*/
	}//setPrev

    public String getData() {
		return data;
    }//end getValue

    public Node getNext() {
		return next;
    }//getNext
	
	public Node getPrev() {
		return prev;
    }//getPrev

    public String toString() {
		return data;
    }//toString

}//class Node for doubly linked list