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
			 while(n > 0) {
				 if(n != 1) {
					x *= x;
				 	n /= 2;
				 }
				 
				 if(n == 1) {
					 x *= num;
					 --n;
				 }
					 
				 }
			 return x;
		 }
		 else {
			 x = 1.0 / x;
			 num = x;
			 n = -n;
			 while(n > 0) {
				 if(n != 1) {
					x *= x;
				 	n /= 2;
				 }
				 
				 if(n == 1) {
					 x *= num;
					 --n;
				 }
			 }
				 return x;
		 }
	        
	    }
	 public static void main(String[] args) {
		System.out.println(myPow(3.89707, 2));
	}

}
