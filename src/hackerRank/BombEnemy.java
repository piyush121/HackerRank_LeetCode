/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits 
the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
 *
 */
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		int max = 0, rowMax = 0;
		int[] colMemo = new int[grid[0].length]; // save current state of every column.

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0 || grid[i][j - 1] == 'W') // if prev. value was 'W' then we need to recalculate the new number of enemies in this column.
					rowMax = findRowMax(grid, i, j);
				if (i == 0 || grid[i - 1][j] == 'W')
					colMemo[j] = findColMax(grid, i, j);
				if (grid[i][j] == '0')
					max = Math.max(max, rowMax + colMemo[j]);

			}
		}
		return max;
	}

	private int findRowMax(char[][] grid, int i, int j) { // all enemies in this row.
		int res = 0;
		for (int col = j; col < grid[0].length; col++) {
			if (grid[i][col] == 'E')
				res++;
			else if (grid[i][col] == 'W')
				break;
		}

		return res;
	}

	private int findColMax(char[][] grid, int i, int j) { // all enemies in this column.
		int res = 0;
		for (int row = i; row < grid.length; row++) {
			if (grid[row][j] == 'E')
				res++;
			else if (grid[row][j] == 'W')
				break;
		}
		return res;
	}
}
