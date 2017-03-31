/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
 *
 */
public class FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) { // DFS based solution. O(N) time and O(H)space.
		List<Integer> res = new ArrayList<>();
		dfs(root, res, 0);
		return res;
	}

	public void dfs(TreeNode root, List<Integer> res, int depth) {
		if (root == null)
			return;
		if (depth == res.size())
			res.add(root.val);
		else
			res.set(depth, Math.max(res.get(depth), root.val));

		dfs(root.left, res, depth + 1);
		dfs(root.right, res, depth + 1);
	}
}
