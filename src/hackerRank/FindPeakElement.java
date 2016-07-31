/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 *
 * 
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) { // O(logN) time and O(1) space.
		int low = 0;
		int high = nums.length - 1;

		while (low + 1 < high) { // To keep last two elements.
			int mid = low + (high - low) / 2;

			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;
			if (nums[mid] > nums[mid - 1])
				low = mid + 1;
			else
				high = mid;
		}
		if (nums[low] > nums[high]) // The larger ine is the answer. makes sense if you think about corner cases.
			return low;
		return high;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
