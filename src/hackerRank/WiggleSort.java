/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 * 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6,
 * 2, 5, 3, 4].
 *
 * Explanation : The final sorted nums needs to satisfy two conditions:
 * 
 * If i is odd, then nums[i] >= nums[i - 1];
 * 
 * If i is even, then nums[i] <= nums[i - 1].
 * 
 * The code is just to fix the orderings of nums that do not satisfy 1 and 2.
 */
public class WiggleSort {
	public void wiggleSort(int[] nums) { // Greedy solution. O(n)
		if (nums.length == 0)
			return;
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0 && nums[i] > nums[i - 1]) {
				swap(nums, i, i - 1);
			} else if (i % 2 == 1 && nums[i] < nums[i - 1]) {
				swap(nums, i, i - 1);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void wiggleSort1(int[] nums) { // O(nlogn)
		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 1; i += 2) {
			swap(nums, i, i + 1);
		}
	}
}
