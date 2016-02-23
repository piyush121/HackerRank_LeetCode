package hackerRank;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int LISDP(int[] A) {
		int[] DP = new int[A.length];
		int j = 0;
		Arrays.fill(DP, 1);
		for (int i = 0; i < A.length; i++) {
			for (j = 0; j < i; j++) {
				if (A[j] < A[i])
					DP[i] = Math.max(DP[i], DP[j] + 1);
			}

		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < DP.length; i++)
			if (DP[i] > max)
				max = DP[i];

		return max;
	}

	public static void main(String[] args) {
		System.out.println(LISDP(new int[] { 3, 1, 2, 6, 4, 9,7,10 }));
	}

}
