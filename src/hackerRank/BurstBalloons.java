/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by 
 * array nums. You are asked to burst all the balloons. If the you burst balloon i you will get 
 * nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. 
	After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 */
public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				map.put(nums[i], new int[] { 1, nums[i + 1] });
			else if (i == nums.length - 1)
				map.put(nums[i], new int[] { nums[i - 1], 1 });
			else
				map.put(nums[i], new int[] { nums[i - 1], nums[i + 1] });
		}
		return maxCoin(map, nums, 0, nums.length - 1);

	}

	public int maxCoin(Map<Integer, int[]> map, int[] nums, int start, int end) {
		if (start > end)
			return 0;
		int max = 0;
		for (int i = start; i <= end; i++) {
			int res = 0;
			int left = map.get(nums[i])[0];
			int right = map.get(nums[i])[1];
			res += left * nums[i] * right;
			map.get(left)[1] = right;
			map.get(right)[0] = left;
			res += maxCoin(map, nums, start + 1, end);
			res += maxCoin(map, nums, start, i - 1);
			map.get(left)[1] = nums[i];
			map.get(right)[0] = nums[i];
			if (res > max)
				max = res;
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
