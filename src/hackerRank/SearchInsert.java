package hackerRank;

/**
 * @author Piyush Chaudhary
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 *
 */
public class SearchInsert {
	
	 public static int searchInsert(int[] nums, int target) { // O(log n)
	        int start = 0;
	        int end = nums.length;
	        
	        while(start < end) {
	            
	            int mid = (start + end) / 2;
	            if(nums[mid] < target)
	                start = mid + 1;
	            else
	                end = mid;
	        }
	        return start;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,2,3},4));
	}

}
