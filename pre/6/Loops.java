import java.io.*;
import java.util.*;

public class Loops{
	
		//Excercise 3, method takes a double x and an integer n 
		//and returns x to the power of n
	public static double power(double x, int n){
		double pow=x;
		for (int i=2; i<=n; i++){
			pow=pow*x;}	
		System.out.println("The power is :" + pow);
		return pow;
		}
	
		

		//method computes the factorial function, 
		//an iterative version of factorial.
	public static int factorial(int n){
		int fact=1;
		for (int i=1; i<=n; i++){
			fact = fact*i;
		}
		System.out.println("The factorial is :" + fact);
		return fact;
	}

			//method calculates e^x by using the 
			//infinite series expansion,
			//takes x and n as parameters and estimates e^x 
			//by adding the first n terms of this series
	public static int myexp(int x, int n){ //i-th term of e^x is x^i/i!
		int iTerm=0; 
		int estimate=1;
		int fact;
		
		for (int i=1; i<=n; i++){
			iTerm=(int)power(x,i)/factorial(i);
			estimate = estimate + iTerm;
			System.out.println(estimate);
		}
		return estimate;
	}
		public static void main(String[] args){
		
		power(2,5);
		factorial(5);
		myexp(3,6);
		}
	}
	
		