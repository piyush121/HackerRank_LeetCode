/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 */
public class InOrderSuccessorBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) { // RECURSIVE VERSION. O(n) space and time.
		if(root == null)
            return root;
		if (root.val > p.val) { // `p` is on the left.
			TreeNode left = inorderSuccessor(root.left, p);//find that node's successor.
			if (left == null) // successor not found. Means root itself is the successor.
				return root;
			else
				return left; // Successor found.
		} else {
			TreeNode right = inorderSuccessor(root.right, p);
			if (right != null)
				return right;
			else
				return null;
		}		
	}
	
	
	public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) { // Iterative version. O(1) space. O(n) time.
		TreeNode succ = null;
		while (root != null) {
			if (root.val > p.val) {
				succ = root;
				root = root.left;
			}
			else
				root = root.right;
		}
		return succ;
	}
	/*
	 * The idea is to compare root's value with p's value if root is not null,
	 * and consider the following two cases:
	 * 
	 * 1) root.val > p.val. In this case, root can be a possible answer, so we
	 * store the root node first and call it res. However, we don't know if
	 * there is anymore node on root's left that is larger than p.val. So we
	 * move root to its left and check again.
	 * 
	 * 2) root.val <= p.val. In this case, root cannot be p's inorder successor,
	 * neither can root's left child. So we only need to consider root's right
	 * child, thus we move root to its right and check again.
	 * 
	 * We continuously move root until exhausted. To this point, we only need to
	 * return the res in case 1.
	 * 
	 */
}
