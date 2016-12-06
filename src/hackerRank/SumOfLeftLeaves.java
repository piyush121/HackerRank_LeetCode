/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 *Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {

		if (root == null)
			return 0;
		int sum = 0;

		if (root.left != null && root.left.left == null && root.left.right == null)
			sum += root.left.val;
		else
			sum += sumOfLeftLeaves(root.left);

		sum += sumOfLeftLeaves(root.right);

		return sum;

	}
}
