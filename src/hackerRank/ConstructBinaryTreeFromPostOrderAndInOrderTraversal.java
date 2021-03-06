/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPostOrderAndInOrderTraversal { 
	public TreeNode buildTree(int[] inorder, int[] postorder) { // Works well enough. But not super Efficient as its a recursive one.
		TreeNode root = helper (0, inorder.length - 1, postorder.length - 1, inorder, postorder);
		return root;
	}
	
	private TreeNode helper(int inStart, int inEnd, int postEnd, int[] inOrder, int[] postOrder){
		if(inStart > inEnd || postEnd < 0)
			return null;
		
		TreeNode node = new TreeNode(postOrder[postEnd]);
		int index = 0;
		for(int i = inStart;i <= inEnd; i++) {
			if(inOrder[i] == postOrder[postEnd])  {
				index = i;
				break; //no need go go forward .
			}
		}
		int rightLen = inEnd - index;
		node.right = helper (index + 1, inEnd, postEnd - 1, inOrder, postOrder);
		node.left = helper(inStart, index - 1, postEnd - rightLen - 1, inOrder, postOrder);
		
		return node;
	}
	
	 public TreeNode buildTree1(int[] inorder, int[] postorder) { // Works efficiently because of the reverse for loop. :S
			TreeNode root = helper1(inorder.length - 1,0, postorder.length - 1, inorder, postorder);
			return root;
		}
		
		private TreeNode helper1(int inStart, int inEnd, int postEnd, int[] inOrder, int[] postOrder){
			if(inStart < inEnd)
				return null;
			
			TreeNode node = new TreeNode(postOrder[postEnd]);
			if(inStart == inEnd)
			    return node;
			int index = 0;
			for(int i = inStart;i >= inEnd; i--) {
				if(inOrder[i] == node.val)  {
					index = i;
					break; //no need go forward .
				}
			}
			node.right = helper1 ( inStart, index + 1, postEnd - 1, inOrder, postOrder);
			node.left = helper1(index - 1, inEnd,  postEnd - (inStart - index) - 1, inOrder, postOrder);
			
			return node;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
