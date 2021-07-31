import java.io.*;
import java.util.*;


public class Driver {
	public static void main(String[] args) {
		BSTree t = new BSTree();

		t.seed();	//creates a tree
		
		int value;

		value = t.search(10);	//searches for 10 in the tree t
		System.out.println(value);	//prints the search result 

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(17);
			System.out.println(value);
		} catch (NullPointerException e) {
			System.out.println("17 not in tree");
		}
		
	}
}