/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * Hint:
 * 
 * Try to use recursion and notice that it should recurse with n - 2 instead of
 * n - 1.
 *
 */
public class StrobogrammaticNumber_II {
	public List<String> findStrobogrammatic(int n) {
		List<String> res = helper(n, n);
		return res;
	}

	private List<String> helper(int n, int m) {
		List<String> res1 = new ArrayList<>();
		if (n == 1) {
			res1.add("0");
			res1.add("1");
			res1.add("8");
			return res1;

		}
		if (n == 2) {
			res1.add("11");
			res1.add("69");
			res1.add("88");
			res1.add("96");
			if (m != n)
				res1.add("00");
			return res1;
		}

		List<String> res = helper(n - 2, m);

		for (String str : res) {
			if (m != n) // Great trick to add 0 only when it is not at the outermost recursion stack.
				res1.add("0" + str + "0");
			res1.add("1" + str + "1");
			res1.add("8" + str + "8");
			res1.add("6" + str + "9");
			res1.add("9" + str + "6");
		}
		return res1;
	}
}
