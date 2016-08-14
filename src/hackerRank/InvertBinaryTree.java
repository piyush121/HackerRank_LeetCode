/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can’t invert a binary tree on a whiteboard so fuck off.
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) { // easy recursive
												// implementation.
		if (root == null)
			return null;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.left = right;
		root.right = left;
		return root;

	}

	public TreeNode invertTree1(TreeNode root) { // Easy iterative implementation.
		if (root == null)
			return null;

		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);

		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			helper(node);
			if (node.left != null)
				que.add(node.left);
			if (node.right != null)
				que.add(node.right);
		}

		return root;
	}

	private void helper(TreeNode node) {
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

}
