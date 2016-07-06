/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
 *
 */
public class InOrderBinaryTree {
	public List<Integer> inorderTraversal(TreeNode root) { //Most concise solution.
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		TreeNode curr = root;
		stack.push(root);

		while (!stack.isEmpty()) {

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			result.add(curr.val);
			curr = curr.right;

		}
		return result;

	}
	
	public List<Integer> inorderTraversal1(TreeNode root) { // Semi-concise solution.
	     Stack<TreeNode> stack = new Stack<>();
			List<Integer> result = new ArrayList<>();
			TreeNode curr = root;
			while (curr != null || !stack.isEmpty()) {
			    if(curr!= null)
	                stack.add(curr);
				while (curr != null) {
					curr = curr.left;
					if(curr != null)
					stack.push(curr);
				}
				curr = stack.pop();
				result.add(curr.val);
				curr = curr.right;

			}
			return result;

				
			}

	public List<Integer> inorderTraversal2(TreeNode root) { // Recursive solution. Most efficient and clear.
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, List<Integer> result) {
		if (root == null)
			return;
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
