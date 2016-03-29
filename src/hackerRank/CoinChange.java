package hackerRank;

public class CoinChange {

	public static int minCoinsRecursive(int[] coins, int sum) { // Recursive and highly inefficient.
		if (sum == 0)
			return 0;
		if (sum < 0)
			return Integer.MAX_VALUE;
		int minCount = Integer.MAX_VALUE;
		for (int coin : coins) {
			int count = 1 + minCoinsRecursive(coins, sum - coin); // recursive call on every combination.
			if (count > 0 && count < minCount)
				minCount = count;
		}

		return Math.min(sum, minCount);
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5, 1 };
		System.out.println(minCoinsRecursive(coins, 32));
	}

}
