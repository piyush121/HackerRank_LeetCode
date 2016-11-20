/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 *You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 
 *represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid 
 *is completely surrounded by water, and there is exactly one island (i.e., one or more connected 
 *land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around 
 *the island). One cell is a square with side length 1. The grid is rectangular, width and height don't 
 *exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
 *
 */
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) { // Easy one!
		if (grid.length == 0) {
			return 0;
		}
		int rn = grid.length;
		int cn = grid[0].length;
		int perimeter = 0;
		for (int i = 0; i < rn; i++) {
			for (int j = 0; j < cn; j++) {
				if (grid[i][j] == 1)
					perimeter += findCount(grid, i, j);
			}
		}
		return perimeter;
	}

	int findCount(int[][] grid, int i, int j) {
		int sum = 0;
		// top
		if (i != 0) {
			sum += grid[i - 1][j] == 0 ? 1 : 0;
		} else {
			sum += 1;
		}
		// bottom
		if (i != grid.length - 1) {
			sum += grid[i + 1][j] == 0 ? 1 : 0;
		} else {
			sum += 1;
		}
		// left
		if (j != 0) {
			sum += grid[i][j - 1] == 0 ? 1 : 0;
		} else {
			sum += 1;
		}
		// right
		if (j != grid[0].length - 1) {
			sum += grid[i][j + 1] == 0 ? 1 : 0;
		} else {
			sum += 1;
		}
		return sum;
	}
}
