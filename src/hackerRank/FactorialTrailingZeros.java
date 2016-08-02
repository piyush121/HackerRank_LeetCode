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
	public int trailingZeroes(int n) { 
		int answer = 0;
		int i = 5;
		while (n / i != 0) {
			answer += n / i;
			if(i > Integer.MAX_VALUE / 5) // Extra overflow check. Or you could also keep on dividing by 5.
				break;
			i *= 5;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
