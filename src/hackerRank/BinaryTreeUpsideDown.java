/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that 
 * shares the same parent node) or empty, flip it upside down and turn it into a tree where the original
 *  right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
 *
 */
public class BinaryTreeUpsideDown {
	TreeNode master = null;

	public TreeNode upsideDownBinaryTree(TreeNode root) { //Easy recursive DFS based O(n) solution.
		dfs(root);
		return master;

	}

	public TreeNode dfs(TreeNode root) {
		if (root == null)
			return null;
		TreeNode node = dfs(root.left);
		if (master == null && node == null)
			master = root; // remember the root is the first one to visit when the left most leaf node is hit.
		if (node != null) {
			node.left = root.right;
			node.right = root;
		}
		root.left = null; // important step to take care of changed stuff.
		root.right = null;
		return root;
	}
}
