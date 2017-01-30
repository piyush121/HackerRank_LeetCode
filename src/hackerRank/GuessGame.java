/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.
 *
 */
public class GuessGame {
	public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int num = low + (high - low) / 2; // to prevent overflow.
          //  int res = guess(num); // Ecternal API/
            if(res == 1)
                low = num + 1;
            else if(res == -1)
                high = num - 1;
            else
                return num;
        }
        return -1;
    }
}
