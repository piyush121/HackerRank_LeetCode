/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array with all positive numbers and no duplicates, find the number of possible 
 * combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?


 *
 */
public class CombinationSum_IV {
	public int combinationSum4(int[] nums, int k) { // dfs based approach. Gets Timed out. exponential.
        if(k == 0)
            return 1;
        if(k < 0)
            return 0;
        int count = 0;
        for(int i = 0 ; i < nums.length; i++) {
            count += combinationSum4(nums, k - nums[i]);
        }
        return count;
    }
	
	public int combinationSum4_1(int[] nums, int target) { // Memoized dfs based solution. Its fast !
        if(nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(nums, target, map);
    }
    public int dfs(int[] nums, int k, Map<Integer, Integer> map) {
        if(k == 0)
            return 1;
        if(k < 0)
            return 0;
        if(map.containsKey(k))
            return map.get(k);
        int count = 0;
        for(int i = 0 ; i < nums.length; i++) {
            count += dfs(nums, k - nums[i], map);
        }
        map.put(k, count);
        return count;
    }
    
    public int combinationSum4_2(int[] nums, int target) { // Bottom up DP approach.
        if(nums.length == 0)
            return 0;
        int[] DP = new int[target + 1];
        DP[0] = 1;
        for(int sum = 1 ; sum < DP.length; sum++) {
            for(int j = 0; j < nums.length; j++ ) {
                if(sum - nums[j] >= 0)
                    DP[sum] += DP[sum - nums[j]];
                    
            }
        }
        return DP[target];
    }
}
