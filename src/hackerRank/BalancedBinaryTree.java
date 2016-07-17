/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) { //Slickest recursive code you'll ever see.
		if (root == null)
			return true;
		return depth(root) != -1;
	}

	private int depth(TreeNode node) {
		if (node == null)
			return 0;
		int left = depth(node.left);
		int right = -1;
		if(left != -1) //Trying to avoid useless search. Why go to right when left is unbalanced. Right ?
			right = depth (node.right);
		if(right != -1 && Math.abs(left - right) <=1 )
			return 1 + Math.max(left, right);
		else
			return -1;
	}
	
	
	public boolean isBalanced1(TreeNode root) { // Not so efficient because it will search a lot of useless nodes.
		if (root == null)
			return true;
		int left = height(root.left);
		int right = height(root.right);
		if (Math.abs(right - left) < 2)
			return isBalanced1(root.left) && isBalanced1(root.right);
		else
			return false;
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}
}
