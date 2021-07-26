import java.io.*;
import java.util.*;

public class TreeNode{
    private int data;
    private TreeNode left,right; //object with data, left pointer and right pointer

    public TreeNode(){ //creates and object when the method is invoked
		this(0);	//data is 0
		left = null;	//both pointers refer to null
		right = null;
		}

    public TreeNode(int data){ //creates an object with specific data
		this.data = data;
		left = null;	//both pointers refer to null
		right = null;
		}

    public void setData(int data){		//sets the data only
		this.data = data;
		}

		public void setLeft(TreeNode left){	//sets left pointer only
		this.left = left;
		}

    public void setRight(TreeNode right){	//sets the right pointer only
		this.right = right;
		}

		public int getData(){		//gets the value of a specific node
		return data;
		}

    public TreeNode getLeft(){	//gets the left pointer
		return left;
		}

		public TreeNode getRight(){		//gets the right pointer
		return right;
		}
	}