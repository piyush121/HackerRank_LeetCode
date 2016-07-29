/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) { // A clever hack to store post order result by using reverse of pre-order.
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		Stack<TreeNode> s1 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode node = s1.pop();
			res.addFirst(node.val);
			if (node.left != null) {
				s1.add(node.left);
			}
			if (node.right != null)
				s1.add(node.right);
		}

		return res;

	}
	
	
	public List<Integer> postorderTraversal(TreeNode root) { // standard iterative way.
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.add(root);
		while (!s1.isEmpty()) {
			TreeNode node = s1.pop();
			s2.add(node);
			if (node.left != null) // because we want to add left after we add right in the final s2 stack.
				s1.add(node.left);
			if (node.right != null)
				s1.add(node.right);
		}
		while (!s2.isEmpty())
			res.add(s2.pop().val);
		return res;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
