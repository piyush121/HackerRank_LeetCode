/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 *
 */
public class OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {
		if (s.equals(t))
			return false;
		if (s.length() >= t.length())
			return helper(s, t);
		return helper(t, s);
	}

	public boolean helper(String s, String t) {
		if (s.length() - t.length() > 1)
			return false;
		int n = t.length();
		int m = s.length();
		int i = 0, j = 0;
		int diff = 0;
		for (i = 0; i < s.length() && j < t.length(); i++) {
			if (s.charAt(i) != t.charAt(j)) {
				diff++;
				if (diff > 1)
					return false;
				if (m == n)
					j++;
			} else
				j++;
		}
		if (diff != 1)
			return s.length() - t.length() == 1;
		return true;

	}
}
