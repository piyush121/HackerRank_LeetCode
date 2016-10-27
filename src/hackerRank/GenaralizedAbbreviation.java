/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Example: Given word = "word", return the following list (order does not
 * matter): ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
 * "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 */
public class GenaralizedAbbreviation {
	public static List<String> generateAbbreviations(String word) { // Elegant Question asked at Google!
		Map<String, List<String>> map = new HashMap<>();
		if (map.containsKey(word))
			return map.get(word);
		List<String> res = new ArrayList<>();
		if (word.length() == 0) {
			res.add("");
			return res;
		}

		res.add(String.valueOf(word.length()));
		for (int i = 0; i < word.length(); i++) {
			String s = word.substring(i + 1);
			String left = i == 0 ? "" : "" + i;
			String ch = "" + word.charAt(i);
			for (String str : generateAbbreviations(s)) {
				res.add(left + ch + str);
			}
		}
		map.put(word, res);
		return res;
	}
	
	public List<String> generateAbbreviations1(String word) { // A better  solution.
	       List<String> res = new ArrayList<>();
	       dfs(res, word, "", 0, 0);
	       return res;
 }
 public void dfs(List<String> res, String word, String curr, int pos, int count) {
     if(pos == word.length()) {
         if(count > 0)
             curr += String.valueOf(count);
         res.add(curr);
         return;
     }
     
     dfs(res, word, curr, pos + 1, count + 1); // Abbreviate this char.
     dfs(res, word, curr + (count > 0 ? count : "") + word.charAt(pos), pos + 1, 0); // Don't abbreviate this char.
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateAbbreviations("wo"));
	}

}
