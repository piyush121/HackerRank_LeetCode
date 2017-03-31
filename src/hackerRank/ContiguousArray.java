/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 *
 */
public class ContiguousArray {
	// O(N) time and space. Requires some different sort of thinking. Need more
	// ques. like this.
	// Remember the value of every count. if it has been seen before then it
	// means that equal number of 1s and 0s have reached
	// since we saw that count value.
	public int findMaxLength(int[] nums) {
		int count = 0;
		int res = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				count--;
			else
				count++;
			if (!sumMap.containsKey(count))
				sumMap.put(count, i);
			res = Math.max(res, i - sumMap.get(count));
		}
		return res;
	}
}
