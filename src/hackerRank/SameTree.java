/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 *
 */
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) { // Easy recursive solution.
		if (p == null && q != null || q == null && p != null)
			return false;
		if (p == null)
			return true;
		if (p.val != q.val)
			return false;
		boolean left = isSameTree(p.left, q.left);
		if (p.val != q.val)
			return false;
		boolean right = isSameTree(p.right, q.right);

		return left && right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
