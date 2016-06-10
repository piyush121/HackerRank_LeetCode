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
		 double num = x;
		 if( n == 0)
			 return 1;
		 else if (n > 0) {
			 while(n > 1) {
				num *= x;
			 	--n;
			 }
			 return num;
		 }
		 else {
			 x = 1.0 / x;
			 n = -n;
			 while(n > 1) {
					num *= x;
				 	--n;
				 }
				 return num;
		 }
	        
	    }
	 public static void main(String[] args) {
		System.out.println(myPow(0.00001, 2147483647));
	}

}
