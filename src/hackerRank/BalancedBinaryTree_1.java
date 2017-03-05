/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 */
public class BalancedBinaryTree_1 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return findHeight(root) != -1;
	}

	public int findHeight(TreeNode node) { // get height of left and right subtree and return max height if valid.
		if (node == null)
			return 0;
		int left = findHeight(node.left);
		int right = findHeight(node.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(right - left) <= 1)
			return 1 + Math.max(left, right);
		return -1;
	}
}
