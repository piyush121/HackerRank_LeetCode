/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */
public class WordBreak_II {
	Map<String, List<String>> seen = new HashMap<>();

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			return res;
		}
		if (seen.containsKey(s)) {
			return seen.get(s);
		}

		for (int i = 0; i <= s.length(); i++) {
			String left = s.substring(0, i);
			if (wordDict.contains(left)) {
				List<String> right = wordBreak(s.substring(i), wordDict);
				for (String str : right) {
					res.add(left + " " + str);
				}
				if (i == s.length())
					res.add(left);
			}
		}
		seen.put(s, res); // Memoize.
		return res;

	}

	private void main() {
		// TODO Auto-generated method stub

	}
}
