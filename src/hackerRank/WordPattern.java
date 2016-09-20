/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty 
word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated 
by a single space.
 *
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) { // Using 1 HashMap.
		String[] strArray = str.split(" ");
		if (pattern.length() != strArray.length)
			return false;
		Map<Character, String> strMap = new HashMap<>();

		for (int i = 0; i < strArray.length; i++) {
			Character pat = pattern.charAt(i);
			String st = strArray[i];
			if (strMap.containsKey(pat)) {
				String st1 = strMap.get(pat);
				if (!st1.equals(st))
					return false;
			} else {
				if (strMap.values().contains(st))
					return false;
				strMap.put(pat, st);
			}

		}
		return true;
	}
	
	public boolean wordPattern1(String pattern, String str) { // O(n) time and space. But kind of Inefficient.
		String[] strArray = str.split(" ");
		if (pattern.length() != strArray.length)
			return false;
		Map<Character, Integer> patMap = new HashMap<>();
		Map<Integer, String> strMap = new HashMap<>();

		for (int i = 0; i < strArray.length; i++) {
			Character pat = pattern.charAt(i);
			String st = strArray[i];
			if (patMap.containsKey(pat)) {
				int idx = patMap.get(pat);
				String st1 = strMap.get(idx);
				if (!st1.equals(st))
					return false;
			} else {
				if (strMap.values().contains(st))
					return false;
				patMap.put(pat, i);
				strMap.put(i, st);
			}

		}
		return true;
	}
}
