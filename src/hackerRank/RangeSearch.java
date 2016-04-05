package hackerRank;

import java.util.Arrays;

public class RangeSearch {
	public static int[] searchRange(int[] nums, int target) { // O(log n) solution. But inefficient.
		int lower = -1;
		int higher = -1;
		int index = binarySearch(nums, target, 0, nums.length - 1); //log n
		if (index != -1) {
			
			lower = lBound(nums, target, 0, index - 1, index); // Find lower index. Log n
																 
			higher = hBound(nums, target, index + 1, nums.length - 1, index); // find upper index. Log n.
		}

		return new int[] { lower, higher };

	}

	private static int binarySearch(int[] arr, int val, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == val)
			return mid;
		else if (arr[mid] < val)
			return binarySearch(arr, val, mid + 1, end);
		else
			return binarySearch(arr, val, start, mid - 1);

	}

	private static int lBound(int[] arr, int val, int start, int end, int index) {
		if (start > end)
			return index;
		int mid = (start + end) / 2;
		if (arr[mid] == val)
			return lBound(arr, val, start, mid - 1, mid);
		else
			return lBound(arr, val, mid + 1, end, index);
	}
	
	private static int hBound(int[] arr, int val, int start, int end, int index) {
		if (start > end)
			return index;
		int mid = (start + end) / 2;
		if (arr[mid] == val)
			return hBound(arr, val, mid + 1, end, mid);
		else
			return hBound(arr, val, start, mid - 1, index);
	}
	
	public static int[] searchRange1(int[] nums, int target) { // O(log n) solution. Efficient..
		int higher = -1;
		int lower = lhBound(nums, target, 0,nums.length); //log n
		
		if(nums[lower] != target)
			return new int[]{-1, -1};
		else 
			higher = lhBound(nums, target + 1, 0, nums.length); // find upper index. Log n.
		
		
		return new int[] { lower, higher - 1};

	}
	
	private static int lhBound(int[] arr, int val, int start, int end) {
		if (start == end)
			return end;
		int mid = (start + end) / 2;
		if (arr[mid] >= val)
			return lhBound(arr, val, start, mid);
		else
			return lhBound(arr, val, mid + 1, end);
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] nums1 = {1,2,3,3,3,3,4,5,9};
		System.out.println(Arrays.toString(searchRange1(nums1, 3)));
	}

}
