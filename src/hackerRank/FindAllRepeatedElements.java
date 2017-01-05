/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 *
 */
public class FindAllRepeatedElements { // Famous one!
	 public List<Integer> findDuplicates(int[] nums) { // O(n) time, O(1) space.
		List<Integer> list = new ArrayList<>();
		if (nums.length == 0)
			return list;

		for (int i = 0; i < nums.length; i++) {
			int curr = Math.abs(nums[i]);
			if (nums[curr - 1] < 0)
				list.add(curr);
			else
				nums[curr - 1] *= -1;
		}

		return list;
	    }
}
