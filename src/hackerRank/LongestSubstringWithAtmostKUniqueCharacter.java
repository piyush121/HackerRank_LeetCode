/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Piyush Chaudhary
 *
 */
public class LongestSubstringWithAtmostKUniqueCharacter {

	public static String longestKSubstring(String str, int k) { // O(N) time and O(# of unique characters) space.
		if (k == 0)
			return "";
		Map<Character, Integer> seen = new HashMap<>();
		int i = 0, j = 0;
		String res = "";
		for (j = 0; i <= j && j < str.length(); j++) {
			char ch = str.charAt(j);
			if (seen.containsKey(ch)) {
				seen.put(ch, seen.get(ch) + 1);
			} else {
				seen.put(ch, 1);
			}
			if (seen.size() > k) {
				String curr = str.substring(i, j);
				if (curr.length() > res.length())
					res = curr;

				while (seen.size() > k) {
					char remCh = str.charAt(i);
					seen.put(remCh, seen.get(remCh) - 1);
					if (seen.get(remCh) == 0)
						seen.remove(remCh);
					i++;
				}
			}
		}
		if (str.substring(i, j).length() > res.length())
			res = str.substring(i, j);
		return res;
	}

	// arguments are passed using the text field below this editor
	public static void main(String[] args) {

		System.out.print(longestKSubstring("abcadcacacaca", 2));
	}

}
