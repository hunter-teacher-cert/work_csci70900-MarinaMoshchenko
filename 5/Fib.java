import java.util.Arrays;
// heading

//TEAMWORK: Chris, Lyuba, Marina

public class Fib {
	static int[] f=new int[100];
  //your implementation of fib(n) here
	public static int fib (int n){
		int fibNum;
		if (n==0 || n==1){
			return n;
		}
		fibNum=fib(n-1)+fib(n-2);
		return fibNum;
	}
	
	public static void fibArrayAssignment(){
		for (int i=0; i<f.length; i++){
			f[i]=-1;
		}
	}
	
	
	public static int fibArray (int n){
		int fibNum;
		if (f[n]>-1){
			return f[n];
		}
		else{
			if (n==0 || n==1){	//base case
			f[n]=n;
			return n;
		}
		f[n]=fibArray(n-1)+fibArray(n-2);
		return f[n];
		}
	}		
	
	
	

  public static void main( String[] args ) {
	  fibArrayAssignment();
	  System.out.println(fibArray(20));
	  System.out.println(Arrays.toString(f));

	
	

	
	
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    System.out.println( fib(0) ); // -> 0
    System.out.println( fib(1) ); // -> 1
    System.out.println( fib(2) ); // -> 1
    System.out.println( fib(3) ); // -> 2
    System.out.println( fib(4) ); // -> 3
    System.out.println( fib(5) ); // -> 5

    //now go big:
    System.out.println( fib(10) ); // -> 55
    System.out.println( fib(20) ); // -> 6765
    System.out.println( fib(40) ); // -> 102334155

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()


}//end class Fib