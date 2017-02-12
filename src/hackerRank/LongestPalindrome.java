/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) { // O(n) time and space
		if (s.length() < 2)
			return s.length();
		Map<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			if (!map.containsKey(ch))
				map.put(ch, 0);
			map.put(ch, map.get(ch) + 1);
		}
		int res = 0;
		for (char ch : map.keySet()) {
			int count = map.get(ch);
			if (count % 2 == 0)
				res += count;
			else
				res += count - 1;
		}

		if (res < s.length())
			res++;
		return res;
    }
}
