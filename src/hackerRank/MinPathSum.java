/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */

/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class MinPathSum {

	public static int minPathSum(int[][] grid) { //Simple DP solution. Not very efficient though.

		int rows = grid.length;
		int col = grid[0].length;

		for (int i = 1; i < rows; i++)
			grid[i][0] += grid[i - 1][0];
		for (int j = 1; j < col; j++)
			grid[0][j] += grid[0][j - 1];
		for (int i = 1; i < rows; i++)
			for (int j = 1; j < col; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}

		return grid[rows - 1][col - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, 2 }, { 1, 1 } };
		System.out.println(minPathSum(input));
	}

}
