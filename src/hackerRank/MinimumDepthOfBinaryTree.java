/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, find its minimum depth. The minimum depth is the number
 * of nodes along the shortest path from the root node down to the nearest leaf
 * node.
 *
 */
public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) { //Should be easy but took me too long. I guess I should take a bath now :P
		if (root == null)
			return 0;
		if (root.left == null)
			return 1 + minDepth(root.right);
		if (root.right == null)
			return 1 + minDepth(root.left);
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
