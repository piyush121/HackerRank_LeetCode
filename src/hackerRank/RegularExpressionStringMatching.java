/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 *
 */
public class RegularExpressionStringMatching { // O(m * n) runtime and space. So many cases !
	public boolean isMatch(String s, String p) {
	    int m = s.length();
	    int n = p.length();
	    boolean[][] DP = new boolean[m + 1][n + 1];
	    DP[0][0] = true;
	    for(int i = 1; i < n;i += 2)
	        if(p.charAt(i) == '*') // for cases like a*b*c*.
	            DP[0][i + 1] = DP[0][i - 1];

	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
	                DP[i+1][j+1] = DP[i][j];
	            else if(p.charAt(j) == '*') {
	                if(DP[i + 1][j - 1] || DP[i][j + 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)))
	                    DP[i+1][j+1] = true; // think of 'ac*b' and 'accb' to understand this scenario. its important.
	            }
	        }
	    }
	    return DP[m][n];
	}

	public static void main(String[] args) {
		//System.out.println(isMatch("aab", "c*a*b"));
	}
}
