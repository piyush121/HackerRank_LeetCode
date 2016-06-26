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
public class MinWindowSubstring {

	public static String minWindow(String s, String t) { // Very difficult but
															// important ques. I
															// hope to see this
															// kind of qes.
															// again. Its not
															// hard to visualize
															// but very hard to
															// code up.
		if (t.length() == 0 || s.length() == 0)
			return "";

		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray())
			map.put(ch, 0);
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int counter = t.length();
		int minStart = 0;
		for (char ch : t.toCharArray()) {
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				return "";
		}
		for (end = 0; end < s.length(); end++) {
			
			char c1 = s.charAt(end);
			if ( map.get(c1)> 0)
				counter--;
			map.put(c1, map.get(c1) - 1); // Key step.
																// Very
																// Important !!!
			while (counter == 0) {
				if (end - start < minLen) {
					minLen = end - start;
					minStart = start;
				}
				char c2 = s.charAt(start);
				map.put(c2, map.get(c2) + 1);
				if (map.get(c2) > 0)
					counter++;

				start++;
			}

		}

		if (minLen != Integer.MAX_VALUE)
			return s.substring(minStart, minStart + minLen + 1);
		return "";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

}
