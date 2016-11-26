/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned 
 * into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSubsetSum {
	
	public boolean canPartition(int[] nums) { // DP based solution. O(n) space and time.
		if (nums.length == 0)
			return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 != 0)
			return false;
		sum /= 2; // we need to make this exact sum from given values.
		boolean[] DP = new boolean[sum + 1];
		DP[0] = true;
		for (int num : nums) {
			for (int currSum = sum; currSum >= num; currSum--)
				DP[currSum] = DP[currSum] || DP[currSum - num]; // currSum might already be true by some previous value because the array is not sorted. 
				//If sum is 1- and we have seen 9 before and when we do currSum-- to make 9 on 7 then we haven't seen 3 before and it will set it to false which is wrong.
				//So we can either use the currSum or  not.
		}
		return DP[sum];
	}
	
	public boolean canPartition1(int[] nums) {
		if (nums.length == 0)
			return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		return dfs(nums, 0, sum);
	}

	public boolean dfs(int[] nums, int start, int sum) { // DFS approach.
															// Exponential. Not
															// efficient at all
															// !
		if (sum == 0)
			return true;
		if (start == nums.length)
			return false;

		for (int i = start; i < nums.length; i++) {
			if (dfs(nums, i + 1, sum - nums[i]))
				return true;
		}
		return false;
	}
}
