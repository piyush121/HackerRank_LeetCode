/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 *
 * 
 * 
 */
public class N_Queens_II {
	int count = 0;

	public int totalNQueens(int n) {
		if (n == 0)
			return count;
		boolean[] ldiag = new boolean[2 * n];
		boolean[] rdiag = new boolean[2 * n];
		boolean[] cols = new boolean[n];
		dfs(cols, rdiag, ldiag, n, 0);
		return count;
	}

	private void dfs(boolean[] cols, boolean[] rdiag, boolean[] ldiag, int n, int row) {
		if (row == n) {
			count++;
			return;
		}

		for (int j = 0; j < n; j++) {
			if (cols[j] || ldiag[row - j + n] || rdiag[row + j]) // all right diagonal elements share same sum.
				continue; // All left diagonals share same difference of their row and column. That's tricky.
			cols[j] = true;
			ldiag[row - j + n] = true;
			rdiag[row + j] = true;
			dfs(cols, rdiag, ldiag, n, row + 1);
			cols[j] = false; // put back stuff.
			ldiag[row - j + n] = false;
			rdiag[row + j] = false;
		}
	}
}
