import java.io.*;			//PART 2, search
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
		root = null;
		}

    public int search(int key){		//search element key
		TreeNode current = root;	//search starts from the root

		while (current != null){	//when current is null, it is either empty tree or the end of the tree is reached
			int currentValue = current.getData(); //gets value of the node
			if (currentValue == key){		//compares with the searched element
			return currentValue;			//searched key is found
			} else if (currentValue < key){	//the key is greater, meaning the right side of the node, we need to move the current to the right one below
				current = current.getRight();
			} else {	//not equal to the key and not less than a key, KEY IS LESS then currentValue, move the node to the left one below
				current = current.getLeft();
			}
			
		}
		throw new NullPointerException(); //can not return null, because we need to return int
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