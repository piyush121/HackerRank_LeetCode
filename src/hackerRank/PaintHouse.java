/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 *
 */
public class PaintHouse {
	public int minCost(int[][] costs) { // O(n)time and apce.
		if (costs.length == 0)
			return 0;
		int[][] DP = new int[costs.length][costs[0].length];
		for (int i = 0; i < 3; i++)
			DP[0][i] = costs[0][i];
		int len = costs.length;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 3; j++) { // -1 % 3 = -1 is Java. damn !
				DP[i][j] = costs[i][j] + Math.min(DP[i - 1][(j + 1) % 3], DP[i - 1][(j - 1) % 3 < 0 ? 2 : (j - 1) % 3]);
			}
		}

		return Math.min(Math.min(DP[len - 1][0], DP[len - 1][1]), DP[len - 1][2]);
	}
}
