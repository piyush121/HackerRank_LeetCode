/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar 
 * height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * For example,
Given heights = [2,1,5,6,2,3],
return 10.
 *
 *
 *EDGE CASE : [4,2,0,3,2,5] . Run it on this test case.
 */ 

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) { // O(n) space and run time.
		if (heights.length == 0)
			return 0;
		int max = 0;
		int len = heights.length;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()])
				stack.push(i);
			else {
				while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
					int ht = heights[stack.pop()];
					max = Math.max(max, ht * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			int ht = heights[idx];
			max = Math.max(max, ht * (stack.isEmpty() ? len : (len - stack.peek() - 1)));
		}

		return max;
	}
}
