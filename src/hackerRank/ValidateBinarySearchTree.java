/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 *
 */
public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root) { // Cool solution with no integer overflow error.
		if(root == null)
			return true;
		return helper(root.left, root.val, Long.MIN_VALUE) && helper(root.right, Long.MAX_VALUE, root.val);
	}
	
	private static boolean helper(TreeNode node, long max, long min) {	
		if(node == null)
			return true;
		if(node.val >= max || node.val <= min)
			return false;
		
		return helper(node.left, node.val, min) && helper(node.right, max, node.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(1);
		root.left = left;
		System.out.println(isValidBST(root));
		
	}

}
