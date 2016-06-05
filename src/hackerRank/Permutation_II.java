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
	    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		List<List<Integer>> permutations = permute(nums, 0, result);
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

		for (int i = start; i < arr.length; i++) {

				if (i != start && arr[i] == arr[start]) 
					continue;
				swap(arr, i, start);
				permute(arr.clone(), start + 1, result); // Passing by reference will disturb the sorted sequence. Very DEEP concept here!
			//	swap(arr, i, start); 
				
			}
		

		return result;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 2,1,2,3 };
		System.out.println(permuteUnique(array));
	}

}







class Solution { // Slow solution but still works
    public  List<List<Integer>> permuteUnique(int[] nums) {
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
	permute(nums, 0, result);
    return result;
    }

private void permute(int[] arr, int start, List<List<Integer>> result){
	if(start >= arr.length) {
		List<Integer> temp = new LinkedList<>();

		for (int val: arr) {
			temp.add(val);
		}
		result.add(temp);
		return;
	}
	
	HashSet<Integer> seen = new HashSet<>(); // to check whether we are swapping the already seen numbers or not.
		for (int i = start; i < arr.length; i++) {
			if (seen.add(arr[i])) {
			swap(arr, i, start);
			permute(arr.clone(), start + 1, result);
			swap(arr, i, start); //This extra swap call is expensive than constructing a whole new array and passing it.
			}
		}
		
	return;
}

private  void swap (int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
	
	
}
}

/*
 *  The reason of sorting is to skip duplicates. Take [1, 2, 2, 3] for example, when pos equals 0, we have below cases

(1,2,2,3) (pos = 0, i = 0)

(2,1,2,3) (pos = 0, i = 1)

(2,1,2,3) (pos = 0, i =2) skipped, since array[0]=array[2]; in other words, its subset (1,2,3) is the same as the second case (pos = 0, i=1)

(3,1,2,2) (pos = 0, i =3)

As we can see, the subset of the above four cases are still sorted. Amazing! Recursion continues.

On the other hand, if we use pass-by-reference, the set are ALWAYS sorted AFTER the extra swap, as below. The above amazing trick doesn’t work and duplicates won’t be avoided. So, the result of pass-by-reference algorithm is not correct.

(1,2,2,3) (pos = 0, i = 0)

(1,2,2,3) (pos = 0, i = 1)

(1,2,2,3) (pos = 0, i =2)

(1,2,2,3) (pos = 0, i =3)
*/
