/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a 
non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
 *
 */
public class WordPattern_II {
	public boolean wordPatternMatch(String pattern, String str) { // Totally works with good enough time.
		if (pattern.length() == 0 && str.length() != 0)
			return false;
		Map<Character, String> map = new HashMap<>();
		Set<String> mapped = new HashSet<>();
		return dfs(0, 0, pattern.toCharArray(), str, map, mapped);
	}

	private boolean dfs(int curr, int start, char[] pattern, String str, Map<Character, String> map,
			Set<String> mapped) {
		if (curr == pattern.length && start == str.length())
			return true;
		if (start == str.length() || curr == pattern.length)
			return false;
		for (int i = start; i < str.length() && curr < pattern.length; i++) {
			Character ch = pattern[curr];
			String sub = str.substring(start, i + 1);
			if (!map.containsKey(ch)) {
				if (mapped.contains(sub)) // It is possible that this value is already mapped by a different key
					continue;
				map.put(ch, sub);
				mapped.add(sub);
				boolean res = dfs(curr + 1, i + 1, pattern, str, map, mapped);
				if (res)
					return true;
				else {
					map.remove(ch); // Remove what you put before. usual in Recursion.
					mapped.remove(sub);
				}
			} else {
				String st = map.get(ch);
				if (str.startsWith(st, i)) {
					boolean res = dfs(curr + 1, start + st.length(), pattern, str, map, mapped);
					if (res)
						return true;
				} else
					return false;

			}

		}
		return false;
	}

	public static void main(String[] args) {
		WordPattern_II obj = new WordPattern_II();
		System.out.println(obj.wordPatternMatch("itwastimes", "ittwaastthhebesttoofttimesss"));
	}
}
