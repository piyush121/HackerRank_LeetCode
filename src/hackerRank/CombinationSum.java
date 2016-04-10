package hackerRank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	static List<List<Integer>> result = new LinkedList<>();
	
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 Arrays.sort(candidates); // O(nlog n)
		 combinationSum(candidates, target, new LinkedList<Integer>(), 0, 0);
	     return result;
	    }
	 
	 public static void combinationSum(int[] candidates, int target, List<Integer> list, int sum, int index) {//O(n^3). Highly inefficient recursive solution.
		 
		 if ( sum == target ) {
			 result.add(new LinkedList<>(list));
			 return;
		 }
		 else if(sum > target) {
			 return;
		 }
		 
		 for(int i = index; i < candidates.length; i++) {
			 list.add(candidates[i]);
			 combinationSum(candidates, target, list, sum + candidates[i], i);
			 list.remove(list.size() - 1);
		 }
	 }
	 public static void main(String[] args) {
		int[] arr = {2,3,6,7};
		System.out.println(combinationSum(arr, 7));
	}
}
