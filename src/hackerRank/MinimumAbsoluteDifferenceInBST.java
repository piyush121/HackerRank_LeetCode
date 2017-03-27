/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
 *
 */
public class MinimumAbsoluteDifferenceInBST {
	Integer prev = null;
	int min = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) { // Simple in-order traversal.
		if (root == null)
			return 0;
		getMinimumDifference(root.left);
		if (prev == null)
			prev = root.val;
		else {
			min = Math.min(min, root.val - prev);
			prev = root.val;
		}
		getMinimumDifference(root.right);
		return min;
	}
}
