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
	public int findMin(int[] nums) { // Easy one. But if you get stuck
										// somewhere, then its hard to come back
										// without a refreshing drink :D
		return (helper(nums, 0, nums.length - 1));
	}

	private int helper(int[] nums, int start, int end) {
		if (start >= end)
			return nums[start];
		int mid = (start + end) / 2;
		int min = Integer.MAX_VALUE;

		if (nums[mid] >= nums[start]) {
			int left = nums[start];
			int right = helper(nums, mid + 1, end); // mid can never be the
													// least element in this
													// case.
			min = Math.min(left, right);

		}

		else {
			int left = helper(nums, start, mid - 1);
			int right = nums[mid];
			min = Math.min(left, right);
		}

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
