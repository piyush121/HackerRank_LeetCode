package hackerRank;

import java.util.Arrays;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence_I {
	public int lengthOfLIS(int[] nums) { // O(n^2) space and time.
        if(nums.length == 0)
            return 0;
        int[][] memo = new int[nums.length][nums.length];
        return lengthOfLIS(nums, -1, 0, memo);
    }

	public int lengthOfLIS(int[] nums, int prevIndex, int pos, int[][] memo) {
		if (pos == nums.length) {
			return 0;
		}
		int max = 0;
		if (memo[prevIndex + 1][pos] > 0)
			return memo[prevIndex + 1][pos];

		if (prevIndex < 0 || nums[pos] > nums[prevIndex]) {
			int next = lengthOfLIS(nums, pos, pos + 1, memo);
			max = Math.max(max, 1 + next);

		}
		max = Math.max(max, lengthOfLIS(nums, prevIndex, pos + 1, memo));
		memo[prevIndex + 1][pos] = max;
		return max;
	}
    
	public int lengthOfLIS1(int[] nums) { // DP way. O(n^2) time and On) space.
		if (nums.length == 0)
			return 0;
		int[] DP = new int[nums.length];
		int max = 0;
		Arrays.fill(DP, 1);
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					DP[i] = Math.max(DP[i], 1 + DP[j]);
			}
			max = Math.max(max, DP[i]);
		}
		return max;
	}
}
