/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1, 2, 3, ... , n] contains a total of n! unique permutations. List all the permutations for an integer n in lexicographical order and return the kth permutation in the sequence as a string. To build this string, concatenate decimal representations of permutation elements from left to right without any delimiters.

Example

For n = 3 and k = 3, the output should be
permutationSequence(n, k) = "213".

The ordered list of possible permutations for 3! is:

  1) "123"
  2) "132"
  3) "213"
  4) "231"
  5) "312"
  6) "321"
The 3rd permutation in the lexicographically ordered sequence is "213".
 *
 */
public class FindKthPermutation {
	String permutationSequence(int n, int k) { // Assuming n <= 12. O(n) time.
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		StringBuilder strb = new StringBuilder();
		permutationSequence(k, strb, list);
		return strb.toString();
	}

	void permutationSequence(int k, StringBuilder strb, List<Integer> list) { // More
																				// Efficient
																				// for
																				// larget
																				// numbers.
		if (list.size() == 1) {
			strb.append(list.get(0));
			return;
		}
		int m = list.size();
		int n = m - 1;
		int block = 0;
		int x = k - 1;
		while (n > 1) {
			x /= n;
			n--;
			if (x == 0)
				break;
		}
		block = x;
		strb.append(list.get(block));
		list.remove(block);
		if (x != 0)
			k = k - x * factorial(m - 1);
		permutationSequence(k, strb, list);
	}

	void permutationSequence1(int k, StringBuilder strb, List<Integer> list) {
		if (list.size() == 1) {
			strb.append(list.get(0));
			return;
		}
		int n = list.size();
		int blockSize = factorial(n - 1);
		int block = ((k - 1) / blockSize);
		strb.append(list.get(block));
		list.remove(block);
		k = k - (blockSize * block);
		permutationSequence(k, strb, list);
	}

	int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		return res;
	}

}
