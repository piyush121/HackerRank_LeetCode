/**
 * @author Piyush Chaudhary
 */
/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
/**
 * @author Piyush Chaudhary
 *
 */
package hackerRank;

public class Search2DMatrix { // Pretty straight forward but I think we can do better.

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int row = m - 1;
		int col = 0;
		
		while(row >= 0 && col < n ) {
			if(matrix[row][col] == target)
				return true;
			if(target > matrix[row][col])
				col++;
			else
				row--;
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
