package hackerRank;

import java.util.Arrays;

public class CoinChange {

	public static int minCoinsRecursive(int[] coins, int sum) { // Recursive and highly inefficient.
		if (sum == 0)
			return 0;
		
		int minCount = sum;
		for (int coin : coins) {
			if(sum - coin >= 0) {
				int count = 1 + minCoinsRecursive(coins, sum - coin); // recursive call on every combination.
				if (count < minCount)
					minCount = count;
			}
		}

		return Math.min(sum, minCount);
	}
	
	public  static int minCoinsDP(int[] coins, int sum, int[] cache) {
		int minCount = sum;
		for (int coin : coins) {
			if (sum - coin >= 0) {
				int count;
				if (cache[sum] < 0) //value not cached.
					count = 1 + minCoinsDP(coins, sum - coin, cache);
				else
					count = cache[sum];
				if (count < minCount)
					minCount = count;

			}
		}
		return minCount;
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5, 1 };
		System.out.println(minCoinsRecursive(coins, 32));
		int[] cache = new int[33];
		Arrays.fill(cache, -1);
		cache[0] = 0;
		System.out.println(minCoinsDP(coins, 32, cache));
	}

}
