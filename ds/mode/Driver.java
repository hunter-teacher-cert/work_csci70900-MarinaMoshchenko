import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args) {
	long start,elapsed;
	int mode;
	Mode m = new Mode(15);
	System.out.println(m);
	 
	System.out.println("~~~~~~~~~~~~~~~~ Calculate Mode ~~~~~~~~~~~~~~~~~~");
	start = System.currentTimeMillis();
	mode = m.calcMode();
	System.out.println("Mode: " + mode);
	elapsed = System.currentTimeMillis()-start;
	System.out.println("Elapsed time: " + elapsed + " misiseconds");
	System.out.println();
	System.out.println("~~~~~~~~~~~~~~~~ Fast Mode (tallies) ~~~~~~~~~~~~~~");
	
	start = System.currentTimeMillis();
	mode = m.fastMode();
	System.out.println("Mode: " + mode);
	elapsed = System.currentTimeMillis()-start;
	System.out.println("Elapsed time: " + elapsed + " misiseconds");
	
    }
    
}