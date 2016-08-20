/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int left = 1;
		int[] output = new int[nums.length];
		output[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left *= nums[i - 1];
			output[i] = left;
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			output[i] *= right;
			right *= nums[i];
		}

		return output;
	}
}
