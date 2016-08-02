/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) { // Divide and conquer method.
		return helper(nums, 0, nums.length - 1); //O(nlogn) though.
	}

	private int helper(int[] nums, int start, int end) {
		if (start == end)
			return nums[start];
		int mid = (start + end) / 2;
		int left = helper(nums, start, mid);
		int right = helper(nums, mid + 1, end);
		if (nums[left] == nums[right])
			return nums[left];
		int leftCount = 0;
		int rightCount = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == left)
				leftCount++;
			else if (nums[i] == right)
				rightCount++;
		}

		if (leftCount > rightCount)
			return left;
		return right;
	}

	public int majorityElement1(int[] nums) {
		int curr = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) { // Also known as Moore's Voting
												// algorithm.
			if (nums[i] == curr) {
				count++;
				continue;
			}
			if (nums[i] != curr)
				count--;
			if (count == 0) {
				curr = nums[i];
				count = 1;
			}

		}

		return curr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
