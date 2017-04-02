/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 *
 */
public class LongestRepeatingCharacterReplacement { //O(N). Really tricky.
	public int characterReplacement(String s, int k) {
		int maxCountSoFar = 0;
		int res = 0;
		int[] counts = new int[26];
		int start = 0;
		for (int end = 0; end < s.length(); end++) {
			counts[s.charAt(end) - 'A']++;
			maxCountSoFar = Math.max(maxCountSoFar, counts[s.charAt(end) - 'A']);
			// it is a guarantee that end-start-maxCharCount+1 <= k, which is
			// clear. So end-start+1 <= maxCharCount+k. So even if we don't
			// update the maxCharCount everytime the window shrinks, the result
			// won't change and should be correct.
			if (end - start + 1 - maxCountSoFar > k) {
				counts[s.charAt(start) - 'A']--;
				start++;
			}
			res = Math.max(res, end - start + 1);
		}
		return res;
	}
}
