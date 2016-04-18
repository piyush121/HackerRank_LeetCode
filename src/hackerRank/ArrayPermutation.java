package hackerRank;

import java.util.LinkedList;
import java.util.List;

public class ArrayPermutation {
	 public static  List<List<Integer>> permute(int[] nums) {
	        return permute (nums, -1, new LinkedList<Integer>());
	    }
	 
	 public static List<List<Integer>> permute(int[] nums,int skipIndex, List<Integer> perms) {
		 
		 List<List<Integer>> result = new LinkedList<>();

		 if(perms.size() == nums.length) {
			 result.add(perms);
			 return result;
		 }
		 
		 for(int i = 0; i < nums.length; i++) {
			 if(i == skipIndex)
				 continue;
			 perms.add(nums[i]);
			 result = permute(nums,i, perms );
			 if( i != nums.length - 1)
				 result.add(new LinkedList<>());
		 }	
		 
		 return result;
	 }
	 
	 public static void main(String[] args) {
		 
		 int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}
	 

}
