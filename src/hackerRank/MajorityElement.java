/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int curr = nums[0]; 
		int count = 1;

		for (int i = 1; i < nums.length; i++) { // Also known as Moore's Voting algorithm.
			if (nums[i] == curr) {
				count++;
				continue;
			}
			if (nums[i] != curr)
				count--;
			if (count == 0) {
				curr = nums[i];
				count = 1;
			}

		}

		return curr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
