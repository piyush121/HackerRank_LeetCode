/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * 
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class Sqrt {
	public static int mySqrt(int x) {// Easy looking but tricky one !
		if (x == 0)
			return 0;
		int left = 1;
		int right = x;
		int mid = right - (right - left) / 2;
		while (right > left) { // Apply Binary search carefully !
			if (mid * mid == x)
				return mid;
			mid = right - (right - left) / 2;
			if (mid > x / mid)
				right = mid - 1;
			else
				left = mid;
		}
		return left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));

	}

}
