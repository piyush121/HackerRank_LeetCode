/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 *
 */
public class ConvertBSTtoGreaterTree {
	Integer next = null;

	public TreeNode convertBST(TreeNode root) {
		inorder(root);
		return root;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.right);
		if (next == null)
			next = root.val;
		else {
			root.val += next;
			next = root.val;
		}
		inorder(root.left);
	}
}
