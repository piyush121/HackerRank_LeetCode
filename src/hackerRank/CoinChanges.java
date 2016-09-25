/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function 
 * to compute the fewest number of coins that you need to make up that amount. If that amount of money 
 * cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 *
 */
public class CoinChanges {
	public int coinChange(int[] coins, int amount) { // Clean DP solution.
        int[] DP = new int[amount + 1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = 0;
        for(int i = 1; i <= amount; i++) {
        	for(int val : coins) {
	            int curr = DP[i];
        		if(i - val >= 0 && DP[i - val] != Integer.MAX_VALUE )
        			DP[i] = Math.min(1 + DP[i - val], curr); 
        	}
        }
        if(DP[amount] == Integer.MAX_VALUE)
        	return -1;
        return DP[amount];
    }
}
