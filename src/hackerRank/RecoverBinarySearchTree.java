/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 *
 */
public class RecoverBinarySearchTree {
	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) { // O(n) space which can be reduced by Morris traversal.
		
		
		traverse(root);
		
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
	
	private void traverse(TreeNode root) {
		
		if(root == null)
			return;
		
		traverse(root.left);
		//Main part of Inorder starts here.
		
		if(first == null && prev.val >= root.val)
			first = prev;
		
		if(first != null && prev.val >= root.val)
			second = root;
		
		traverse(root.right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
