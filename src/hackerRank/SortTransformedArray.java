/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a sorted array of integers nums and integer values a, b and c. Apply a 
 * function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
 *
 */
public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) { // It's a parabola equation.
		if (nums.length == 0)
			return new int[] {};
		int[] res = new int[nums.length];
		int i = 0, j = nums.length - 1;
		int ptr = a >= 0 ? nums.length - 1 : 0;
		while (i <= j) {
			if (a >= 0) {
				res[ptr--] = getVal(nums[i], a, b, c) > getVal(nums[j], a, b, c) ? getVal(nums[i++], a, b, c)
						: getVal(nums[j--], a, b, c);
			} else {
				res[ptr++] = getVal(nums[i], a, b, c) < getVal(nums[j], a, b, c) ? getVal(nums[i++], a, b, c)
						: getVal(nums[j--], a, b, c);
			}

		}
		return res;
	}

	public int getVal(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
	/*
	 * The idea is simple:
For a parabola,
if a >= 0, the min value is at its vertex. So our our sorting should goes from two end 
points towards the vertex, HIGH to LOW.
if a < 0, the max value is at its vertex. So our sort goes LOW to HIGH.
	 */
}
