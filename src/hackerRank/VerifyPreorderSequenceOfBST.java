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
	public boolean verifyPreorder(int[] preorder) {// Recursive solution.
		if (preorder.length == 0)
			return true;
		return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean verify(int[] preorder, int start, int end, int min, int max) {
		if (start > end)
			return true;
		int root = preorder[start];
		int i = start;
		if (preorder[i] < min || preorder[i] > max)
			return false;
		for (; i <= end; i++) {

			if (preorder[i] > root)
				break;
		}
		return verify(preorder, start + 1, i - 1, min, root) && verify(preorder, i, end, root, max);
	}

	public boolean verifyPreorder1(int[] preorder) { // O(n) space and time.
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
				while (!temp.isEmpty() && temp.peek() < preorder[i]) // pop
																		// elements
																		// until
																		// you
																		// find
																		// the
																		// parent.
					low = temp.pop();// parent will be the one which is just
										// bigger than it.
				temp.push(preorder[i]);
			}
		}
		return true;
	}
}
