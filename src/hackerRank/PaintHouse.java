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
	public int minCost(int[][] costs) { // O(n)time and space.
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

	public int minCost1(int[][] costs) { // O(1) space. But by abusing the
											// input.
		if (costs == null || costs.length == 0) {
			return 0;
		}
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
		}
		int n = costs.length - 1;
		return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
	}

	public int minCost2(int[][] costs) { // O(n) time and O(1) space without
											// abusing the input array.
		if (costs.length == 0)
			return 0;
		int[][] DP = new int[2][3];
		for (int i = 0; i < 3; i++)
			DP[0][i] = costs[0][i];
		int len = costs.length;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 3; j++) {
				DP[1][j] = costs[i][j] + Math.min(DP[0][(j + 1) % 3], DP[0][(j - 1) % 3 < 0 ? 2 : (j - 1) % 3]);
			}
			for (int k = 0; k < 3; k++)
				DP[0][k] = DP[1][k];
		}

		return Math.min(Math.min(DP[0][0], DP[0][1]), DP[0][2]);
	}
}
