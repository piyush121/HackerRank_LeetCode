/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class PascalsTriangle_II {
	public static List<Integer> getRow(int rowIndex) { // Easy DP solution.
		List<Integer> DP = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			DP.add(i, 1); // Important because we need to add this to the
							// previous number to get the new value.Think !
			for (int j = i - 1; j > 0; j--) {
				DP.set(j, DP.get(j) + DP.get(j - 1));
			}
		}
		return DP;

	}

	public static List<Integer> getRow1(int rowIndex) {
		Integer[] DP = new Integer[rowIndex + 1];
		Arrays.fill(DP, 0);

		DP[0] = 1;

		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i; j > 0; j--) {
				DP[j] = DP[j] + DP[j - 1];
			}
		}
		return Arrays.asList(DP);

	}

	public static void main(String[] args) {
		System.out.println(getRow1(3));

	}

}
