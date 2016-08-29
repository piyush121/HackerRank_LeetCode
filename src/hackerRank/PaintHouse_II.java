/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import javax.annotation.processing.ProcessingEnvironment;

/**
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 * 
 * Follow up: Could you solve it in O(nk) runtime?
 *
 */
public class PaintHouse_II {
	public int minCostII(int[][] costs) { // Hard one. But worth the time spent !
		if (costs.length == 0)
			return 0;
		int prevMin = -1; // keep last two minimum value indices.
		int prevMin2 = -1;
		int currMin = -1;
		int currMin2 = -1;
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < costs[0].length; j++) {
				if (j != prevMin)
					costs[i][j] += prevMin < 0 ? 0 : costs[i - 1][prevMin];
				// You need to have a focused mind to play with indexes here.
				else
					costs[i][j] += prevMin2 < 0 ? 0 : costs[i - 1][prevMin2];

				if (currMin < 0 || costs[i][j] < costs[i][currMin]) {
					currMin2 = currMin;
					currMin = j;
				} else if (currMin2 < 0 || costs[i][j] < costs[i][currMin2]) {
					currMin2 = j;
				}

			}
			prevMin = currMin;
			prevMin2 = currMin2;
			currMin = -1;
			currMin2 = -1;
		}

		return costs[costs.length - 1][prevMin];
	}
}
