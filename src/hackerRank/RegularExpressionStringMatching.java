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
public class RegularExpressionStringMatching { // TOugh as hell !
	public static boolean isMatch(String s, String p) {

		return (isMatch(s, p, '#', 0));

	}

	public static boolean isMatch(String s, String p, char prev, int start) {
		if (s.length() == 0 && start == p.length() || s.length() == 0 && p.charAt(start) == '*' )
			return true;
		if (s.length() != 0 && start >= p.length() || s.length() == 0 && p.charAt(start) != '*' || s.length() == 0 && start < p.length() - 1)
			return false;
		char chs = s.charAt(0);

		int i = start;
		boolean res = false;
		char chp = p.charAt(i);

		if (chp == '.')
			res = isMatch(s.substring(1), p, chp, i + 1);
		
		else if((chp == '*' && (prev == chs || prev == '.'))) {
			while(s.length() > 0 && (s.charAt(0) == prev || prev == '.') )
				s = s.substring(1);
			res = isMatch(s, p, chp, i + 1);
		}
		else if (i < p.length() - 1 && chp != chs && p.charAt(i + 1) == '*')
			res = isMatch(s, p, '*', i + 2);

		else if (chs == chp )
			res = isMatch(s.substring(1), p, chp, i + 1);

		if (res)
			return true;

		return false;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", ".*"));
	}
}
