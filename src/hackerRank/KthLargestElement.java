package hackerRank;

/*
 * Find the kth largest element in an unsorted array. This will be the kth largest element in sorted order, not the kth distinct element.

Example

For nums = [7, 6, 5, 4, 3, 2, 1] and k = 2, the output should be
kthLargestElement(nums, k) = 6;
For nums = [99, 99] and k = 1, the output should be
kthLargestElement(nums, k) = 99.
 */
public class KthLargestElement {
	int kthLargestElement(int[] nums, int k) {
		return quickSelect(nums, k, 0, nums.length - 1);
	}

	int partition(int[] arr, int low, int high) { // Randomized partition.
		int randomNum = ThreadLocalRandom.current().nextInt(low, high + 1);
		int pivot = arr[randomNum];
		int i = low, j = low;
		// Many corner cases.
		while (j <= high) {
			if (i == randomNum)
				i++;
			if (arr[j] > pivot)
				swap(arr, i++, j);
			j++;
		}
		if (i > randomNum)
			swap(arr, --i, randomNum);
		else
			swap(arr, i, randomNum);
		return i;
	}

	int quickSelect(int[] arr, int k, int low, int high) {
		int idx = partition(arr, low, high);
		if (idx == k - 1)
			return arr[idx];
		else if (idx < k - 1)
			return quickSelect(arr, k, idx + 1, high);
		else
			return quickSelect(arr, k, low, idx - 1);

	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
