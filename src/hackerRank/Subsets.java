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
	public static List<List<Integer>> subsets(int[] nums) { // Good solution but not very optimal.
		if (nums.length == 0)
			return null;
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> first = new ArrayList<Integer>();
		first.add(nums[0]);
		result.add(first);
		for (int i = 1; i < nums.length; i++) {
			List<Integer> temp = new ArrayList<>();
			List<List<Integer>> answer = new ArrayList<>();
			temp.add(nums[i]);
			answer.add(temp);
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
