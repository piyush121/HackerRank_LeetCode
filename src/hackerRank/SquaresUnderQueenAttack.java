/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class SquaresUnderQueenAttack {

	/**
	 * Note: Write a solution with O(queries.length + queens.length + n) complexity and O(n) additional memory, since this is what you would be asked to do during a real interview.

In chess, queens can move any number of squares vertically, horizontally, or diagonally. You have an n × n chessboard with some queens on it. You are given several queries, each of which represents one square on the chessboard. For each query square, determine whether it can be attacked by a queen or not.

Example

For n = 5, queens = [[1, 1], [3, 2]] and queries = [[1, 1], [0, 3], [0, 4], [3, 4], [2, 0], [4, 3], [4, 0]], the output should be
squaresUnderQueenAttack(n, queens, queries) = [true, false, false, true, true, true, false].
	 */
	public boolean[] squaresUnderQueenAttack(int n, int[][] queens, int[][] queries) { // O(queens.length + queries.length) time. O(N) space.
		boolean[] res = new boolean[queries.length];
		boolean[] diag1 = new boolean[n * 2];
		boolean[] diag2 = new boolean[n * 2];
		boolean[] cols = new boolean[n];
		boolean[] rows = new boolean[n];
		for (int[] queen : queens) {
			int x = queen[0];
			int y = queen[1];
			diag1[n + x - y - 1] = true;
			diag2[x + y] = true;
			rows[x] = true;
			cols[y] = true;

		}
		int i = 0;
		for (int[] query : queries) {
			int x = query[0];
			int y = query[1];
			if (rows[x] || cols[y] || diag1[n + x - y - 1] || diag2[x + y])
				res[i] = true;
			i++;
		}

		return res;

	}

}
