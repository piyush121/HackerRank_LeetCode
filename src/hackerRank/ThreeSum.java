package hackerRank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Piyush Chaudhary
 *
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length == 0)
			return new LinkedList<List<Integer>>();
		LinkedList<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int curr = start + 1;
		while (start <= end - 2) { // because no point going further than that.
			curr = start + 1;
			while (curr < end) {
				if (nums[start] + nums[curr] + nums[end] == 0) { // add to the result set.
					LinkedList<Integer> list = new LinkedList<>();
					list.add(nums[start]);
					list.add(nums[curr]);
					list.add(nums[end]);
					result.add(list);
					while (nums[curr + 1] == nums[curr] && curr < end - 1)
						curr++;
					curr++;

				} else if (nums[start] + nums[curr] + nums[end] < 0)
					curr++;
				else {
					while (nums[end - 1] == nums[end] && end > start + 1)
						end--;
					end--;
				}
			}
			while (nums[start + 1] == nums[start] && start < end - 1) // increment until you don't see same value again.
				start++;
			start++;
			end = nums.length - 1; // reset end back to last value so that when
									// it goes to outer loop the end location is
									// correct.

		}
		return result;
	}

	
	public static void main(String[] args) {
		int[] arr = { -1, -1, 0, 1, 1, 2, 2, 4 };
		int[] arr1 = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		int[] arr2 = { -5, -5, -4, -3, -2, 0, 2, 2 };

		System.out.println(threeSum(arr2));

	}

}
