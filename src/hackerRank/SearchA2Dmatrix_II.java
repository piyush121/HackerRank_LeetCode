/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
 * following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 *
 */
public class SearchA2Dmatrix_II {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int i = 0;
		int j = matrix[0].length - 1;
		while (j >= 0 && i < matrix.length) {
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] < target) // can't be in the same row.
				i++;
			else // can be in the same column.
				j--;
		}
		return false;
   }
}
