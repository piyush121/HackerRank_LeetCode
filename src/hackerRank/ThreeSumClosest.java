package hackerRank;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) { // O(n^2 +
																// nlogn)
		int closest = nums[0] + nums[1] + nums[2];
		int leastDiff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				int diff = Math.abs(sum - target);
				if (sum == target)
					return target;
				if (sum < target) {
					if (diff < leastDiff) // check how close this sum is from the target.
					{ // should be as close to 0 as possible.
						closest = nums[i] + nums[start] + nums[end];
						leastDiff = diff;
					}
					start++;
				}

				else {
					if (diff < leastDiff) {
						closest = nums[i] + nums[start] + nums[end];
						leastDiff = diff;
					}
					end--;
				}
			}
		}

		return closest;

	}

	public static void main(String[] args) {
		int[] arr = { -3, -2, -5, 3, -4 };
		System.out.println(threeSumClosest(arr, -1));
	}

}
