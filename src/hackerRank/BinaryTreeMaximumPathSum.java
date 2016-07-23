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
	static int max = Integer.MIN_VALUE;
	private static int max1;


	public static int maxPathSum1(TreeNode root) { // hard one. But solution is quiet Elegant!
		helper(root);
		return max;
	}

	private static int helper(TreeNode root) { // O(n) time, O(logN) space..
		if (root == null)
			return 0;

		int left = Math.max(0, helper(root.left)); // Check for negative values.
		int right = Math.max(0, helper(root.right));
		max = Math.max(left + right + root.val, max);
		return Math.max(left, right) + root.val; // When you go up you cannot
													// have all three(i.e root,
													// left and right together.
	}
	
    public static int maxPathSum(TreeNode root) { // Easier to ndertand.
        if (root==null) return 0;
        max1 = Integer.MIN_VALUE;
        findMaxSingle(root);
        return max1;
    }
    private  static int findMaxSingle(TreeNode root){
        if (root==null) return 0;
        int leftMax = findMaxSingle(root.left);
        int rightMax = findMaxSingle(root.right);
        int localMax = Math.max(root.val,Math.max(leftMax,rightMax)+root.val); //Find local maximum which can be one of 3 options.
        max1 = Math.max(Math.max(localMax, leftMax+rightMax+root.val), max1); // set max to one of 3 options or all 3 together.
        return localMax;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(-2);
		System.out.println(maxPathSum(root));

	}

}
