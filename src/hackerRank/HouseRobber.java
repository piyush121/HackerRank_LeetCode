/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class HouseRobber {
	public int rob(int[] nums) { // Gone in 1st attempt. Easy one.
		if(nums.length == 0)
			return 0;
		int[] DP = new int[nums.length + 1];
		DP[1] = nums[0];
		for(int i = 2; i < DP.length; i++) 
			DP[i] = Math.max(DP[i - 1], nums[i - 1] + DP [i - 2]);
			
		
		return DP[nums.length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
