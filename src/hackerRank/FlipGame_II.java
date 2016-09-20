/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * For example, given s = "++++", return true. The starting player can guarantee
 * a win by flipping the middle "++" to become "+--+".
 * 
 * Follow up: Derive your algorithm's runtime complexity.
 *
 */
public class FlipGame_II {
	public boolean canWin(String s) {
		List<String> moves = generatePossibleNextMoves(s);
		for(String move : moves) {
			if(!canWin(move)) // If any of the next move lead to the sure shot loss of next player then
				return true; // take it and win.
		}		
		return false;
	}
	
	public List<String> generatePossibleNextMoves(String s) { // Easy one.
		if (s.length() == 0)
			return new ArrayList<>();
		List<String> res = new ArrayList<>();
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length - 1; i++) {
			if (chs[i] == '+' && chs[i + 1] == '+') {
				chs[i] = '-';
				chs[i + 1] = '-';
				res.add(String.valueOf(chs));
				chs[i] = '+'; // Put back stuffs.
				chs[i + 1] = '+';
			}
		}
		return res;

	}
	
	public static void main(String[] args) {
		FlipGame_II obj = new FlipGame_II();
		System.out.println(obj.canWin("+++++++"));
	}
}
