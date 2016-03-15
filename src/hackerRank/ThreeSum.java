package hackerRank;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Piyush Chaudhary
 *
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length == 0)
			return new LinkedList<List<Integer>>();
		LinkedList<List<Integer>> result = new LinkedList<>();
		result.add(new LinkedList<Integer>());
		int start = 0;
		int end = nums.length - 1;
		int curr = start + 1;
		while (start < end - 2) {
			while (curr < end) {
				curr=start+1;
				if (nums[start] + nums[curr] + nums[end] < 0)
					curr++;
				else if (nums[start] + nums[curr] + nums[end] == 0) {
					LinkedList<Integer> list=new LinkedList<>();
					list.add(nums[start]);list.add(nums[curr]);list.add(nums[end]);
					result.add(list);
					
				}
					start++;
					
			}
		}

	}

}
