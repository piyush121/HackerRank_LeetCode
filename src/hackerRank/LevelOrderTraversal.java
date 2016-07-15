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
	public List<List<Integer>> levelOrder2(TreeNode root) { // Works even more efficiently. DFS based recursive solution.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		helper (result, root, 0);
		return result;
		}
	private void helper(List<List<Integer>> res, TreeNode root, int level) {
		if(root == null)
			return;
		if(level == res.size()) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			res.add(list);
		}
		else {
			List<Integer> list = res.get(level);
			list.add(root.val);
		}
		
		helper(res, root.left, level + 1);
		helper(res, root.right, level + 1);
			
	}
	
	
	public List<List<Integer>> levelOrder1(TreeNode root) { // Works efficiently. BFS solution.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> curr = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		curr.add(root);
		while (!curr.isEmpty()) {
			int size = curr.size();
			for (int i = 0; i < size; i++) {
				TreeNode temp = curr.poll();
				list.add(temp.val);
				if (temp.left != null)
					curr.add(temp.left);
				if (temp.right != null)
					curr.add(temp.right);
			}
			result.add(list);
			list = new ArrayList<Integer>();
		}

		return result;

	}
	
	public List<List<Integer>> levelOrder2(TreeNode root) { // Works but not very efficient. Can use only 1 queue instead of two..
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
