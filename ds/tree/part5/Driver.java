import java.io.*;
import java.util.*;


public class Driver {
	public static void main(String[] args) {
		BSTree t = new BSTree();

		t.insert(10);		//root
		t.insert(20);		//node wirh one child (25)
		t.insert(5);		//node with two children (and grandchildren)
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(25);		//leaf
		t.insert(1);
		t.insert(2);
		t.insert(6);

		//t.preorderTraverse();
		//t.postorderTraverse();
		t.inorderTraverse();
		
	/*~~~~~~~~~~~~~~~~ TEST CASES FOR DELETE() ~~~~~~~~~~~~~~~*/	
		
		t.delete(25); 		//test, leaf - works
		//t.delete(20);		//test, node with one child, works
		//t.delete(5);		//test, two children (and grandchildren), works!!!
		//t.delete(100);		//test, not in a tree, also works!
		
		
		t.inorderTraverse();
		
	}
}
