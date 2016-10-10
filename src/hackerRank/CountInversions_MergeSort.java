package hackerRank;

public class CountInversions_MergeSort {

	public static long countInversions(int[] arr) {

		return mergeSort(arr, 0, arr.length - 1);
	}

	public static long mergeSort(int[] arr, int start, int end) {
		if (start == end)
			return 0;
		int mid = (start + end) / 2;
		long count = 0;
		count += mergeSort(arr, start, mid); // left inversions.
		count += mergeSort(arr, mid + 1, end); // right inversions.
		count += merge(arr, start, end); // split inversions.
		return count;
	}

	public static long merge(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int[] newArr = new int[end - start + 1];
		int curr = 0;
		int i = start;
		int j = mid + 1;
		long count = 0;
		while (i <= mid && j <= end) {
			if (arr[i] > arr[j]) {
				newArr[curr++] = arr[j++];
				count += mid - i + 1; // Important part.
			} else
				newArr[curr++] = arr[i++];
		}
		// Leftover elements here.
		while (i <= mid) {
			newArr[curr++] = arr[i++];
		}

		while (j <= end) {
			newArr[curr++] = arr[j++];
		}

		System.arraycopy(newArr, 0, arr, start, end - start + 1); // Usual stuff
																	// from
																	// merge
																	// sort
																	// algorithm
																	// with
																	// arrays.
		return count;
	}

	public static long countInversions1(int[] arr) { // Brute force. O(n^2)
														// runtime
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			int currCount = 0;
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					currCount++;
				}
			}
			count += currCount;
			if (currCount == 0)
				break;
		}

		return count;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
