/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
 *
 */
public class CanIWin {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) { // O(2^N) where N = max choosable integer.
		int sum = ((maxChoosableInteger + 1) * maxChoosableInteger) / 2; // we can't reach more than n * (n + 1) / 2 number.
		if (sum < desiredTotal)
			return false;
		if (maxChoosableInteger > desiredTotal)
			return true;
		return canIWin(desiredTotal, maxChoosableInteger, new HashMap<Integer, Boolean>(), 0);
	}
	// `used` is used to keep track of used numbers by using its bits. Since the max choosable integer cannot be more than 20.
	// simple integer with 32 bits would do.
	public boolean canIWin(int desiredTotal, int maxChoosableInteger, Map<Integer, Boolean> memo, int used) {
		if (memo.containsKey(used))
			return memo.get(used);
		if (desiredTotal <= 0) {
			memo.put(used, false);
			return false;
		}
		boolean res = false;
		for (int i = 1; i <= maxChoosableInteger; i++) {
			if (((1 << i) & used) == 0) {
				res = res || !canIWin(desiredTotal - i, maxChoosableInteger, memo, used | (1 << i));
			}
		}
		memo.put(used, res);
		return res;
	}

}
