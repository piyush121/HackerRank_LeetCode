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
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			return myPow(x * x, n / 2);
		}
		else if (n < 0) {
			n = -n;
			x = 1 / x;
		} 
		return x * myPow(x, n - 1);

	}

	public static void main(String[] ars) {
		System.out.println(myPow(8.88, 3));
	}

}
