package hackerRank;

/*
 * Given a string S, you are allowed to convert it to a palindrome by adding 
 * characters in front of it. Find and return the shortest palindrome you can 
 * find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s.length() == 0)
			return "";
		String str = s + new StringBuilder(s).reverse().toString();
		int[] LPS = new int[str.length()];
		int j = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(j)) {
				LPS[j]++;
				j++;
			} else {
				while (str.charAt(j) != str.charAt(i) || j != 0) {
					j = LPS[j - 1];

				}
			}
		}
		return s.substring(LPS[LPS.length - 1]) + s;

	}

	public String shortestPalindrome1(String s) { // Brute force solution.
													// O(n^2).
		if (s.length() == 0)
			return s;
		int i = 0;

		for (i = s.length() - 1; i >= 0; i--) {
			if (isPalindrome(s.substring(0, i + 1)))
				break;
		}
		String str = new StringBuilder(s.substring(i + 1)).reverse().toString();
		return str + s.substring(0, i + 1);

	}

	private boolean isPalindrome(String str) {
		if (str.length() == 0)
			return true;
		char[] charr = str.toCharArray();

		for (int i = 0; i < charr.length; i++) {
			if (charr[i] != charr[charr.length - i - 1])
				return false;
		}
		return true;
	}
}
