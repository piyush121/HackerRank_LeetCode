/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by 
 * array nums. You are asked to burst all the balloons. If the you burst balloon i you will get 
 * nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. 
	After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 */
public class BurstBalloons {
	public int maxCoins(int[] nums) { // Divide and conquer approach. O(N^3) runtime.
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int[] iNums = new int[n + 2];
		iNums[0] = 1;
		for (int i = 0; i < nums.length; i++)
			iNums[i + 1] = nums[i];
		iNums[iNums.length - 1] = 1;
		int[][] memo = new int[n + 2][n + 2];

		return maxCoin(memo, iNums, 1, n);
	}

	public int maxCoin(int[][] memo, int[] iNums, int start, int end) {
		if (start > end) // usual base case.
			return 0;
		if (memo[start][end] > 0) // check memory.
			return memo[start][end];
		int max = 0;
		for (int i = start; i <= end; i++) {
			int res = iNums[start - 1] * iNums[i] * iNums[end + 1] + maxCoin(memo, iNums, i + 1, end)
					+ maxCoin(memo, iNums, start, i - 1); // find total value if
															// this balloon was
															// the last one to
															// burst.
			if (res > max)
				max = res;
		}
		memo[start][end] = max;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(maxCoins(new int[]{3,1}));
	}

}
