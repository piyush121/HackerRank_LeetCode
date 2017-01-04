/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String str) { // O(n^2) time and O(n) space.
		int len = str.length();
		for (int i = 1; i <= len / 2; i++) {
			if (len % i == 0) { // substring should be a divisor of the length of actual string.
				StringBuilder strb = new StringBuilder();
				String substr = str.substring(0, i);
				for (int j = 0; j < len / i; j++)
					strb.append(substr); // append till length becomes equal to the str's length.
				if (strb.toString().equals(str))
					return true;
			}
		}
		return false;
	}
	
	 public boolean repeatedSubstringPattern1(String str) { // O(1) space.
		 int len = str.length();
		 for(int i = len / 2; i >0; i--) {
			 if( len % i == 0) {
				 String substr = str.substring(0, i);
				 int j = 0;
				 for(j = 0; j < len / i; j++)
					 if(!substr.equals(str.substring(j * i, j * i + i))) // check every substring matches or not.
					    break;
				 if(j == len / i)
					 return true;
			 }
		 }
		 return false;
	    }
}
