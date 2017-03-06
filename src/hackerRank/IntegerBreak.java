/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of 
 * those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
 *
 */
public class IntegerBreak {
	
	public int integerBreak(int n) { // DP way.
        int[] DP = new int[n + 1];
        DP[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i/2; j++) {
                DP[i] = Math.max(j * (i - j), Math.max(DP[i], j * DP[i - j]));
            }
        }
        return DP[n];
    }
	
	public int integerBreak1(int n) {
		return integerBreak(n, new HashMap<Integer, Integer>());
	}

	public int integerBreak(int n, Map<Integer, Integer> map) { // Recursive way of doing it.
		if (n == 1 || n == 2)
			return 1;
		int max = 0;
		if (map.containsKey(n))
			return map.get(n);
		for (int i = 1; i < n; i++) {
			max = Math.max(i * (n - i), Math.max(max, i * integerBreak(n - i, map)));
		}
		map.put(n, max);
		return max;
	}
}
