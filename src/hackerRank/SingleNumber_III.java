/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 *
 * 
 */
public class SingleNumber_III {
	public int[] singleNumber(int[] nums) {
		if (nums.length == 0)
			return new int[2];
		int[] res = new int[2];
		int xor = 0;
		for (int i = 0; i < nums.length; i++) // Those two numbers will differ in at least one bit.
			xor ^= nums[i]; // Find that bit.
		int temp = 1;
		while ((temp & xor) == 0)
			temp <<= 1; // Numbers with that bit as 0 will for a different group than those with 1 as that bit.
		for (int i = 0; i < nums.length; i++) {
			if((temp & nums[i]) == temp)
				res[0] ^= nums[i];
			else
				res[1] ^= nums[i];
		}
		return res;
	}
}
