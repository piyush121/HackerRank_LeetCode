package hackerRank;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		if(nums.length == 0 )
			return;
		int ptr = 0;
		while(ptr < nums.length && nums[ptr] != 0 ) // Find first zero.
			ptr++;
		for(int i = ptr; i < nums.length; i++) { // keep swapping because the current pointer will always 
			if(nums[i] != 0) {					// swap non zero number with the last seen zero.
				swap(nums, i, ptr);
				ptr++;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
