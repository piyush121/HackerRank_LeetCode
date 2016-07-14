/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 */
public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) { // Works but not very efficient.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> prev = new ArrayDeque<>();
		Queue<TreeNode> curr = new ArrayDeque<>();
		List<Integer> list = new ArrayList<>();
		prev.add(root);
		while (!prev.isEmpty()) {
			TreeNode temp = prev.poll();
			list.add(temp.val);
			if(temp.left != null) curr.add(temp.left);
			if(temp.right != null) curr.add(temp.right);
			if (prev.isEmpty()) {
				prev = curr;
				curr = new ArrayDeque<>();
				result.add(list);
				list = new ArrayList<Integer>();
			}
		}
		return result;

	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
