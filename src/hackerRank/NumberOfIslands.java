/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 *
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					res++;
				}
			}
		return res;
	}

	private void dfs(char[][] grid, int row, int col) {
		if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == '0' || grid[row][col] == 'x')
			return; // A lot of checks I know.
		grid[row][col] = 'x';

		dfs(grid, row + 1, col);
		dfs(grid, row, col + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
