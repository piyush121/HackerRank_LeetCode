package hackerRank;

/*
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
 */
public class PaintFence {
	public int numWays(int n, int k) { // More of a math based ques. 
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		int same = k; // if you chose the same color as previous.
		int diff = k * (k - 1); // if diff. color os chosen.
		for (int i = 2; i < n; i++) {
			int temp = diff;
			diff = (k - 1) * (diff + same);
			same = temp;
		}

		return same + diff;
	}
}
