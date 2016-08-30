/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 *
 */
public class ClosestBSTValue {
	public int closestValue(TreeNode root, double target) {
		int temp = 0;
		if (root.val > target && root.left != null) {
			temp = closestValue(root.left, target);
			return Math.abs(temp - target) > Math.abs(root.val - target) ? root.val : temp;
		} else if (root.right != null) {
			temp = closestValue(root.right, target);
			return Math.abs(temp - target) > Math.abs(root.val - target) ? root.val : temp;
		} else
			return root.val;

	}

	public int closestValue1(TreeNode root, double target) { // Just another way
																// of doing same
																// thing.
		TreeNode child = null;
		if (root.val > target)
			child = root.left;
		else
			child = root.right;
		if (child == null)
			return root.val;
		int val = closestValue(child, target);
		return Math.abs(val - target) > Math.abs(root.val - target) ? root.val : val;

	}
}
