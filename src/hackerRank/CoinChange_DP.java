/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Find number of ways to find change of a give amount from given number of coins.
 *
 */
public class CoinChange_DP {
	public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long)1; 	// n == 0 case.
        for(int i = 0 ; i < coins.length; i++) {
            int coin = coins[i];
            for(int j = coin; j < DP.length; j++) {
            // The only tricky step.
                DP[j] += (j - coin >= 0 ? DP[j - coin] : 0);
            }
        }       
        return DP[money];
    }
	
	public static long makeChange1(int[] coins, int money) { // O(m * n ) space.
        long[][] DP = new long[coins.length + 1][money + 1];
        Arrays.fill(DP[0], 0);
        for(int i = 0 ; i < DP.length; i++) 
            DP[i][0] = 1;
        for(int i = 1 ; i < DP.length; i++) {
            int val = coins[i - 1];
            for(int j = 1; j < DP[0].length; j++) {
                    DP[i][j] = (j - val >= 0 ? DP[i][j - val] : 0) + DP[i - 1][j];
            }
        }
        
        return DP[coins.length][money];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
