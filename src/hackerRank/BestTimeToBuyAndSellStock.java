/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) { // Slightly more efficient and easy than Kadane's algorithm.
		if (prices.length == 0)
			return 0;
		int max = 0;
		int minSoFar = prices[0]; //Keep track of minimum seen value so far.

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > minSoFar)
				max = Math.max(max, prices[i] - minSoFar);
			else
				minSoFar = prices[i];
		}

		return max;

	}
	
	public int maxProfit1(int[] prices) { // Kadane's algorithm
		if (prices.length < 2)
			return 0;

		int max = prices[1] - prices[0];
		int temp = 0;
		for (int i = 1; i < prices.length; i++) {
			temp += prices[i] - prices[i - 1];
			if (temp > max)
				max = temp;
			if (temp < 0)
				temp = 0;

		}

			return Math.max(0, max);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
