package hackerRank;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	static List<List<Integer>> result = new LinkedList<>();
	
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 
		 combinationSum(candidates, target, new LinkedList<Integer>(), 0);
	     return result;
	    }
	 
	 public static void combinationSum(int[] candidates, int target, List<Integer> list, int sum) {// Highly inefficient recursive solution.
		 
		 if ( sum == target ) {
			 result.add(new LinkedList<>(list));
			 return;
		 }
		 if(sum > target) {
			 return;
		 }
		 
		 for(int i = 0; i < candidates.length; i++) {
			 combinationSum(candidates, target, list, sum + candidates[i]);
		 }
	 }

}
