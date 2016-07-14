/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
            return true;
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null && n2 != null || n1 != null && n2 == null)
			return false;
		if (n1.val != n2.val)
			return false;

		return helper(n1.left, n2.right) && helper(n1.right, n2.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
