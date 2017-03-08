/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 *
 */
public class OnesAndZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
		return intfindMaxForm(strs, 0, m, n, new HashMap<String, Integer>());
	}

	public int intfindMaxForm(String[] strs, int pos, int m, int n, Map<String, Integer> map) { // Memoized recursion version. O(n * m * strs.length()) time.
		if (pos == strs.length || m == 0 & n == 0 || m < 0 || n < 0)
			return 0;

		int max = 0;
		String str = m + "-" + n + "-" + pos;
		if (map.containsKey(str))
			return map.get(str);

		int ones = countOnes(strs[pos]);
		int zeros = Math.abs(strs[pos].length() - ones);
		int taken = 0;
		if (m - zeros >= 0 && n - ones >= 0)
			taken = 1 + intfindMaxForm(strs, pos + 1, m - zeros, n - ones, map);
		int notTaken = intfindMaxForm(strs, pos + 1, m, n, map);
		max = Math.max(taken, notTaken);

		map.put(m + "-" + n + "-" + pos, max);
		return max;
	}

	public int countOnes(String str) {
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				res++;
		}
		return res;
	}
}
