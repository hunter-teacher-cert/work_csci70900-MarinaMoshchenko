import java.io.*;
import java.util.*;

public class Nim{			//team work: Daiana, Chris, Marina
	
	public static void main(String[] args){
		int bag = 12;
		int turn = 0;
		
		//
		boolean gameOn = false;
		Scanner game = new Scanner(System.in);
			if (gameOn == false){
				System.out.println("Enter 0 to start the game");
				bag=12;
				turn=0;
			}	
	}
	
	
		int begin = game.nextInt();
								if (begin==0){
			gameOn=true;
		}
		if (gameOn == true)
			while (bag>0){
				if (turn%2 ==0){
					System.out.println("Turn: Player");
					playerRound(bag);
					System.out.println("Current Stones: "+bag);
					turn++;
				} else{
					System.out.println("Turn: AI");
					aiRound(bag);
					System.out.println("Current Stones: " +bag);
					turn++
				}
}
			if (bag == 0){
				if (turn % 2 == 0){
					System.out.println("The AI won. Try again!");
					gameOn=false;
				}else{
					System.out.println("You are the winner!");
					gameOn=false;
				}
			}
	}

}	
		public static int playerRound(int pBag){
			Scanner in = new Scanner(System.in);
			if (pBag>3){
				System.out.println("Pull 1, 2, or 3 stones");
				int youPull = in.nextInt();
				if (youPull < 0 || youPull > 3){
					System.out.println(Hey, no cheating! Only pull 1, 2 or 3 stones!");
					youPull = in.nexInt();
				}else{
					System.out.println("you pulled " + youPull + " stones."
					pbag-=youPull;
				}
			}else if (pbag>2){
				System.out.println("pull 1 or 2 stones. "
				int youPull = in.nextInt();
				if (youPull<0 || youPull>2){
					System.out.println("Hey, no cheating! Only pull 1 or 2 stones");
					youPull = in.nextInt();
				}else{
					System.out.println("you pulled " + youPull + " stones.");
					pbag-=youPull;
				}
			}else if (pbag == 1){
				System.out.println("Pull the last stone! ");
				int youPull = in.nextInt();
				if (youPull<0 || youPull>2){
					System.out.println("Hey, no cheating! Pull only 1 stone ");
					youPull = in.nextInt();
				}else{
					System.out.println("You pulled " + youPull + " stones.");
					pbag-=youPull;
				}
			}return pbag;
		}