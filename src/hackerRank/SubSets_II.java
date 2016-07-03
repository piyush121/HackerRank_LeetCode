package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Piyush Chaudhary
 *
 */
import java.util.List;

/*Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class SubSets_II {
	public static List<List<Integer>> subsetsWithDup1(int[] nums) { // Good one.
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		result.add(set);
		if (nums.length == 0)
			return result;
		int dupCount = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			dupCount = 0;

			while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
				dupCount++;
				i++;
			}
			List<List<Integer>> copy = new ArrayList<>();
			for (int k = 0; k < result.size(); k++) {
				List<Integer> temp = new ArrayList<>(result.get(k)); // Many
																		// things
																		// going
																		// on
																		// here.
																		// Read
																		// carefully.
				for (int j = 0; j <= dupCount; j++) {
					temp.add(nums[i]);
					copy.add(new ArrayList<>(temp));
				}
			}
			result.addAll(copy);
		}
		return result;
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) { // Efficient
																	// one !
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		if (nums.length == 0)
			return result;
		Arrays.sort(nums);
		int start = 0;
		int prevSize = result.size();
		for (int i = 0; i < nums.length; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) // Key idea here ! If we want
													// to insert an element
													// which is a dup, we can
													// only insert it after the
													// newly inserted elements
													// from last step.
				start = prevSize;
			else {
				start = 0;
			}
			prevSize = result.size();

			for (int j = start; j < prevSize; j++) {
				List<Integer> temp = new ArrayList<>(result.get(j));
				temp.add(nums[i]);
				result.add(temp);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
	}

}