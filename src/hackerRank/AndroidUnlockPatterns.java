/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total 
 * number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum
 *  n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other 
keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.


 *
 */
public class AndroidUnlockPatterns {
	public int numberOfPatterns(int m, int n) { // tough one. DFS approach.
		int[][] jump = new int[10][10];

		jump[1][3] = jump[3][1] = 2; // find which numbers should be visited if you
		jump[1][7] = jump[7][1] = 4; // want to jump from i -> j.
		jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;
		jump[2][8] = jump[8][2] = 5;
		jump[4][6] = jump[6][4] = 5;
		jump[7][9] = jump[9][7] = 8;
		jump[3][9] = jump[9][3] = 6;

		boolean[] visited = new boolean[10];
		int res = 0;

		res += dfs(visited, m, n, 1, 1, 0, jump) * 4; // 1, 3, 7, 9
		res += dfs(visited, m, n, 1, 2, 0, jump) * 4; // 2, 4, 6, 8
		res += dfs(visited, m, n, 1, 5, 0, jump); // 5
		return res;
	}

	public int dfs(boolean[] visited, int m, int n, int len, int curr, int res, int[][] jumps) {
		if (len >= m)
			res++;
		if (len >= n)
			return res;

		visited[curr] = true;
		for (int i = 1; i < 10; i++) {
			int num = jumps[curr][i];
			if (!visited[i] && (num == 0 || visited[num])) {
				res = dfs(visited, m, n, len + 1, i, res, jumps);
			}
		}
		visited[curr] = false; // backtracking.

		return res;
	}
}
