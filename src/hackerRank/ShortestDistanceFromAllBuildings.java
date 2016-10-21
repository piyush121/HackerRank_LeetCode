/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only
 *  move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 *
 */
class Point {
	int x;
	int y;
	int dist;

	public Point(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class ShortestDistanceFromAllBuildings {
	int[] dx = { 1, 0, -1, 0 }; // Simple trick to go in all 4 directions.
	int[] dy = { 0, 1, 0, -1 };

	public int shortestDistance(int[][] grid) {
		if (grid.length == 0)
			return -1;
		int m = grid.length;
		int n = grid[0].length;
		int[][] dist = new int[m][n]; // Store distances from all the buildings for every land.
		List<Point> buildings = new ArrayList<>(); // Get location of all buildings.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = grid[i][j];
				if (grid[i][j] == 1)
					buildings.add(new Point(i, j, 0));
			}
		}
		int k = 0;
		for (Point build : buildings) {
			bfs(grid, dist, build, k--); // K-- because '1' is mentioned as
											// building.
		}
		int res = -1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == -buildings.size() && (dist[i][j] < res || res < 0))
					res = dist[i][j];
			}
		}

		return res == -1 ? -1 : res;
	}

	private void bfs(int[][] grid, int[][] dist, Point curr, int k) {
		Queue<Point> que = new LinkedList<>();
		que.add(curr);
		int m = grid.length;
		int n = grid[0].length;
		while (!que.isEmpty()) {
			Point pt = que.poll();
			for (int i = 0; i < 4; i++) {
				int x = pt.x + dx[i];
				int y = pt.y + dy[i];
				if (x < m && y < n && x >= 0 && y >= 0 && grid[x][y] == k) {
					que.add(new Point(x, y, pt.dist + 1));
					grid[x][y] = k - 1;
					dist[x][y] += pt.dist + 1;
				}
			}
		}
	}
}
