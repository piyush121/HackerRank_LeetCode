/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 */
public class PerfectSquares {
	public int numSquares(int n) { // DP based solution.
		if (n == 0)
			return 0;
		List<Integer> res = new ArrayList<>();
		res.add(0);
		for (int i = 1; i <= n; i++) {
			int curr = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) { // Build up the array.
				curr = Math.min(curr, res.get(i - j * j) + 1);
			}
			res.add(curr);
		}

		return res.get(n);
	}

	public int numSquares1(int n) { // BFS based solution
		if (n == 0)
			return 0;
		Queue<Integer> searchQ = new LinkedList<>();
		Set<Integer> seen = new HashSet<>();
		int depth = 0;
		searchQ.add(0);
		int size = searchQ.size();
		while (!searchQ.isEmpty()) {
			int num = searchQ.poll();
			if (num == n)
				return depth;
			for (int i = 1; i * i <= n; i++) {
				int temp = i * i + num;
				if (!seen.contains(temp) && temp <= n) {
					searchQ.add(temp);
					seen.add(temp);
				} else if (temp > n)
					break;
			}
			if (--size == 0) {
				depth++;
				size = searchQ.size();
			}

		}
		return -1;

	}

}
