/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node 
in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 *
 */
public class BinaryTreeMaximumPathSum {
	static int max = 0;

	public static int maxPathSum(TreeNode root) { // hard one. But solution is quiet Elegant!
		helper(root);
        return max;
	}

	private static int helper(TreeNode root) { // O(n) time, O(logN) space..
		if (root == null)
			return 0;

		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		max = Math.max(left + right + root.val, max);
		return Math.max(left, right) + root.val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(-2);
		System.out.println(maxPathSum(root));

	}

}
