/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) { // Not so efficient because it will search a lot of useless nodes.
		if (root == null)
			return true;
		int left = height(root.left);
		int right = height(root.right);
		if (Math.abs(right - left) < 2)
			return isBalanced(root.left) && isBalanced(root.right);
		else
			return false;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}
}
