/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 */
public class PerfectSquares {
	public int numSquares(int n) { // DP based solution.
		if(n == 0)
			return 0;
		List<Integer> res = new ArrayList<>();
		res.add(0);
		for(int i = 1 ; i <=n ; i++) {
			int curr = Integer.MAX_VALUE;
			for(int j = 1; j*j <= i; j++) { // Build up the array.
				curr = Math.min(curr,  res.get(i - j*j) + 1);
			}
			res.add(curr);
		}
		
		return res.get(n);
	}
}
