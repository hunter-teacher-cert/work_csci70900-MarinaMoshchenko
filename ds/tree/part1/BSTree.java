import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;	//instant variable root of a TreeNode type (data and 2 pointers)

		public BSTree(){ //creates a node with the root referencing to null
		root = null;
		}

    public void seed(){	//create a child node t
		TreeNode t;

		t = new TreeNode(10);	//creates a node with value 10 and 2 pointers to null 
		root = t;				//t is set as a root
		t = new TreeNode(5);	//creates a new node with value 5 
		root.setLeft(t);		//sets root's left pointer to root
		t = new TreeNode(20);	//creates a new node with value 20 
		root.setRight(t);		//root's right pointer points to that node

		root.getLeft().setRight( new TreeNode(8)); 	//sets the root's right pointer 
								//to the same node as the root's left pointer 

		t = new TreeNode(15); 	//creates new node with value 15
		root.getRight().setLeft(t);	//sets root's left pointer 

		t = new TreeNode(22);	
		root.getRight().setRight(t);
		
		}
    
    
}