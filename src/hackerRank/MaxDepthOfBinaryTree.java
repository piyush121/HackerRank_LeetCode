/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 *
 */


public class MaxDepthOfBinaryTree { 
	int max = 0;
	
	public int maxDepth(TreeNode root) { // Even more elegant.
		if(root == null)
			return 0;
		
		return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));

	}
	
	
	public int maxDepth1(TreeNode root) {// Easy recursive.
		if(root == null)
			return max;
		max ++;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		max--;

		
		return Math.max(left,right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
