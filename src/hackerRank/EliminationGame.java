/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Find the last number that remains starting with a list of length n.

Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
 *
 */
public class EliminationGame {
	public int lastRemaining(int n) {
		if (n == 0)
			return 0;
		int head = 1; // keep track of the head.
		boolean left = true;
		int step = 1; // keep track of the current round.
		while (n > 1) {
			if (left || (!left && n % 2 == 1)) { // head will move only when we
													// are going from left or
													// the
													// numbers left are odd and
													// we
													// are going from right.
				head += step; // increment head by the current round number.

				n = n / 2; // every round reduces the numbers by half.
			}

			left = !left; // change direction after every round

			step *= 2; // every time the number of steps to increment by head
						// will get doubled because the numbers are getting
						// half.
		}
		return head;
	}
}
