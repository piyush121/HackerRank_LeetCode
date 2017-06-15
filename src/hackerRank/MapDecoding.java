/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent and you need to determine the total number of ways that the message can be decoded.

Since the answer could be very large, take it modulo 109 + 7.

Example

For message = "123", the output should be

mapDecoding(message) = 3.

"123" can be decoded as "ABC" (1 2 3), "LC" (12 3) or "AW" (1 23), so the total number of ways is 3.
 *
 */
public class MapDecoding {
	int mapDecoding(String message) { // O(N) time and soace.
		int n = message.length();
		if (n == 0)
			return 1;
		if (message.charAt(0) == '0')
			return 0;
		int[] DP = new int[n + 1];
		DP[0] = 1;
		DP[1] = 1;
		for (int i = 1; i < n; i++) {
			char ch = message.charAt(i);
			char prev = message.charAt(i - 1);
			// Can't make a number if it starts with a 0.
			if (ch - '0' > 0)
				DP[i + 1] += DP[i] % 1000000007;
			int val = Integer.valueOf("" + prev + ch);
			// check previous digit + this digit.
			if (val > 9 && val <= 26)
				DP[i + 1] += DP[i - 1] % 1000000007;
			DP[i] = DP[i];
		}
		return DP[n];
	}

	int mapDecoding1(String message) { // Recursive way.
		return countWays(message, new HashMap<>());
	}

	int countWays(String message, Map<String, Integer> map) {
		if (message.length() == 0) {
			return 1;
		}
		if (map.containsKey(message))
			return map.get(message);
		int count = 0;
		for (int i = 0; i < message.length(); i++) {
			String str = message.substring(0, i + 1);
			int val = Integer.valueOf(str);
			if (val < 1 || val > 26)
				break;
			count += countWays(message.substring(i + 1), map) % 1000000007;
		}
		map.put(message, count % 1000000007);
		return count % 1000000007;
	}
}
