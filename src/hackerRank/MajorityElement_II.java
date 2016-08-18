/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than
 * ⌊n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * Hint:
 * 
 * How many majority elements could it possibly have?
 *
 */
public class MajorityElement_II {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0)
			return res;
		Integer num1 = null, num2 = null;
		int count1 = 0, count2 = 0;

		for (int val : nums) {
			if (val == num1)
				count1++;
			else if (val == count2)
				count2++;
			else {
				count1--;
				count2--;
			}

			if (count1 <= 0)
				num1 = val;
			else if (count2 <= 0 && val != num1)
				num2 = val;

		}
		int count = nums.length / 3;

		if (count1 >= count)
			res.add(num1);
		if (count2 >= count)
			res.add(num2);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
