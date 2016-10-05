/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;
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
		helper(s, wordDict, res, new ArrayList<>());
		return res;
	}

	private void helper(String s, Set<String> dict, List<String> res, List<String> temp) {
		if (s.length() == 0) {
			res.add(String.join(" ", temp));
			return;
		}

		for (int i = 0; i <= s.length(); i++) {
			String str = s.substring(0, i);
			if (dict.contains(str)) {
				temp.add(str);
				helper(s.substring(i), dict, res, temp);
				temp.remove(temp.size() - 1);

			}
		}
	}
}
