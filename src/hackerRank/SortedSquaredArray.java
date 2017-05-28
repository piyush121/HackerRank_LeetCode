/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Note: Come up with a linear solution, since that is what you would be asked to do in an interview.

You have a sorted array of integers. Write a function that returns a sorted array containing the squares of those integers.

Example

For array = [-6, -4, 1, 2, 3, 5], the output should be
sortedSquaredArray(array) = [1, 4, 9, 16, 25, 36].

The array of squared integers from array is: [36, 16, 1, 4, 9, 25]. When sorted, it becomes: [1, 4, 9, 16, 25, 36].

Input/Output

[time limit] 3000ms (java)
[input] array.integer array

A sorted array of integers.

Guaranteed constraints:
1 ≤ array.length ≤ 104,
-104 ≤ array[i] ≤ 104.

[output] array.integer

A sorted array of integers composed of the squared integers from the input array.
 *
 */
public class SortedSquaredArray {
	int[] sortedSquaredArray(int[] array) {
		int[] res = new int[array.length];
		int i = 0, j = -1, k = array.length;

		for (i = 0; i < array.length; i++) {
			if (array[i] < 0)
				j++;
			if (k == array.length && array[i] >= 0)
				k = i;
			array[i] *= array[i];
		}
		i = 0;
		// merge.
		while (j >= 0 && k < array.length) {
			if (array[j] < array[k])
				res[i++] = array[j--];
			else
				res[i++] = array[k++];
		}

		while (j >= 0)
			res[i++] = array[j--];
		while (k < array.length)
			res[i++] = array[k++];
		return res;
	}

}
