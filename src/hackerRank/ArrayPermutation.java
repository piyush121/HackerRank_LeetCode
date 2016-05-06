package hackerRank;

import java.util.LinkedList;
import java.util.List;

public class ArrayPermutation {
	 public static  List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> result = new LinkedList<>();
	         permute (nums, 0, result);
	         return result;
	    }
	 
	 public static void permute(int[] nums, int start, List<List<Integer>> result) {
		 
		 if( start == nums.length -1) {
			 List<Integer> list = new LinkedList<Integer>();
		        for(int i=0;i<nums.length;i++){
		            list.add(nums[i]);
		        }
		        result.add(list);
		        return;
		 }
		 
		 for(int i = start; i < nums.length; i++) {
			 swap(nums, start, i);
			 permute(nums, start + 1, result );
			 swap(nums, start, i);
		 }
		 
		 
	 }
	 
	 public static void swap (int[] nums, int i, int j) {
		 int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
	 }
	 
	 public static void main(String[] args) {
		 
		 int[] nums = {1,2,3,4};
		System.out.println(permute(nums));
	}
	 

}
