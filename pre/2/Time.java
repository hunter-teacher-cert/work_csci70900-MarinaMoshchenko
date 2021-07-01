import java.io.*;
import java.util.*;

public class Time{
	public static void main(String[] args){
		int hour=22;
		int minute=40;
		int second=25;
		int numSecondsPast;
		numSecondsPast=hour*60*60+minute*60+second;
		System.out.println("Number of seconds since midnight: " + numSecondsPast);
		int totalNumSeconds=24*60*60;
		System.out.println("Number of seconds remaining of the day: " + (totalNumSeconds-numSecondsPast));
		double percDay=numSecondsPast*100/totalNumSeconds;
		System.out.println("Percent of the day passed: " + percDay);
		hour=23;
		minute=15;
		second=30;
		int numSecondsPastNew=hour*60*60+minute*60+second;
		int timeCollapse=numSecondsPastNew-numSecondsPast; 
		System.out.println("Time since the excerise started: " + timeCollapse);

	}
}