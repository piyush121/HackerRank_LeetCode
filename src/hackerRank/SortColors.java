/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */

package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 */
public class SortColors {

	public static void sortColors1(int[] nums) { // Works but not efficient.
		int zero = 0;
		int one = 0;
		int two = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				zero++;
			else if (nums[i] == 1)
				one++;
			else
				two++;
		}

		for (int i = 0; i < nums.length; i++) {
			if (zero > 0 || one > 0 || two > 0) {
				if (zero > 0) {
					nums[i] = 0;
					zero--;
				} else if (one > 0) {
					one--;
					nums[i] = 1;
				} else {
					two--;
					nums[i] = 2;
				}
			}
		}
	}

	public static void sortColors(int[] nums) {//Amazingly Fast solution. Hard to understand though.
		int low = 0;
		int high = nums.length - 1;
		for (int i = 0; i <= high; i++) {

			while (nums[i] == 2 && i < high) {
				nums[i] = nums[high];
				nums[high] = 2;
				high--;
			}

			while (nums[i] == 0 && i > low) {
				nums[i] = nums[low];
				nums[low] = 0;
				low++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 0 };
		sortColors(arr);
		for (int i = 0; i < 3; i++)
			System.out.println(arr[i]);
	}

}
