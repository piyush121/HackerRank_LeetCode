/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 */
public class Combinations {

	public static List<List<Integer>> combine(int n, int k) { // Took a long
																// time to do
																// this
																// recursively.
																// But this is
																// highly
																// inefficient
																// :P
		List<Integer> temp = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<>();
		combHelper(1, n, k, temp, result);
		return result;
	}

	private static void combHelper(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
		if (temp.size() == k) {
			result.add(new LinkedList<>(temp));
			return;
		}

		for (int i = start; i <= n; i++) {
			temp.add(i);
			combHelper(i + 1, n, k, temp, result);
			temp.remove(temp.size() - 1);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4, 1));
	}

}
