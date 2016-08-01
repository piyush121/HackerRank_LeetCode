/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 *
 * 
 * 
 */

/*
 * One of the best solution : The idea is to split the range [min, max] evenly
 * int n-1 intervals. The interval length would be (max - min)/(n-1). According
 * to the pigeon hole principle, the max range cannot be smaller than (max -
 * min)/(n-1). Which means if there are two numbers generates the max
 * difference, they must be in different intervals. Then we just need to compute
 * the max difference between successive elements that lies in adjacent
 * intervals. To do that, we just need to record min and max value for each
 * interval.
 */
public class MaximumGap {
	public static int maximumGap(int[] nums) { // Very hard one. But I think in
												// an
		if (nums.length < 2) // Interview we can also implement
			return 0; // counting sort to get an answer.
		int max = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}
		int range = (max - min - 1) / (nums.length - 1) + 1; // hard to get but makes sense if you think deeply.
		System.out.println("Range: " + range);
		if (range == 0)
			return nums[0];
		int[] maxIntervals = new int[nums.length];
		int[] minIntervals = new int[nums.length];
		Arrays.fill(maxIntervals, Integer.MIN_VALUE);
		Arrays.fill(minIntervals, Integer.MAX_VALUE);

		for (int i = 0; i < nums.length; i++) {
			int idx = (nums[i] - min) / (range);
			maxIntervals[idx] = Math.max(nums[i], maxIntervals[idx]);
			minIntervals[idx] = Math.min(nums[i], minIntervals[idx]);
		}
		int prev = maxIntervals[0]; // previous max value.
		int maxGap = 0;
		for (int i = 1; i < nums.length; i++) { // Find max gap between intervals.
			if (maxIntervals[i] == Integer.MIN_VALUE && minIntervals[i] == Integer.MAX_VALUE)
				continue; // Skip empty buckets.
			int gap = minIntervals[i] - prev; // find gap between previous max and current min.
			if (gap > maxGap)
				maxGap = gap;
			prev = maxIntervals[i];
		}

		return maxGap;
	}

	public static void main(String[] args) {
		System.out.println(maximumGap(new int[] { 1, 1, 1, 1 }));

	}

}
