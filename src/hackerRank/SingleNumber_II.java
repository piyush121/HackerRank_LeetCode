/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 *
 */
public class SingleNumber_II {
	public int singleNumber(int[] nums) { // Toughie.
		int ones = 0;
		int twos = 0;
		int mask = 0;

		for (int i = 0; i < nums.length; i++) {
			twos  = twos | (ones & nums[i]);
			ones ^= nums[i]; // numbers which appear 3 times will stay in ones.
			mask = ~(ones & twos);
			ones &= mask; // remove numbers which have appeared thrice.
			twos &= mask;
		}
		
		return ones;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
