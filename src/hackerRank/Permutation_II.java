package hackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *	For example,
 *	[1,1,2] have the following unique permutations:
 *	[1,1,2], [1,2,1], and [2,1,1].
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class Permutation_II {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> permutations = permute(nums, 0, new LinkedList<List<Integer>>());
		return permutations;
	}

	private static List<List<Integer>> permute(int[] arr, int start, List<List<Integer>> result) {
		if (start == arr.length) {
			List<Integer> temp = new LinkedList<Integer>();

			for (int val : arr) {
				temp.add(val);
			}
			result.add(temp);
			return result;
		}

		else {
			HashSet<Integer> seen = new HashSet<>();
			for (int i = start; i < arr.length; i++) {

				if (seen.add(arr[i])) {
				swap(arr, i, start);
				permute(arr.clone(), start + 1, result);
				swap(arr, i, start);
				}
			}

		}

		return result;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 0, 1, 0, 0, 9 };
		System.out.println(permuteUnique(array));
	}

}
