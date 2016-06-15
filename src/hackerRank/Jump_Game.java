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

		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1)
				return true;
			--curr;
			if (curr < nums[i])
				curr = nums[i];
			if (curr == 0)
				return false;

		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}
}
