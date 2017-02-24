/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:
 *
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0];
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dirs = { { -1, 1 }, { 1, -1 } };
		int[] res = new int[m * n];
		int row = 0, col = 0, d = 0;

		for (int i = 0; i < m * n; i++) {
			res[i] = matrix[row][col];
			row += dirs[d][0];
			col += dirs[d][1];

			if (row == m) {
				row -= 1;
				col += 2;
				d = 0;
			}

			if (col == n) {
				row += 2;
				col -= 1;
				d = 1;
			}

			if (row < 0) {
				row = 0;
				d = 1;
			}

			if (col < 0) {
				col = 0;
				d = 0;
			}

		}
		return res;
	}
}
