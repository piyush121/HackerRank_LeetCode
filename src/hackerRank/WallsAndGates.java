/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 *
 */
public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) { // Recursive BFS.
		if (rooms.length == 0)
			return;
		for (int i = 0; i < rooms.length; i++)
			for (int j = 0; j < rooms[0].length; j++)
				if (rooms[i][j] == 0) // from the gate start flooding.
					bfs(rooms, i, j, 0);

	}

	private void bfs(int[][] rooms, int row, int col, int level) {
		if (row >= rooms.length || row < 0 || col >= rooms[0].length || col < 0)
			return;
		if (rooms[row][col] < level) // no need to go further as path will not get any shorter from here.
			return;
		rooms[row][col] = level;
		bfs(rooms, row, col + 1, level + 1);
		bfs(rooms, row + 1, col, level + 1);
		bfs(rooms, row, col - 1, level + 1);
		bfs(rooms, row - 1, col, level + 1);
	}
	
	public void wallsAndGates1(int[][] rooms) { // Iterative BFS.
		if (rooms.length == 0)
			return;
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++)
			for (int j = 0; j < rooms[0].length; j++)
				if (rooms[i][j] == 0)
					que.add(new int[] { i, j });

		while (!que.isEmpty()) {
			int[] location = que.poll();
			int x = location[0];
			int y = location[1];
			if (x < rooms.length - 1 && rooms[x + 1][y] != -1 && rooms[x + 1][y] > rooms[x][y]) {
				rooms[x + 1][y] = rooms[x][y] + 1;
				que.add(new int[] { x + 1, y });
			}
			if (y < rooms[0].length - 1 && rooms[x][y + 1] != -1 && rooms[x][y + 1] > rooms[x][y]) {
				rooms[x][y + 1] = rooms[x][y] + 1;
				que.add(new int[] { x, y + 1 });
			}
			if (x > 0 && rooms[x - 1][y] != -1 && rooms[x - 1][y] > rooms[x][y]) {
				rooms[x - 1][y] = rooms[x][y] + 1;
				que.add(new int[] { x - 1, y });
			}
			if (y > 0 && rooms[x][y - 1] != -1 && rooms[x][y - 1] > rooms[x][y]) {
				rooms[x][y - 1] = rooms[x][y] + 1;
				que.add(new int[] { x, y - 1 });
			}
		}
	}
}
