package hackerRank;

import java.util.Scanner;

public class ConnectedCellInGrid {
	public static int getBiggestRegion(int[][] matrix) {
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					count = Math.max(count, dfs(matrix, i, j));
				}
			}
		}
		return count;
	}

	public static int dfs(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j >= matrix[0].length || j < 0 || matrix[i][j] == 0)
			return 0;
		matrix[i][j] = 0;
		int count = 1 + dfs(matrix, i + 1, j) + dfs(matrix, i - 1, j) + dfs(matrix, i, j + 1) + dfs(matrix, i, j - 1)
				+ dfs(matrix, i + 1, j + 1) + dfs(matrix, i - 1, j + 1) + dfs(matrix, i + 1, j - 1)
				+ dfs(matrix, i - 1, j - 1);
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		System.out.println(getBiggestRegion(grid));
	}
}
