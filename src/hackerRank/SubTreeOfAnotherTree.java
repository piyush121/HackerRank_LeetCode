/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 *
 */
public class SubTreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		if (s.val == t.val && checkTree(s, t))
			return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);

	}

	public boolean checkTree(TreeNode s, TreeNode t) {
		if (s == t)
			return true;
		if (s == null || t == null)
			return false;
		if (s.val == t.val)
			return checkTree(s.left, t.left) && checkTree(s.right, t.right);
		return false;

	}
}
