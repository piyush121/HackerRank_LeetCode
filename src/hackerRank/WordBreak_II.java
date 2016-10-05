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
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 *
 */
public class WordBreak_II {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		helper(s, wordDict, res, new HashMap<String, List<String>>());
		return res;
	}

	private List<String> helper(String s, Set<String> dict, List<String> res, Map<String, List<String>> seen) {
		if (s.length() == 0) {
			return null;
			
		}
		if(seen.containsKey(s)) {
			return seen.get(s);
		}

		for (int i = 0; i <= s.length(); i++) {
			String str = s.substring(0, i);
			if (dict.contains(str)) {
				temp.add(str);
				List<String> right = helper(s.substring(i), dict, res);
				temp.remove(temp.size() - 1);

			}
		}
	}
	
	private void mai() {
		// TODO Auto-generated method stub

	}
}
