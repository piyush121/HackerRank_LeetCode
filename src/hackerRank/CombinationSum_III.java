/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), 1, n, k);
		return res;

	}

	private void helper(List<List<Integer>> res, List<Integer> list, int start, int n, int k) {
		if (list.size() == k) {
			if (n == 0)
				res.add(new ArrayList<Integer>(list));

			return;
		}

		for (int i = start; i <= 9; i++) {
			list.add(i);
			helper(res, list, i + 1, n - i, k);
			list.remove(i); // remove because we want next combination. Think
							// deep.
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
