/**
 * @author Piyush Chaudhary
 */
package hackerRank;
/*Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 *  (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {//Standard dynamic programming puzzle.
		 int m = word2.length();
	        int n = word1.length();
	        if(m == 0)	// Cannot miss the corner cases !
	            return n;
	        if(n == 0)
	            return m;
	        int[][] DP = new int[n + 1][m + 1];
	        
	        for(int j =1 ; j <= m; j++) {
	        	DP[0][j] = j;
	        }
	        for(int i =1 ; i <= n; i++) {
	        	DP[i][0] = i;
	        }
	        
	        for(int i =1 ; i <= n; i++) {
	        	for(int j =1 ; j <= m; j++) {
	        		if(word1.charAt(i - 1) == word2.charAt(j - 1))
	        			DP[i][j] = DP[i-1][j-1];
	        		else
	        		DP[i][j] = Math.min(Math.min(DP[i-1][j], DP[i][j-1]), DP[i-1][j-1]) + 1; // Main idea is this.
	        	}
	        }
	        
	        return DP[n][m];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
