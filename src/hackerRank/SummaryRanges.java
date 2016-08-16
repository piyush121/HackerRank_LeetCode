/**
 * @author Piyush Chaudhary
 */
package hackerRank;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges. For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) { // Complicated Binary Search solution. But works well !
		List<String> res = new ArrayList<String>();
		if (nums.length == 0)
			return res;
		if (nums.length == 1) {
			res.add(""+nums[0]);
			return res;
		}
		int index = 0;
		int prev = 0;

		while (index < nums.length) {
			index = bSearch(nums, prev, nums.length - 1);

			if (index != nums.length - 1 && index + 1 - prev == nums[index + 1] - nums[prev]) {
				res.add(nums[prev] + "->" + nums[index + 1]);
				prev = index + 2;
			} 
			else if (prev == index) {
				res.add(""+nums[index]);
				prev = index + 1;
			}
				
			else {
				res.add(nums[prev] + "->" + nums[index]);
				prev = index + 1;
			}

			if (prev >= nums.length)
				break;
		}
		return res;
	}

	private int bSearch(int[] arr, int start, int end) {
		if (start == end - 1 || start == end)
			return start;
		int mid = (start + end) / 2;

		if (mid - start == arr[mid] - arr[start])
			return bSearch(arr, mid, end);
		else
			return bSearch(arr, start, mid);
	}

	public static void main(String[] args) {
		SummaryRanges obj = new SummaryRanges();
		System.out.println(obj.summaryRanges(new int[] { 0,1}));

	}

}
