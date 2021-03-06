package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class RemoveElementInPlace { // LeetCode problem 27.

	public int removeElement(int[] nums, int val) { // O(n) space.
		if (nums.length == 0)
			return 0;
		int j = nums.length;
		for (int i = nums.length - 1; i >= 0; i--) { // put every non-repeating in th front.
			if (nums[i] == val) {
				j--;
				swap(nums, i, j);
			}
		}
		return j;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
