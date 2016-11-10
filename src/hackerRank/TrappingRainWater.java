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
	public int trap1(int[] height) { // O(N) space and runtime. Faster solution coming soon.
		Stack<Integer> bars = new Stack<>();
		int i = 0;
		int ans = 0;
		while (i < height.length) {
			if (bars.isEmpty() || height[bars.peek()] >= height[i])
				bars.push(i++);
			else {
				while (!bars.isEmpty() && height[bars.peek()] < height[i]) {
					int bar = height[bars.pop()]; // basically find left bar of current index and the current bar.
					ans += bars.isEmpty() ? 0 // Then compare for the smaller one and fin the rectangle between them.
							: (Math.min(height[bars.peek()], height[i]) - bar) * (i - bars.peek() - 1);

				}
			}
		}
		return ans;
	}
	
	public int trap(int[] height) { // O(n) runtime and O(1) space elegant solution !
        if(height.length == 0)
            return 0;
        int ans = 0;
        int left = 0;
        int leftLarge = 0;
        int rightLarge = height.length - 1;
        int right = height.length - 1;
        
        while(left < right) {
            if(height[left] > height[leftLarge])
                leftLarge = left;
            if(height[right] > height[rightLarge])
                rightLarge = right;
                
            if(height[left] <= height[right]) {
                ans += height[leftLarge] - height[left++];
            }
            else {
                ans += height[rightLarge] - height[right--];
            }
        }
        
        return ans;
    }
}
