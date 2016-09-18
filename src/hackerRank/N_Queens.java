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
	public List<List<String>> solveNQueens(int n) { // DFS based hard question !
		List<List<String>> res = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		for(int i = 0 ; i < n; i++)
			Arrays.fill(board[i], '.');
		dfs(res, board, 0, n);
		return res;

	}

	private void dfs(List<List<String>> res, char[][] board, int col, int n) {
		if (col == n) {
			List<String> temp = charToList(board, n);
			res.add(temp);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isSafe(board, i, col))  {
				board[i][col] = 'Q'; // Easy recursion.
				dfs(res, board, col + 1, n);
				board[i][col] = '.'; // Put back '.' after the solution is found or not after recursion.
			}
					
		}

	}
	private List<String> charToList (char[][] board, int n) { // convert char board to List as required.
		List<String>  res = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String str = "";
			for(int j = 0 ; j < n; j++) {
				str += board[i][j];
			}
			res.add(str);
		}
				
		
		return res;
	}

	private boolean isSafe(char[][] board, int i, int j) {
		int ldiag = i - 1, rdiag = i + 1; // Two diagnols check.
		for (int col = j - 1; col >= 0; col--, ldiag--, rdiag++) {
			if (ldiag >= 0 && board[ldiag][col] == 'Q' || rdiag  < board[0].length && board[rdiag][col] == 'Q')
				return false;
		}
		for (int x = 0, y = 0; x < i || y < j; x++, y++) { // same row and column check.
			if (x < i && board[x][j] == 'Q')
				return false;
			if (y < j && board[i][y] == 'Q')
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		N_Queens obj = new N_Queens();
		System.out.println(obj.solveNQueens(4));
	}
}
