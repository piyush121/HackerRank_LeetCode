/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 *
 * 
 */
public class FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int start = 1;
		int end = nums.length;
		int mid = 0;
		while (start != end) {
			int count = 0;
			mid = (start + end) / 2;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid)
					count++; 
			}
			if (count <= mid) // this side is fine. usual or less than usual elements are present this side.
				start = mid + 1;
			else // more than allowed elements are present this side.
				end = mid;
		}

		return start;
	}
}
