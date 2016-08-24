/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
 *
 */
public class CountUnivalueSubtree {
	public int countUnivalSubtrees(TreeNode root) { // Less efficient but works !
		if (root == null)
			return 0;
		boolean left = helper(root.left, root.val);
		boolean right = helper(root.right, root.val);
		if (left && right)
			return count(root);
		else if (left)
			return count(root.left) + countUnivalSubtrees(root.right);
		else if (right)
			return count(root.right) + countUnivalSubtrees(root.left);
		else
			return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
	}

	private boolean helper(TreeNode node, int val) {
		if (node == null)
			return true;
		if (node.val != val)
			return false;
		return helper(node.left, node.val) && helper(node.right, node.val);
	}

	private int count(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + count(node.left) + count(node.right);
	}
}
