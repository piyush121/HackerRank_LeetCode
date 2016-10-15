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
public class RegularExpressionStringMatching {
	public boolean isMatch(String s, String p) {

		return (isMatch(s, p, '#', 0));

	}

	public boolean isMatch(String s, String p, char prev, int start) {
		if (s.length() == 0 && start == p.length())
			return true;
		if (s.length() == 0 && start < p.length())
			return false;
		char chs = s.charAt(0);

		for (int i = start; i < p.length(); i++) {
			char chp = p.charAt(i);
			if (chp >= 'a' && chp <= 'z' && chs != chp && p.charAt(i + 1) == '*')
				return isMatch(s.substring(1), p, '#', i + 2);

			if (chs == chp || chp == '.' || (chp == '*' && (prev == chs || prev == '.'))) {
				boolean res = isMatch(s.substring(1), p, chp, i + 1);
				if (res)
					return true;
			}
		}
		return false;
	}
}
