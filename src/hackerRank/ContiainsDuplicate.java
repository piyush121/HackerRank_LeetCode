/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 */
public class ContiainsDuplicate {
	public boolean containsDuplicate(int[] nums) { // O(nlogn) time and O(1)
													// space
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				return true;
		}

		return false;
	}

	public boolean containsDuplicate1(int[] nums) { // O(n) space and time.
		Set<Integer> seen = new HashSet<>();

		for (int num : nums) {
			if (seen.contains(num))
				return true;
			seen.add(num);
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
