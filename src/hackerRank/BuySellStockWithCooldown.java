/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 *
 */
public class BuySellStockWithCooldown { // Really tricky one !
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int n = prices.length;
		int[] b = new int[n]; // Max profit if we buy at i.
		int[] s = new int[n];// Max profit if we sell at i.
		b[0] = -prices[0];
		b[1] = b[0];
		s[0] = 0;
		s[1] = Math.max(b[0] + prices[1], s[0]);
		for (int i = 2; i < n; i++) {
			int price = prices[i];
			b[i] = Math.max(b[i - 1], s[i - 2] - price); // Have to rest before we buy. So, s[i - 2].
			s[i] = Math.max(b[i - 1] + price, s[i - 1]); // We can either sell at i or take a rest.
		}

		return s[n - 1]; // ultimate goal.
	}
}
