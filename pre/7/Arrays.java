import java.io.*;
import java.util.*;


public class Arrays{
	
	public static void main(String[] args){
		double a[]={1,2,3,4,5};
		int b[]={2,5,8,3,6,9,1};
		int exp=3; 
		sqrArray(a);
		powArray(a, exp);
		//histogram();
		int maxIndex=indexOfMax(b); 
		int c[]={1,2,3,4,5,6,7,8,9,1,10,11,12,13,14,15,16,17,18,19,20};
		sieve(c);
	}
	
	
	
	
	/* ----------------------------------------------------SquareArray-------------------------------------------------------------------------- */

		//Square each element of an array
	public static void sqrArray(double[] a){	
		//double a[]={1,2,3,4,5};		//How to make output as integers? Now it is double.
		System.out.println("Array of squared elements: ");
		for (int i=0; i<a.length; i++){
			a[i]=Math.pow(a[i],2.0); //if int[] a -> error "incompatible types: possible lossy conversion from double to int"
			System.out.println( a[i]);
		}
	}  
	
	/* ----------------------------------------------------PowerArray-------------------------------------------------------------------------- */
	
		///Each array element is raised to a given power
	public static void powArray(double[] a, int exp){ 	
			System.out.println("Array of elements raised to a given power: ");
			for (int i=0; i<a.length; i++){
			a[i]=Math.pow(a[i],exp); //if int[] a -> error "incompatible types: possible lossy conversion from double to int"
			System.out.println(a[i]);
		}
	}

	
	/* -----------------------------------------------------Histogram------------------------------------------------------------------ */
	
	 
		//takes an int array of scores from 0 to (but not including) 100, and returns a histogram of 100 counters
	public static void histogram(int[] scores, int[] counts){
		int[] counts = new int[100];
		int[] scores=randomArray(100); //Histogram, new array of 100 elements
		for (int i=0; i<counts.length; i++){
			counts[i]=inRange(scores, i, i+1);
			System.out.println(counts[i]);	//returns numbers 0-3 (???)
		}
	}
	
	
	public static int inRange(int[] a, int low, int high){
		int count=0;
		for (int i=0; i<a.length; i++){
			if (a[i]>=low && a[i]<high){
				count++;
			}
		}
		return count;
	}
	
	public static int[] randomArray(int size){
		Random random = new Random();
		int[] a=new int[size];
		for (int i=0; i<a.length; i++){
			a[i]=random.nextInt(100);
			System.out.println(a[i]);
		}
		return a;
	}
	
	/* ------------------------------------------------------IndexOfMax----------------------------------------------------------- */
	
	 	//takes an array of integers and returns the index of the largest element
	public static int indexOfMax(int[] b){	
		int max=0; int index=0;
		for (int i=0; i<b.length; i++){
			if (max<b[i]){
				max=b[i];
			}
			index=i;
		 	}
		System.out.println("Max is: " + max);
		System.out.println("Index of max is: " + index);
		return index;
	}  
	
	/* ---------------------------------------------------Sieve of Eratosthenes----------------------------------------------------------- */
	
		//takes an integer parameter, n, and returns a boolean array that indicates, for each number from 0 to n - 1, whether the number is prime.
	public static void sieve (int[] c){
		boolean isPrime;
		for (int i=0; i<c.length; i++){
			if ((c[i]%2==0 || (c[i]%3==0 || c[i]%5==0 || c[i]%7==0)	&& c[i]>7)){
				isPrime=false;
			}
			else {
				isPrime=true;
			}
			System.out.println("The number " + c[i] + " is prime: " + isPrime);
		
		}
	}
	}
	
		
	
	
	
	
	


	
	