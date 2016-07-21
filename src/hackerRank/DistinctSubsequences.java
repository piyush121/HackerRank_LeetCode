/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String s, String t) { //Good DP problem.
		if (t.length() > s.length())
			return 0;
		int DP[][] = new int[t.length() + 1][s.length() + 1];

		for (int i = 0; i <= s.length(); i++)
			DP[0][i] = 1;

		for (int i = 1; i <= t.length(); i++)
			for (int j = 1; j <= s.length(); j++) {

				if (s.charAt(j - 1) == t.charAt(i - 1))
					DP[i][j] = DP[i - 1][j - 1] + DP[i][j - 1];
				else
					DP[i][j] = DP[i][j - 1];
			}
		return DP[t.length()][s.length()];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
