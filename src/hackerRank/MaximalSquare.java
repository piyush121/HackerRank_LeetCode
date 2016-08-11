/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 
 * 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 *
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) { // O(mn) space and time. Easy.
		if (matrix.length == 0)
			return 0;
		int[][] DP = new int[matrix.length + 1][matrix[0].length + 1];
		int res = 0;
		for (int i = 1; i < DP.length; i++)
			for (int j = 1; j < DP[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					DP[i][j] = Math.min(Math.min(DP[i - 1][j], DP[i - 1][j - 1]), DP[i][j - 1]) + 1;
					res = Math.max(res, DP[i][j]);
				}
			}
		return res * res;
	}

	public int maximalSquare1(char[][] matrix) { // In progress ! O(N) space solution. Very hard to solve.
		int[] DP = new int[matrix[0].length + 1];
		int temp = 0;
		int pre = 0;
		int result = 0;
		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++) {
				temp = DP[j];
				if (matrix[i - 1][j - 1] == 1 ) {
					DP[j] = Math.min(Math.min(DP[j - 1], DP[j]), pre) + 1;
					result = Math.max(result, DP[j]);
				} else
					DP[j] = matrix[i - 1][j - 1];
				pre = temp;

			}
		return result * result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
