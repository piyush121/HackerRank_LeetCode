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
	int depth = 0; // No depth has been gone through initially.

	public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
		dfs(root, 1, res);
		return res;
	}

	private void dfs(TreeNode root, int level, List<Integer> res) {
		if (root == null)
			return;
		if (level > depth) { // Check if the current level is greater than the already seen depth.
			res.add(root.val);
			depth++; // Increase depth to check in future.
		}
			dfs(root.right, level + 1, res); //Go right first because you're on the right side.
			dfs(root.left, level + 1, res); // Go left to check whether it has got more depth than the current seen depth.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
