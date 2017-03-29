/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
 *
 */
public class FindBottomLeftTreeValue {
	
	int res = 0;
	int depth = 0;

	public int findBottomLeftValue(TreeNode root) { // DFS way. O(N) time and (H) space.
		dfs(root, 0);
		return res;
	}

	public void dfs(TreeNode root, int height) {
		if (root == null)
			return;
		if (depth < height + 1) {
			res = root.val;
			depth = height + 1;
		}
		dfs(root.left, height + 1);
		dfs(root.right, height + 1);

	}
	
	public int findBottomLeftValue1(TreeNode root) { // BFS. O(N) time and space.
		int res = 0;
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.offer(root);

		while (!nodes.isEmpty()) {
			int size = nodes.size();
			TreeNode curr = nodes.peek();
			res = curr.val;
			for (int i = 0; i < size; i++) {
				TreeNode parent = nodes.poll();
				if (parent.left != null)
					nodes.offer(parent.left);
				if (parent.right != null)
					nodes.offer(parent.right);
			}
		}
		return res;
	}
}
