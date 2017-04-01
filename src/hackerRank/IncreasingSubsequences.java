/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.*;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 *
 */
public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		findSubsequences(nums, res, new ArrayList<>(), 0);
		return res;
	}

	public void findSubsequences(int[] nums, List<List<Integer>> res, List<Integer> temp, int pos) {
		if (temp.size() >= 2)
			res.add(new ArrayList<>(temp));
		Set<Integer> seen = new HashSet<>(); // Avoid duplicates.
		for (int i = pos; i < nums.length; i++) {
			int val = nums[i];
			if (!seen.contains(val)) {
				if (temp.size() == 0 || temp.get(temp.size() - 1) <= val) {
					seen.add(val);
					temp.add(val);
					findSubsequences(nums, res, temp, i + 1);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
}
