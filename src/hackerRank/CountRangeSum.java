/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 *
 */
public class CountRangeSum { // Hard one !
	public int countRangeSum1(int[] nums, int lower, int upper) { // O(N^2) Brute-Force approach.
		int n = nums.length;
		long[] sums = new long[n + 1];
		for (int i = 0; i < n; ++i)
			sums[i + 1] = sums[i] + nums[i];
		int ans = 0;
		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j <= n; ++j)
				if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
					ans++;
		return ans;
	}
	
	public int countRangeSum(int[] nums, int lower, int upper) { // D&C based solution. Pretty tough!
		int n = nums.length;
		int[] sums = new int[n + 1];
		for (int i = 0; i < n; ++i)
			sums[i + 1] = sums[i] + nums[i];

		return countRangeMerge(sums, 0, n, lower, upper);
	}

	public int countRangeMerge(int[] sums, int start, int end, int lower, int upper) {
		if (start >= end)
			return 0;
		int mid = (start + end) / 2;
		int count = countRangeMerge(sums, start, mid - 1, lower, upper) + countRangeMerge(sums, mid, end, lower, upper);
		int j = mid, k = mid, t = mid, r = 0;
		int cache[] = new int[end - start];
		for (int i = start; i < mid; i++) {

			while (k <= end && sums[k] - sums[i] < lower) 
				k++;
			while (j <= end && sums[j] - sums[i] <= upper)
				j++;
			while (t <= end && sums[t] < sums[i])
				cache[r++] = sums[t++];
			count += j - k;// because you can take all the index from j to i and make them within the given bounds.
		}
		System.arraycopy(cache, 0, sums, start, t - start);
		return count;
	}
}
