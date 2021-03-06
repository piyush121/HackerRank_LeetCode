/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterOfBinaryTree {
	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) { // O(N) time, N = number of nodes. O(H) space.
		if (root == null)
			return 0;
		dfs(root);
		return max;
	}

	public int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left); // get left height.
		int right = dfs(root.right); // get right height.

		max = Math.max(max, left + right); // Find max diameter.

		return 1 + Math.max(left, right); // return max height of left and right sub-tree.

	}
	
	public int diameterOfBinaryTree1(TreeNode root) { // Another way to return
														// both diameter and
														// height at the same
														// time.
		if (root == null)
			return 0;
		int[] res = dfs1(root);
		return res[0];
	}

	public int[] dfs1(TreeNode root) {
		if (root == null)
			return new int[] { 0, -1 };
		int[] left = dfs1(root.left);
		int[] right = dfs1(root.right);

		int[] res = { Math.max(Math.max(left[0], right[0]), 2 + left[1] + right[1]), 1 + Math.max(left[1], right[1]) };
		return res;

	}
}
