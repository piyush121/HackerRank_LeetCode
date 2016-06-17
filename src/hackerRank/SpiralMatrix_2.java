package hackerRank;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class SpiralMatrix_2 {
	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int colStart = 0;
		int rowStart = 0;
		int colEnd = n - 1;
		int rowEnd = n - 1;
		int count = 1;

		while (colStart <= colEnd) {

			for (int i = colStart; i <= colEnd; i++) {
				result[rowStart][i] = count;
				count++;
			}
			rowStart++;

			for (int j = rowStart; j <= rowEnd; j++) {
				result[j][colEnd] = count;
				count++;
			}
			colEnd--;

			for (int i = colEnd; i >= colStart; i--) {
				result[rowEnd][i] = count;
				count++;
			}
			rowEnd--;

			for (int j = rowEnd; j >= rowStart; j--) {
				result[colStart][j] = count;
				count++;
			}
			colStart++;

		}

		return result;

	}

}
