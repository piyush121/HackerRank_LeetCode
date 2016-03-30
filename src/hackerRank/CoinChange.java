package hackerRank;

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
	
	public  static int minCoinsDP(int[] coins, int sum) {
		
	}

	public static void main(String[] args) {
		int[] coins = { 25, 10, 5, 1 };
		System.out.println(minCoinsRecursive(coins, 16));
	}

}
