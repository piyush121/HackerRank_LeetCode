/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, 
 * Given: 
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. 
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) { // Although BFS would be more efficient but this DP based solution also kicks ass. ;P
		int len = s1.length() + s2.length();
		if (s3.length() != len)
			return false;
		int m = s1.length();
		int n = s2.length();
		boolean[][] DP = new boolean[m + 1][n + 1];
		
		DP[0][0] = true;
		for (int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 && j == 0)
					continue;
				int k = i + j; // Important step !
				
				if(i > 0 && DP[i - 1][j] && s3.charAt(k - 1) == s1.charAt(i - 1) ||
						j > 0 && DP[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k - 1))
					DP[i][j] = true;
			}
			
		}
		
		return DP[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleave("", "", "a"));
	}

}
