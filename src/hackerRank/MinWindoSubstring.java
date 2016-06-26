/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 *
 */
public class MinWindoSubstring {

	public static String minWindow(String s, String t) {
		if (t.length() == 0 || s.length() == 0)
			return "";

		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray())
			map.put(ch, 0);
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int counter = 0;
		int minStart = 0;
		for (char ch : t.toCharArray()) {
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
		}
			for (end = 0; end < s.length(); end++) {
				if (map.get(s.charAt(end)) > 0)
					counter--;
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1); // Key step. Very Important !!!
				while (counter == 0) {
					if (end - start > minLen) {
						minLen = end - start;
						minStart = start;
					}
					map.put(s.charAt(start), map.get(s.charAt(start) + 1));
					if (map.get(s.charAt(start)) > 0)
						counter++;

					start++;
				}

			}

		if (minLen != Integer.MAX_VALUE)
			return s.substring(minStart, minStart + minLen);
		return "";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

}
