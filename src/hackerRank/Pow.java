package hackerRank;

/*
 * Implement pow(x, n).
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class Pow {
	
	 public static double myPow(double x, int n) {
		 
		if( n % 2 == 0) {
			return myPow(x*x, n/2);
		}
		else
			return myPow(x*x, n - 1);
		
	    }
	 public static void main(String[] args) {
		System.out.println(myPow(3.89707, 2));
	}

}
