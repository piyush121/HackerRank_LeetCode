/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuyAndSellStock_II {
	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int profit = 0;
		
		for (int i = 0; i < prices.length; i++) {
			if(i != 0 && prices[i] > prices[i-1])
				profit += prices[i] - prices[i-1];
			
		}
		
		return profit;
	}
	
	
	public static int maxProfit1(int[] prices) { // Good one. O(N) solution. But can be further optimized.
		if (prices.length == 0)
			return 0;
		int low = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1] && i != prices.length - 1) {
				continue;
			} else if (prices[i] < prices[i - 1]) {
				profit += prices[i - 1] - low;
				low = prices[i];
			} else {
				profit += prices[i] - low;
			}
		}

		return profit;

	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1, 4, 2 }));
	}

}
