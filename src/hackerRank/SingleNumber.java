/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 * 
 * 
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int val = nums[0];
		for (int i = 1; i < nums.length; i++) { // Basically can be solved in O(N) using XOR.Easy one.
			val = val ^ nums[i];
		}

		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
