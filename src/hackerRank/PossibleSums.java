/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashSet;
import java.util.Set;

/**
 * You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it. You want to know how many distinct sums you can make from non-empty groupings of these coins.

Example

For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
possibleSums(coins, quantity) = 9.

Here are all the possible sums:

50 = 50;
10 + 50 = 60;
50 + 100 = 150;
10 + 50 + 100 = 160;
50 + 50 = 100;
10 + 50 + 50 = 110;
50 + 50 + 100 = 200;
10 + 50 + 50 + 100 = 210;
10 = 10;
100 = 100;
10 + 100 = 110.
As you can see, there are 9 distinct sums that can be created from non-empty groupings of your coins.
 *
 */
public class PossibleSums {
	int possibleSums(int[] coins, int[] quantity) {
		Set<Integer> res = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		res.add(0);
		for (int i = 0; i < coins.length; i++) {
			set = new HashSet<>();
			int coin = coins[i];
			int amount = quantity[i];
			for (int j = 1; j <= amount; j++) {
				for (Integer num : res) {
					int sum = num + (coin * j);
					set.add(sum);
				}
			}
			res.addAll(set);
		}
		return res.size() - 1;
	}
	// Recursive version
	
	void getSums(int[] coins, int[] quantity, int sum, int idx, HashSet<Integer> sums) {
		if (idx == coins.length) {
			sums.add(sum);
			return;
		}
		int coin = coins[idx];
		for (int i = 0; i <= quantity[idx]; i++)
			getSums(coins, quantity, sum + coin * i, idx + 1, sums);
	}

	int possibleSums1(int[] coins, int[] quantity) {
		HashSet<Integer> sums = new HashSet<Integer>();
		getSums(coins, quantity, 0, 0, sums);
		return sums.size() - 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
