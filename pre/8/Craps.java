import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;


public class Craps{
	
	public static void main(String[] args){
		round();
		}

	//"roll" which accepts an integer parameter and returns a random number between 1 and that number, inclusive
	public static int roll(int dice){
		Random random = new Random();
		dice = random.nextInt(6)+1;
		System.out.println(dice);
		return dice;
		}
	
	
	
	//"shoot" which accepts two parameters - a number of dice and the maximum value for those dice and returns the result of rolling those dice
	public static int shoot( int numOfDice, int max){
			int result = 0;
		for (int i = 1; i<=numOfDice; i++){
			int dice = roll(6);
			System.out.println("Dice " + i + " rolled: " + dice);
			result = result + dice;
		}
		System.out.println("The sum of " + numOfDice + " dice rolls: " + result);
		return result;
	}
		
	//"round" which accepts no parameters and it should return something to indicate if the shooter of the round wins or loses
	public static int round(){
		int result = shoot(2,6);
		if (result == 2 || result == 3 || result ==  12){
			System.out.println("Craps... You lost, sorry... Try again.");
			return 0;
		}
		if (result == 7 || result == 11){
			System.out.println("Congratulations! You are the winner!");
			return 1;
		}else{
			System.out.println("Point");
			shoot(2,6);
			round();
		}
		return -1;
	}
		
	
	
	
	
	
	/* 
	The shooter shoots (rolls) the dice.

If he rolls a 2,3, or 12,that’s Craps and he loses.
If he rolls a 7 or 11, that’s a Natural and he wins.
Otherwise:

the value he rolled is now called the Point
the shooter continues to shoot (roll) until he either rolls the Point again at which point he wins or he rolls a 7 at which point he loses.
*/
	}
	
	
	