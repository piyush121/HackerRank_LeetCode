/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 *
 */
public class DecodeWays {

	public int numDecodings(String s) {// Dynamic programming way! Tedious one.
		if (s.length() < 1)
			return 0;
		int DP[] = new int[s.length() + 1];
		DP[0] = 1; // Initialization
		DP[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++) {
			String str = s.substring(i - 2, i); // last two digit number
			int val2 = Integer.valueOf(str);
			int val1 = s.charAt(i - 1) - '0'; // last 1 digit number

			if (val1 > 0)
				DP[i] += DP[i - 1];
			if (val2 >= 10 && val2 <= 26) // tricky part.
				DP[i] += DP[i - 2];
		}

		return DP[s.length()];

	}
	
	
	public int numDecodings1(String s) { // Inefficient backtracking solution.
		if (s.length() == 0)
			return 0;
		Map<String, Integer> map = new HashMap<>();
		return numDecodings(s, map);
	}

	public int numDecodings(String s, Map<String, Integer> map) {
		if (s.length() == 0)
			return 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = Integer.valueOf(s.substring(0, i + 1));
			if (val <= 26 && val > 0) {
				if (map.containsKey(s)) {
					return map.get(s);
				}
				res += numDecodings(s.substring(i + 1, s.length()), map);
			} else
				break;
		}
		map.put(s, res);
		return res;
	}
}
