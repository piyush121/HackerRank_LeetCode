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
	public int numDecodings(String s) { // Inefficient backtracking solution.
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
