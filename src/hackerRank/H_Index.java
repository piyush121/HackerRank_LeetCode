/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index h
 * if h of his/her N papers have at least h citations each, and the other N − h
 * papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 * 
 * Show Hint
 *
 * 
 */
public class H_Index {
	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i)
				return citations.length - i;
		}
		return 0;
	}

	public int hIndex1(int[] citations) {
		int len = citations.length;
		for (int i = 0; i < len; i++)
			if (citations[i] > len)
				citations[i] = len;

		int[] counts = new int[len + 1];
		for (int i = 0; i < len; i++) {
			counts[citations[i]]++;
		}

		int k = 0;
		for (int i = len; i >= 0; i--) {
			k += counts[i];
			if (k >= i)
				return i;
		}
		return 0;
	}
}
