import java.io.*;
import java.util.*;


public class Methods{	
	
		//method takes two integers, n and m, and that returns 
		//true if n is divisible by m, and false otherwise.
	public static boolean isDivisible(int n, int m){
		return(n%m==0);
	}
	
		//method three integers as arguments and 
		//returns either true or false, depending on whether 
		//you can or cannot form a triangle
	public static boolean isTriangle(int a, int b, int c){
		if (a > b + c || b > a + c || c > a + b){
			System.out.println ("Triangle with sides " + a + ", " + b + ", " + c + " can not be formed");
			return false;
			}
		else {
			System.out.println ("Triangle with sides " + a + ", " + b + ", " + c + " can be formed");
			return true;
			}
	}
	
		//The Ackermann function
	public static int ack(int m, int n){
		int valueAck = 0;
		if (m==0){
			valueAck = (n+1);}
		if (m > 0 && n == 0) {
			valueAck = ack(m-1,1);}
		if (m > 0 && n > 0) {
			valueAck = ack(m-1, ack(m, n-1));
			}
			System.out.println("Value of Ackerman function is: " + valueAck);
			return valueAck;
	}
		
		
	public static void main (String[] args){
		boolean numDivisible;
		numDivisible=isDivisible(6,3);
		System.out.println("Is number divisible? "+ numDivisible);
		boolean formTriangle;
		formTriangle=isTriangle(1,4,6);
		int valueAck;
		valueAck = ack(2,1);
		
	
	}
	
}		