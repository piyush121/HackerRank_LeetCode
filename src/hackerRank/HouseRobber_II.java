/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class HouseRobber_II {
	public int rob(int[] nums) { // Now that's a O(1) space and O(n) time solution.
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));

	}

	private int rob(int[] nums, int low, int high) {
		int prevRobbed = 0;
		int prevDidntRobbed = 0;
		int currRobbed = 0;
		int currDidntRobbed = 0;

		for (int i = low; i <= high; i++) {
			currRobbed = nums[i] + prevDidntRobbed; // If we rob this house then we cannot rob previous house. Makes sense, right ?
			currDidntRobbed = Math.max(prevRobbed, prevDidntRobbed); // If we don't rob this house then we are not sure we should rob the previous house or not.
			prevRobbed = currRobbed;
			prevDidntRobbed = currDidntRobbed;
		}

		return Math.max(currRobbed, currDidntRobbed);
	}

	public int rob1(int[] nums) { // Good solution. O(n) space and time but space
									// can still be reduced to O(1).
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int max = 0;
		int[] DP = new int[nums.length];
		DP[0] = nums[0];
		DP[1] = DP[0];
		for (int i = 2; i < nums.length - 1; i++) {
			DP[i] = Math.max(DP[i - 1], nums[i] + DP[i - 2]);
		}
		max = DP[DP.length - 1];

		DP = new int[nums.length]; // Went off the rack here.
		DP[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			DP[i] = Math.max(DP[i - 1], nums[i] + DP[i - 2]);
		}

		return Math.max(max, DP[DP.length - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
