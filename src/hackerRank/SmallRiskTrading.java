/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Submitted as a part of Moody's University Hackathon.
 *
 */
public class SmallRiskTrading {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		Float[] p = new Float[n];
		Float[] x = new Float[n];
		Float[] y = new Float[n];
		Float[] res = new Float[n];
		DecimalFormat df = new DecimalFormat("#0.00");
		for (int i = 0; i < n; i++) {
			p[i] = scan.nextFloat();
		}
		for (int i = 0; i < n; i++) {
			x[i] = scan.nextFloat();
		}
		for (int i = 0; i < n; i++) {
			y[i] = scan.nextFloat();
		}

		for (int i = 0; i < n; i++) {
			res[i] = (p[i] * x[i] - (1 - p[i]) * y[i]);
		}

		Arrays.sort(res, Collections.reverseOrder());
		double ans = 0;
		for (int i = 0; i < k; i++) {
			if (res[i] < 0)
				break;
			ans += res[i];
		}
		int scale = 2;
		ans = Math.round(ans * Math.pow(10, scale)) / Math.pow(10, scale);
		System.out.println(df.format(ans));
	}
}
