package hackerRank;

import java.util.Arrays;

/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class Unique_Paths_II {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) { // Works
																		// but
																		// inefficient.
		int[][] DP = obstacleGrid;
		int col = obstacleGrid[0].length;
		int rows = obstacleGrid.length;
		if (DP[rows - 1][col - 1] == 1 || DP[0][0] == 1)
			return 0;
		DP[0][0] = -1;
		for (int i = 1; i < rows; i++) {
			if (DP[i][0] == 1)
				continue;
			if (DP[i - 1][0] == 1)
				DP[i][0] = 1;
			else
				DP[i][0] = -1;
		}
		for (int j = 1; j < col; j++) {
			if (DP[0][j] == 1)
				continue;
			if (DP[0][j - 1] == 1)
				DP[0][j] = 1;
			else
				DP[0][j] = -1;
		}

		for (int i = 1; i < rows; i++)
			for (int j = 1; j < col; j++) {
				if (DP[i][j] != 1) {
					if (DP[i - 1][j] != 1 && DP[i][j - 1] != 1)
						DP[i][j] += DP[i - 1][j] + DP[i][j - 1];
					else if (DP[i - 1][j] != 1)
						DP[i][j] += DP[i - 1][j];
					else if (DP[i][j - 1] != 1)
						DP[i][j] += DP[i][j - 1];
				}
			}

		for (int i = 0; i < rows; i++)
			System.out.println(Arrays.toString(DP[i]));
		return -DP[rows - 1][col - 1];
	}

	public static void main(String[] args) {

		int[][] input = { { 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		for (int i = 0; i < input.length; i++)
			System.out.println(Arrays.toString(input[i]));
		System.out.println(uniquePathsWithObstacles(input));
	}
}
