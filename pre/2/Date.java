import java.io.*;
import java.util.*;

public class Date{
	public static void main(String[] args){
		String amerFormat;
		String europFormat;
		String day="Monday";
		int date=19;
		String month="April";
		int year=2021;
		amerFormat=day + ", " + month + " " + date + ", " + year;
		europFormat=day + " " + date + " " + month + " " + year;
		System.out.println("American Format:");
		System.out.println(amerFormat);
		System.out.println("European Format:");
		System.out.println(europFormat);
	}
}