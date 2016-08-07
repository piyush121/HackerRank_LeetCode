/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) { // O(n) space and O(1) time.
		if (nums.length == 0)
			return 0;
		int minSize = Integer.MAX_VALUE;
		int currSum = 0;
		int ptr = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (currSum >= s) {
				while (currSum - nums[ptr] >= s) {
					currSum -= nums[ptr]; // shrink the window until it is jus
											// the size of 's' preferable.
					ptr++;
				}
				if (minSize > i - ptr + 1)
					minSize = i - ptr + 1;
			}

		}
		return minSize;
	}

	// There also exists an NLogN solution, logN immediately reminds you of
	// binary search. In
	// this case, you cannot sort as the current order actually matters. How
	// does one get an ordered array then? Since all elements are positive, the
	// cumulative sum must be strictly increasing. Then, a subarray sum can
	// expressed as the difference between two cumulative sum. Hence, given a
	// start index for the cumulative sum array, the other end index can be
	// searched using binary search.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
