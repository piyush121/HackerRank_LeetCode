/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 */
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) { // Good solution but
															// not very optimal.
		if (nums.length == 0)
			return null;
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> answer = new ArrayList<>();
			for (List<Integer> list : result) {
				List<Integer> second = new ArrayList<>(list);
				second.add(nums[i]);
				answer.add(second);

			}
			result.addAll(answer);

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 3, 2, 1 }));

	}

}
