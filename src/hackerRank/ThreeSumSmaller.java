/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1] [-2, 0, 3]
 *
 */
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) { // O(n^2)
		if (nums.length == 0) // Got confused between the actual 3 sum problem and this one. Very similar yet so dissimilar !
			return 0;
		int res = 0;
		Arrays.sort(nums);
		int start = 0;
		while (start < nums.length - 2) {
			int curr = start + 1;
			int end = nums.length - 1;
			while (curr < end) {
				if (nums[curr] + nums[start] + nums[end] < target) {
					res += end - curr; // Since we know that all the elements from curr to end will be a valid triplet.
					curr++;				// Doesnt matter if ther are duplicate elements.
				} else
					end--;
			}
			start++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new ThreeSumSmaller().threeSumSmaller(new int[] { 0, -2, 1, 1, 2 }, 1));
	}
}
