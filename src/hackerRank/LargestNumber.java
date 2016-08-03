/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 *
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		StringBuilder res = new StringBuilder();
		if (nums.length == 0)
			return null;

		String[] strArray = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strArray[i] = String.valueOf(nums[i]);

		Arrays.sort(strArray, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return -1 * (s1 + s2).compareTo(s2 + s1); // to get descending order sort.
			}

		});
		//Number should not start with 0 unless it is 0 itself.
		if (strArray[0].equals("0"))
			return "0";
		for (int i = 0; i < strArray.length; i++)
			res.append(strArray[i]);
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
