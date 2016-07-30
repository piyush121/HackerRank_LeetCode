/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 *
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) { // Iterative one. Concept is the same.
		int start = 0;
		int end = nums.length - 1;

		while (start != end) {
			int mid = start + (end - start) / 2;
			if (nums[start] < nums[end])
				return nums[start];
			if (nums[mid] >= nums[start])
				start = mid + 1;
			else
				end = mid;
		}

		return nums[start];
	}

	public int findMin1(int[] nums) { // Easy one. But if you get stuck
										// somewhere, then its hard to come back
										// without a refreshing drink :D
		return (helper(nums, 0, nums.length - 1));
	}

	private int helper(int[] nums, int start, int end) { // Recursive solution.
		if (start == end)
			return nums[start];
		if (nums[start] < nums[end]) // check if array is already sorted.
			return nums[start];

		int mid = (start + end) / 2;

		if (nums[mid] >= nums[start]) {
			return helper(nums, mid + 1, end);
		}

		else {
			return helper(nums, start, mid);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
