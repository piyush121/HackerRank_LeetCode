/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 *
 */
public class SearchRotatedSortedArray_II {

	public static boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;
		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) / 2;

		while (low < high) {
			if (mid == target)
				return true;
			if (nums[low] < nums[mid]) { // left half
											// sorted.
				if (target < nums[mid] && target >= nums[low])
					high = mid - 1;
				else
					low = mid + 1;
			} else if (nums[mid] < nums[high]) { // right half sorted.
				if (target > nums[mid] && target <= nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
			else
				low++;
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(search(new int[] {5,5,1,1,2,3,4,4,4}, 5));

	}

}
