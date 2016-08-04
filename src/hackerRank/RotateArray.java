/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * [show hint]
 * 
 * Hint: Could you do it in-place with O(1) extra space? Related problem:
 * Reverse Words in a String II
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k) { // The official cool method to
											// rotate the array. O(n) time and O(1) space.
		int len = nums.length;
		int count = 0;
		int index = 0;
		
		for (int i = 0; i < nums.length;i++,index++) { 
			int prev = nums[i]; 
			while (count < len) {
				int temp = nums[(index + k) % len];
				nums[(index + k) % len] = prev; // put the element to its
				prev = temp; 					// appropriate location.
				index = (index + k) % len;
				count++;
				if(i == index) // needed because we don't want same index to be visited again.
					break;
			}
		}
	}

	public void rotate2(int[] nums, int k) { // O(n) time and space. Not so efficient but good to know.
		int[] arr = new int[nums.length];
		k = k % nums.length;

		for (int i = 0; i < nums.length; i++) {
			arr[(i + k) % nums.length] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = arr[i];
		}
	}

	public void rotate1(int[] nums, int k) { // Great way to rotate the array.
												// O(n) time. O1) space.
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1); // complete reversal.
		reverse(nums, 0, k - 1); // 1st part reversal.
		reverse(nums, k, nums.length - 1); // 2nd part reversal.

	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
