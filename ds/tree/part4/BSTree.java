import java.io.*;			//PART 4, traverse
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
		root = null;
		}


    
    
    private void preorderTraverse(TreeNode current){		//method traversing elements of the tree and printing it's elements 
		if (current == null)								//if current node is pointing to null, meaning the tree is empty
			return;

		//process the current node
		System.out.print(current.getData()+", ");	//prints elements in the following order: data -> left -> right 
													//number - smaller number - larger number. Not sorted
		// recursively print out the left subtree
		preorderTraverse(current.getLeft());

		// recursively print out the right subtree
		preorderTraverse(current.getRight());
    }

    public void preorderTraverse(){		//default constructor, if no paramener passed, the current node will be root
		preorderTraverse(root);			//invokes value (parameterized) constructor
		System.out.println();			//go to the next line after all tree nodes' values are printed
		}

    private void postorderTraverse(TreeNode current){	//method pirnts elements in the following order: left -> right -> data
		if (current == null)							//smaller number - larger number - number. Not sorted
			return;

		// recursively print out the left subtree
		postorderTraverse(current.getLeft());		

		// recursively print out the right subtree
		postorderTraverse(current.getRight());

		//process the current node
		System.out.print(current.getData()+", ");



		}

    public void postorderTraverse(){		
		postorderTraverse(root);			
		System.out.println();
		}

    private void inorderTraverse(TreeNode current){		//method pirnts elements in the following order: left -> data -> right
		if (current == null)							//smaller number - number - larger number. SORTED
			return;


		// recursively print out the left subtree
		inorderTraverse(current.getLeft());

		//process the current node
		System.out.print(current.getData()+", ");

		// recursively print out the right subtree
		inorderTraverse(current.getRight());
		}

    public void inorderTraverse(){
		inorderTraverse(root);
		System.out.println();
		}


	public void insert(int key){

		TreeNode newNode = new TreeNode(key);

		// if the tree is empty
		// manually insert the new node as the root
		if (root==null){
			root = newNode;
			return;
		}
	
		TreeNode front = root;	//front is set to the root node
		TreeNode trailer = root;	//trailer is set to the root node
		
		while (front != null){		//while front is not pointing to null, meaning that the tree is not empty or it's not the end of the tree
			int frontValue = front.getData();	//frontValue is set to the value of the first node of the tree
			if (frontValue == key){		//if frontValue is the same value as the value of the node to be inserted
			// if we're here, it means the key is
			// already in the tree so we can
			// update this node in some way
			// and then return
			return;
			} else if (frontValue < key){	//if frontValue is less that the value of the node to be inserted, 
			trailer = front;				//trailer is set to front to keep track of the previous node
			front = front.getRight();		//front is now set to right node with the larger value 
			} else {	//otherwise, meaning that the frontValue > key
			trailer = front;			//trailer is set to front to keep track of the previous node
			front = front.getLeft();	//front is now set to left node with the smaller value
			}
		}
		if (key > trailer.getData()){		//if value of the node to be inserted is greater than the value of the previous node
			// insert on the right
			trailer.setRight(newNode);		//the right pointer of the previous node will now be set to the new node (node is inserted to the right)
		} else {							//if key >=trailer
			// insert on left
			trailer.setLeft(newNode);		//the left pointer of the previous node will now be set to the new node (node is inserted to the left)

		}
		
	

    }


    public int search(int key){
		TreeNode current = root;

		while (current != null){
			int currentValue = current.getData();
			if (currentValue == key){
			return currentValue;
			} else if (currentValue < key){
			current = current.getRight();
			} else {
			current = current.getLeft();
			}
		}
		throw new NullPointerException();

		}
		
    public void seed(){
		TreeNode t;

		t = new TreeNode(10);
		root = t;
		t = new TreeNode(5);
		root.setLeft(t);
		t = new TreeNode(20);
		root.setRight(t);

		root.getLeft().setRight( new TreeNode(8));

		t = new TreeNode(15);
		root.getRight().setLeft(t);

		t = new TreeNode(22);
		root.getRight().setRight(t);
		
		}
		
    
}