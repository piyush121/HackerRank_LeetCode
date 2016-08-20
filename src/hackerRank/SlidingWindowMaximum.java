/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left 
 * of the array to the very right. You can only see the k numbers in the window. Each time the 
 * sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

1. How about using a data structure such as deque (double-ended queue)?
2. The queue size need not be the same as the window’s size.
3. Remove redundant elements and the queue should store only elements that need to be considered.
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {// Very good ques. Felt better after doing it.
        if(nums.length == 0 || k > nums.length)
            return new int[0];
        Deque<Integer> que = new LinkedList<Integer>();
		int[] res = new int[nums.length - k + 1];
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			
			if (!que.isEmpty() && que.peek() < i - k + 1)
				que.poll();// Remove the top element only if its less than the window.
			
			while (!que.isEmpty() && nums[que.peekLast()] < nums[i])
				que.removeLast();// Remove from last because we want the next biggest element to be on top and these elements are useless coz they will never become max in that window.
			que.offer(i); // We should store the index of the element because that way you can track whether the peek element lies within the window or not.
			
			if ( i >= k - 1) {
			res[idx] = nums[que.peek()];
			idx++;
			}
			
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
