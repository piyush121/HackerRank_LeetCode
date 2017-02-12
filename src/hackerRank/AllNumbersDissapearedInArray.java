/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 *
 */
public class AllNumbersDissapearedInArray {
	public List<Integer> findDisappearedNumbers(int[] nums) { // O(n) time and constant space.
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0)
			return res;
		for (int num : nums) {
			int realNum = Math.abs(num);
			nums[realNum - 1] = -1 * Math.abs(nums[realNum - 1]);
		}

		for (int i = 0; i < nums.length; i++)
			if (nums[i] > 0)
				res.add(i + 1);
		return res;
	}
}
