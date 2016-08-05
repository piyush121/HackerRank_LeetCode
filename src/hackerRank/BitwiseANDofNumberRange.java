/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 *
 */
public class BitwiseANDofNumberRange {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == n)
			return m;
		int left = 1;
		while (m != n) { // every odd and even number will differ by last digit.
			m >>= 1;
			n >>= 1;
			left <<= 1;
		}
		return left * m; // 11 * 10 = 110. So to get the missing 0s we need to
							// do this.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
