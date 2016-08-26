/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Follow up: Could you do it using only constant space complexity?
 *
 */
public class VerifyPreorderSequenceOfBST {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder.length == 0)
			return true;
		Stack<Integer> temp = new Stack<>();
		int low = Integer.MIN_VALUE;
		temp.push(preorder[0]);
		for (int i = 1; i < preorder.length; i++) {
			if (preorder[i] < low)
				return false;
			if (preorder[i] < temp.peek())
				temp.push(preorder[i]);
			else {
				while (!temp.isEmpty() && temp.peek() < preorder[i]) // pop elements until you find the parent.
					low = temp.pop();// parent will be the one which is just bigger than it.
				temp.push(preorder[i]);
			}
		}
		return true;
	}
}
