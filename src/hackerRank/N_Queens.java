/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n Chess board such that no two queens 
 * attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both 
indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 *
 */
public class N_Queens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		Set<List<Integer>> board = new HashSet<>();
		dfs(res, new ArrayList<String>(), board, 0, n);
		return res;

	}

	private void dfs(List<List<String>> res, List<String> curr, Set<List<Integer>> board, int col, int n) {
		if (col == n) {
			List<String> temp = new ArrayList<>(curr);
			res.add(temp);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isSafe(board, i, col))  {
				curr.add("Q");
				board.add(Arrays.asList(new Integer[] { i, col }));
				dfs(res, curr, board, col + 1, n);
				board.remove(Arrays.asList(new Integer[] { i, col }));
				curr.remove(curr.size() - 1);
			}
			else
			    curr.add(".");
					
		}

	}

	private boolean isSafe(Set<List<Integer>> board, int i, int j) {
		int ldiag = i - 1, rdiag = i + 1;
		for (int col = j - 1; col >= 0; col--, ldiag--, rdiag++) {
			List<Integer> left = Arrays.asList(new Integer[] { ldiag, col });
			List<Integer> right = Arrays.asList(new Integer[] { rdiag, col });
			if (board.contains(left) || board.contains(right))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		N_Queens obj = new N_Queens();
		System.out.println(obj.solveNQueens(4));
	}
}
