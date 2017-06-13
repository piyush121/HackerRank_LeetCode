/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array a, find the greatest number in a that is a product of two elements in a. If there are no two elements 
 * in a that can be multiplied to produce another element contained in a, return -1.

Example

For a = [10, 3, 5, 30, 35], the output should be
maxPairProduct(a) = 30.

Explanation: 30 is a product of 10 and 3.

For a = [2, 5, 7, 8], the output should be
maxPairProduct(a) = -1;

For a = [10, 2, 4, 30, 35], the output should be
maxPairProduct(a) = -1;

For a = [10, 2, 2, 4, 30, 35], the output should be
maxPairProduct(a) = 4.

Explanation: 4 is a product of 2 and 2.
 *
 */
public class PairWithMaxProductInArray {
	int maxPairProduct(int[] a) { // O(n * sqrt(largest number)).
		Arrays.sort(a);
		Map<Integer, Integer> seen = new HashMap<>();
		int max = -1;
		for (int num : a) {
			int count = seen.getOrDefault(num, 0);
			seen.put(num, count + 1); // put current number in the table.
			for (int i = 1; i <= (int) Math.sqrt(num); i++) {
				int count1 = seen.getOrDefault(i, 0);
				seen.put(i, count1 - 1); // put back the original count.
				int count2 = seen.getOrDefault(num / i, 0);
				seen.put(i, count1);
				// count of both the number should be > 0.
				if (num % i == 0 && count1 > 0 && count2 > 0)
					max = Math.max(max, num);
			}
		}
		return max;
	}
}
