package hackerRank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Piyush Chaudhary
 *
 */
public class CombinationSum2 { // no repetition allowed this time.

	static List<List<Integer>> result = new LinkedList<>();

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates); // O(nlog n)
		combinationSum2(candidates, target, new LinkedList<Integer>(), 0);
		return result;
	}

	public static void combinationSum2(int[] candidates, int target, List<Integer> list, int index) {// O(n^2).DFS.

		if (target == 0) {
			result.add(new LinkedList<>(list));
			return;
		} else if (target < 0) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSum2(candidates, target - candidates[i], list, i + 1);
			list.remove(list.size() - 1);
			while (i + 1 < candidates.length && candidates[i + 1] == candidates[i])
				i++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2 };
		System.out.println(combinationSum2(arr, 2));
			
	}
}
