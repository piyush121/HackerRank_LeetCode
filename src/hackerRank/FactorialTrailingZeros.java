/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class FactorialTrailingZeros {
	public int trailingZeroes(int n) { // Don't multiply with 5 or you will overflow Integer.
		int answer = 0;
		while (n > 0) {
			answer += n / 5;
			n /= 5;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
