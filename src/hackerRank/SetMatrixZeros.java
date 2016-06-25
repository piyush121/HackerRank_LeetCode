/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;

/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
/**
 * @author Piyush Chaudhary
 *
 */
public class SetMatrixZeros {

	public static void setZeroes(int[][] matrix) { //Works but not much efficient. As space complexity is O(m + n)
		if (matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		HashSet<Integer> rows = new HashSet<>();
		HashSet<Integer> columns = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					columns.add(j);
				}

			}
		}
		for (int row : rows) {
			for (int j = 0; j < n; j++)
				matrix[row][j] = 0;
		}
		for (int col : columns) {
			for (int i = 0; i < m; i++)
				matrix[i][col] = 0;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) 
				System.out.print("\t"+matrix[i][j]);
		System.out.println();
		}
		System.out.println();
	
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) 
				System.out.print("\t"+matrix[i][j]);
		System.out.println();
		}

	}

}
