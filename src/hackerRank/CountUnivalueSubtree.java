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
	
	public int countUnivalSubtrees(TreeNode root) { // Efficient.
		if (root == null)
			return 0;
		int[] count = new int[1]; // to pass reference object.
		helper(root, count);
		return count[0];
	}

	private boolean helper(TreeNode node, int[] count) {
		if (node == null)
			return true;
		boolean left = helper(node.left, count);
		boolean right = helper(node.right, count);

		if (left && right) {
			if (node.left != null && node.val != node.left.val)
				return false;
			if (node.right != null && node.val != node.right.val)
				return false;
			count[0]++;
			return true;
		}

		return false;
	}

	public int countUnivalSubtrees1(TreeNode root) { // Less efficient but works
														// !
		if (root == null)
			return 0;
		boolean left = helper(root.left, root.val);
		boolean right = helper(root.right, root.val);
		if (left && right)
			return count(root);
		else if (left)
			return count(root.left) + countUnivalSubtrees1(root.right);
		else if (right)
			return count(root.right) + countUnivalSubtrees1(root.left);
		else
			return countUnivalSubtrees1(root.left) + countUnivalSubtrees1(root.right);
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
