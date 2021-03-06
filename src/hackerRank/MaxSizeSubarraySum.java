/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 *
 */
public class MaxSizeSubarraySum {
	public int maxSubArrayLen(int[] sums, int k) { // O(N) time and space. Hard one though.
        if(sums.length == 0)
            return 0;
        for(int i = 1 ; i < sums.length; i++) 
            sums[i] += sums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        map.put(0, -1); // keep things consistent. If sum becomes 0 again in between then its better to take the sum from the start.
        for(int i = 0; i < sums.length; i++) {
            if(map.containsKey(sums[i] - k))
                max = Math.max(max, i - map.get(sums[i] - k));
            if(!map.containsKey(sums[i]))
                map.put(sums[i], i);
        }
        
        return max;
    }
}
