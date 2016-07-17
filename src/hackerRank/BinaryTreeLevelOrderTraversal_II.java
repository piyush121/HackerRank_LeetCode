/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 *
 */
public class BinaryTreeLevelOrderTraversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) { //Easy recursive DFS solution.
		List<List<Integer>> result = new LinkedList<>();
		helper(root, result, 0);

		return result;
	}

	private void helper(TreeNode node, List<List<Integer>> res, int level) {
		if (node == null)
			return;
		List<Integer> list = null;
		if (level == res.size()) {
			list = new ArrayList<>();
			list.add(node.val);
			res.add(0, list);
		}

		else {
			list = res.get(res.size() - level - 1);
			list.add(node.val);

		}
		helper(node.left, res, level + 1);
		helper(node.right, res, level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
