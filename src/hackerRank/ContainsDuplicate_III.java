/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 *
 * 
 * 
 */
public class ContainsDuplicate_III {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { // Great
																				// TreeSet
																				// problem
																				// to
																				// practice.
		if (nums.length < 2)
			return false;
		TreeSet<Integer> tree = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				tree.remove(nums[i - k - 1]);
			Integer floor = tree.floor(nums[i] + t);
			Integer ceiling = tree.ceiling(nums[i] - t);

			if (floor != null && floor >= nums[i] || ceiling != null && ceiling <= nums[i])
				return true;
			tree.add(nums[i]);

		}
		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
