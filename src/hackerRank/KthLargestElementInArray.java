/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */
public class KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) { // Quick select based
													// solution. O(N) runtime on
													// average. O(1) space.
		int index = partition(nums, 0, nums.length - 1, k);
		return nums[index];
	}

	private int partition(int[] nums, int low, int high, int k) {
		int pivot = low;
		int j = pivot;
		for (int i = low; i <= high; i++) {
			if (nums[i] > nums[pivot])
				swap(nums, ++j, i);

		}
		swap(nums, pivot, j);
		if (j == k - 1)
			return j;
		if (j < k - 1)
			return partition(nums, j + 1, high, k);
		else
			return partition(nums, low, j - 1, k);

	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public int findKthLargest1(int[] nums, int k) { // ONLOG(K) time and O(K)
													// space.
		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			que.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (nums[i] > que.peek()) {
				que.poll();
				que.add(nums[i]);
			}
		}

		return que.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
