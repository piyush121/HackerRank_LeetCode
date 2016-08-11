/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * 
 * 
 */
public class CountPrimes {
	public static int countPrimes(int n) { // O(nloglogn) using sieve of erastosthenes theoreum. 
		boolean[] nums = new boolean[n];
		Arrays.fill(nums, true);
		int count = 0;

		for (int i = 2; i * i < n; i++) {
			if (!nums[i])
				continue;
			for (int j = i; j * i < n; j++) {
				nums[j * i] = false;
			}
		}

		for (int i = 2; i < nums.length; i++) {
			if (nums[i])
				count++;
		}

		return count;

	}

	public static void main(String[] args) {
		System.out.println(countPrimes(20));
	}

}
