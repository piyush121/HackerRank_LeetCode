package hackerRank;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3)
			return 0;
		int closest = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == target)
					return target;
				if (sum < target) {
					if (Math.abs(sum - target) < Math.abs(closest - target))
						closest = nums[i] + nums[start] + nums[end];
					start++;
				}

				else {
					if (Math.abs(sum - target) < Math.abs(closest - target))
						closest = nums[i] + nums[start] + nums[end];
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
