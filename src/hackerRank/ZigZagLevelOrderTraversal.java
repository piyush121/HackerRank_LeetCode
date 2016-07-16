/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 *
 */
public class ZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) { // DFS based efficient recursive solution.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		helper(result, root, 0);
		
		return result;
	}
	
	private void helper (List<List<Integer>> res, TreeNode node, int level) {
		if(node == null)
			return;
		
		if(level == res.size()) {
			List<Integer> list = new LinkedList<>();
			list.add(node.val);
			res.add(list);
		}
		
		else {
			List<Integer> list = res.get(level);
			if(level % 2 == 0)
				list.add(node.val);
			else 
				list.add(0, node.val);
			}
		helper(res, node.left, level + 1);
		helper(res, node.right, level + 1);
		
	}
	
	
	public List<List<Integer>> zigzagLevelOrder1(TreeNode root) { //Since I used 2 Stacks so it is not so efficient. O(n) Space and time.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		TreeNode temp = null;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			List<Integer> list1 = new ArrayList<>();

			while (!s1.isEmpty()) {
				temp = s1.pop();
				list1.add(temp.val);
				if (temp.left != null)
					s2.push(temp.left);
				if (temp.right != null)
					s2.push(temp.right);
			}

			result.add(list1);
			list1 = new ArrayList<>();
			while (!s2.isEmpty()) {
				temp = s2.pop();
				list1.add(temp.val);
				if (temp.right != null)
					s1.push(temp.right);
				if (temp.left != null)
					s1.push(temp.left);
			}

			if (!list1.isEmpty())
				result.add(list1);

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
