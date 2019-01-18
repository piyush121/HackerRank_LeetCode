package hackerRank;

import java.util.Arrays;

public class Nextpermutation {
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	private static void reverseSort(int[] arr, int start, int end) {
		int len = end - start + 1;
		for (int k = 0; k <= len / 2; k++) {
			swap(arr, start + k, end - k);
		}
	}

	public static void nextPermutation(int[] nums) { // O(n)
		int len = nums.length;
		int i = len - 1;
		for (i = len - 1; i >= 0; i--) {

			if (i != 0 && nums[i] > nums[i - 1]) // O(n)
				break;
		}

		if (i != -1 && len > 1) {
			int k = i - 1;
			int val = nums[k];
			while (i < len && val < nums[i])
				i++;
			swap(nums, k, i - 1);
			reverseSort(nums, k + 1, len - 1);
		} else {
			reverseSort(nums, 0, len - 1); // O(n)
		}

		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		nextPermutation(new int[] { 1, 3, 2, 1 });
	}

}
