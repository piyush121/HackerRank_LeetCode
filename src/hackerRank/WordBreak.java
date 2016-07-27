/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) { //Kind of like rod cutting problem.
		if(s.length() == 0)
			return true;
		
		boolean[] DP = new boolean[s.length() + 1];
		DP[0] = true;
		
		for (int i = 0; i <= s.length(); i++)
			for(int j = 0; j <= i; j++) { // check if previously calculated value can be used again or not.
				if(DP[j] && wordDict.contains(s.substring(j, i))){
					DP[i] = true;
					break;
				}
			}
		
		return DP[s.length()];
	}

	public boolean wordBreak(String s, Set<String> wordDict) { // Inefficient
																// recursive
																// code.
		if (s.length() == 0)
			return true;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (wordDict.contains(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1, s.length()), wordDict))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
