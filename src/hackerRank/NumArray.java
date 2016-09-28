/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**Range Sum Query - Immutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 *
 */
public class NumArray {
	 int[] DP;
	 public NumArray(int[] nums) { // easy peezy.
	        DP = new int[nums.length];
	        if(nums.length > 0)
	        	DP[0] = nums[0];
	        for(int i = 1 ; i < nums.length; i++)
	        	DP[i] = DP[i - 1] + nums[i];
	        	
	    }

	 public int sumRange(int i, int j) {
	        if(i == 0)
	    		return DP[j];
	    	if(i == j)
	    	    return DP[i] - DP[i-1];
	        return DP[j] - DP[i - 1];
	    }
	}


	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);