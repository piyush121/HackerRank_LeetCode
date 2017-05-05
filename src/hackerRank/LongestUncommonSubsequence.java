/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc", "eae"
Output: 3
Note:

All the given strings' lengths will not exceed 10.
The length of the given list will be in the range of [2, 50].
 *
 */
public class LongestUncommonSubsequence {
	/**
	 * Just check every string whether it's a subsequence of any other string or not.
	 */
	public int findLUSlength(String[] strs) { //O(n^2) time. O(1) space.
		if (strs.length == 0)
			return 0;
		int max = -1;
		int i = 0;
		// Arrays.sort(strs, (a,b) -> b.length() - a.length());
		for (int j = 0; j < strs.length; j++) {
			for (i = 0; i < strs.length; i++) {
				if (j == i || !isSubsequence(strs[j], strs[i]))
					continue;
				else
					break;
			}
			if (i == strs.length)
				max = Math.max(strs[j].length(), max);
		}
		return max;
	}

	public boolean isSubsequence(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int i = 0, j = 0;
		while (j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j))
				i++;
			if (i == s1.length())
				break;
			j++;
		}
		if (i == s1.length())
			return true;
		return false;
	}
}
