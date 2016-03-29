package hackerRank;

public class CoinChange {
	
	public static int minCoinsRecursive(int[] coins , int sum) {
		if(sum == 0) return 0;
		if(sum < 0) return Integer.MAX_VALUE;
		int min=0;
		for(int coin : coins) {
			min = 1 + minCoinsRecursive(coins,sum - coin);
			
		}
		
		return Math.min(sum, min);
	}
	
	public static void main(String[] args) {
		int[] coins = {25,10,5,1};
		System.out.println(minCoinsRecursive(coins, 32));
	}

}
