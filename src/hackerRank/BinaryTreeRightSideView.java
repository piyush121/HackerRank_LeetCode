/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 *  return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 *
 */
public class BinaryTreeRightSideView {
	int depth = 0;

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, 1, res);
		return res;
	}

	private void dfs(TreeNode root, int level, List<Integer> res) {
		if (root == null)
			return;
		if (level > depth) {
			res.add(root.val);
			depth++;
		}
		dfs(root.right, level + 1, res);
		dfs(root.left, level + 1, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
