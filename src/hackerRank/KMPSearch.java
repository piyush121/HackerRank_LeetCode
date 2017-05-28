/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class KMPSearch {

	public static int strstr(String str, String x) {
		int[] prefix = getPrefixArray(x);
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			while (str.charAt(i) != x.charAt(j) && j != 0) {// tricky step.
				j = prefix[j - 1];
			}
			if (str.charAt(i) == x.charAt(j))
				j++;
			if (j == x.length())
				return i - j + 1;
		}
		return -1;
	}

	public static int[] getPrefixArray(String x) {
		int[] prefix = new int[x.length()];
		int j = 0;
		for (int i = 1; i < x.length(); i++) {
			if (x.charAt(i) == x.charAt(j)) {
				prefix[i] = ++j;
			} else {
				if (j != 0) {
					j = prefix[j - 1];
				}
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		System.out.println("\n" + strstr("ABABDABACDABABCABAB", "ABABCABAB"));

	}

}
