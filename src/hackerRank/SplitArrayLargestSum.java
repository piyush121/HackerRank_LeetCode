/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤
 * 14,000.
 * 
 * Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 *
 */
public class SplitArrayLargestSum {

	public int splitArray(int[] nums, int m) { // Highly efficient and tricky
												// solution! O(nlogn) time.
		int max = -1;
		long sum = 0L;
		for (int val : nums) {
			if (val > max)
				max = val;
			sum += val;
		}
		if (m == 1)
			return (int) sum;
		return binarySearch(nums, max, sum, m);
	}

	private int binarySearch(int[] nums, long start, long end, int m) {
		long mid = 0L;

		while (start < end) {
			mid = (start + end) / 2;
			if (isValid(nums, mid, m)) { // check this val.
				end = mid; // This val worked so we might found smaller minimum
							// sum which is also the max.
			} else
				start = mid + 1;
		}

		return (int) end;
	}

	private boolean isValid(int[] nums, long max, int m) { // Check if you can
															// use this value to
															// make m subarrays
															// each having sum
															// <= this val.
		int curr = 0;
		int count = 1;
		for (int val : nums) {
			curr += val;
			if (curr > max) {
				curr = val;
				count++;
				if (count > m)
					return false;
			}
		}
		return true;
	}

	public int splitArray1(int[] nums, int m) { // Inefficient Solution.
		int[] DP = new int[nums.length + 1];
		DP[0] = 0;
		for (int i = 0; i < nums.length; i++)
			DP[i + 1] = DP[i] + nums[i];
		return splitArray(nums, 0, m, Integer.MAX_VALUE, DP);
	}

	private int splitArray(int[] nums, int start, int m, int minMaxSum, int[] DP) {
		if (m == 1) {
			return DP[nums.length] - DP[start];
		}
		for (int i = start; i <= nums.length - m; i++) {
			int currSum = DP[i + 1] - DP[start];
			if (currSum >= minMaxSum) { // break early.
				break;
			}
			int getSum = splitArray(nums, i + 1, m - 1, minMaxSum, DP);
			int sum = Math.max(currSum, getSum);
			minMaxSum = Math.min(minMaxSum, sum);
		}
		return minMaxSum;
	}
}
