/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.*;

/**
 * Write a function that takes an integer n and returns all of the ways that
 * integers not greater than n can be multiplied together in order to equal n.
 * Do not repeat sets of factors - for instance, if the output contains [4, 3],
 * it shouldn't also contain [3, 4]. Both your sets and the numbers in the sets
 * should be sorted in descending order. 1 should only be included in a set if
 * the set also contains n.
 * 
 * Example
 * 
 * For n = 12, the output should be setsOfFactors(n) = [[12, 1], [6, 2], [4, 3],
 * [3, 2, 2]].
 *
 */
public class SetsOfFactors {
	List<List<Integer>> setsOfFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		getFactors(n, new ArrayList<>(), new HashSet<>(), res);
		res.get(res.size() - 1).add(1);

		Collections.sort(res, new Comparator<List<Integer>>() {
			public int compare(List<Integer> l1, List<Integer> l2) {
				for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
					if (l1.get(i) > l2.get(i))
						return -1;
					if (l1.get(i) < l2.get(i))
						return 1;
				}
				return 0;
			}
		});
		return res;
	}

	void getFactors(int n, List<Integer> curr, Set<List<Integer>> seen, List<List<Integer>> res) {
		if (n == 1) {
			List<Integer> list = new ArrayList<>(curr);
			Collections.sort(list, (a, b) -> b - a);
			if (seen.add(list))
				res.add(list);
			return;
		}

		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				curr.add(i);
				getFactors(n / i, curr, seen, res);
				curr.remove(curr.size() - 1);
			}
		}
	}

}
