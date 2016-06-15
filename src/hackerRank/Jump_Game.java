package hackerRank;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class Jump_Game {
	public static boolean canJump(int[] nums) {
		int curr = nums[0];
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int temp = nums[i];
			if (--curr == len - 1 || i == len - 1)
				return true;
			//--curr;
			if (curr < temp)
				curr = temp;
			if (curr == 0)
				return false;

		}
		return false;

	}
	
	public static boolean canJumpEff(int[] nums) { //More efficient greedy version.
			int maxReach = 0;
			int i = 0;
			for(; i < nums.length && i <= maxReach; i++) {
				maxReach = Math.max(maxReach, i + nums[i]);
			}
			
			return  maxReach >= nums.length - 1;
	}


	public static void main(String[] args) {
		System.out.println(canJumpEff(new int[] {0,1}));
	}
}
