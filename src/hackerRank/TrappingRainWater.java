/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Image reference :
http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		Stack<Integer> bars = new Stack<>();
		int i = 0;
		int ans = 0;
		while (i < height.length) {
			if (bars.isEmpty() || height[bars.peek()] >= height[i])
				bars.push(i++);
			else {
				while (!bars.isEmpty() && height[bars.peek()] < height[i]) {
					int bar = height[bars.pop()];
					ans += bars.isEmpty() ? 0
							: (Math.min(height[bars.peek()], height[i]) - bar) * (i - bars.peek() - 1);

				}
			}
		}
		return ans;
	}
}
