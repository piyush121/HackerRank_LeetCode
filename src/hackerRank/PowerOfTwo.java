/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;
		return 0 == (n & (n - 1 ));
		}
	
	public static void main(String[] args) {
		PowerOfTwo obj = new PowerOfTwo();
		System.out.println(obj.isPowerOfTwo(5));
	}
}
