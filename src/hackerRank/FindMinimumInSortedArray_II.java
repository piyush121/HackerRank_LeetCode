/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 *
 */
public class FindMinimumInSortedArray_II {
	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low != high) {
			int mid = low + (high - low) / 2;
			if (nums[low] < nums[high]) // Check if this part is sorted or not.
				return nums[low];
			if (nums[mid] == nums[low]) {
				while (nums[mid] == nums[low] && low != mid + 1) { // increase low till mid + 1.
					low++;
				}
				continue;
			}

			if (nums[low] > nums[mid]) // Usual BiSearch.
				high = mid;
			else
				low = mid + 1;
		}
		return nums[low];
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 1, 1, 2, 3, 1 }));
	}

}
