/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreOrderAndInOrderTraversal {

	public static TreeNode buildTree(int[] preorder, int[] inorder) { // Really
																		// good
																		// recursive
																		// solution.
																		// Not
																		// very
																		// efficient
																		// though.

		TreeNode root = helper(0, 0, inorder.length - 1, preorder, inorder);

		return root;
	}

	private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
		if (inStart > inEnd || preStart >= preOrder.length)
			return null;
		TreeNode node = new TreeNode(preOrder[preStart]);
		int index = 0;
		for (int j = inStart; j <= inEnd; j++) {
			if (preOrder[preStart] == inOrder[j]) {
				index = j;

			}
		}

		node.left = helper(preStart + 1, inStart, index - 1, preOrder, inOrder);
		node.right = helper(index + preStart - inStart + 1, index + 1, inEnd, preOrder, inOrder);
		/*
		 * --------OR------- 
		 * int leftTreeLen = index - inStart; 
		 * node.left = helper(preStart + 1, inStart, index - 1, preOrder, inOrder );
		 *  node.right = helper(preStart + leftTreeLen + 1, index + 1, inEnd, preOrder,inOrder);
		 * Easier to understand I think.
		 */

		return node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildTree(new int[] { 1, 2, 3 }, new int[] { 2, 3, 1 });

	}

}
