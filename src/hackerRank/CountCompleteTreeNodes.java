/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 *
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) { // O(logN^2) solution.
		if (root == null)
			return 0;
		int leftCount = 1 + leftHeight(root.left);
		int rightCount = 1 + rightHeight(root.right);

		if (leftCount == rightCount)
			return (1 << leftCount) - 1;
		else
			return 1 + countNodes(root.left) + countNodes(root.right);

	}

	private int leftHeight(TreeNode node) {
		if (node == null)
			return 0;
		int height = 0;
		while (node != null) {
			height++;
			node = node.left;
		}
		return height;
	}

	private int rightHeight(TreeNode node) {
		if (node == null)
			return 0;
		int height = 0;
		while (node != null) {
			height++;
			node = node.right;
		}
		return height;

	}

}
