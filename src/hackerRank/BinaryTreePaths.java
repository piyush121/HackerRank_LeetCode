/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 *
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		dfs(root, "", res);
		return res;
	}

	public void dfs(TreeNode root, String curr, List<String> res) {// Most Efficient !
		if (root.left == null && root.right == null) {
			res.add(curr + root.val); // Add that leaf node.
			return;
		}
		curr = curr + root.val + "->"; // Figuring out this part was confusing.
		if (root.left != null)
			dfs(root.left, curr, res);
		if (root.right != null)
			dfs(root.right, curr, res);

    }
}
