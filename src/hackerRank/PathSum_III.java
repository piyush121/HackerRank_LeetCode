/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 *
 */
public class PathSum_III {
	int count = 0;
	// Think of it like an array to find all sub-arrays with sum = k;
	// O(N) space and time.
	public int pathSum(TreeNode root, int sum) { 
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		dfs(root, sum, 0, map);
		return count;
	}

	public void dfs(TreeNode root, int sum, int currSum, Map<Integer, Integer> preSums) {
		if (root == null)
			return;
		currSum += root.val;
		if (preSums.containsKey(currSum - sum))
			count += preSums.get(currSum - sum);
		preSums.putIfAbsent(currSum, 0);
		preSums.put(currSum, preSums.get(currSum) + 1);
		dfs(root.left, sum, currSum, preSums);
		dfs(root.right, sum, currSum, preSums);
		preSums.put(currSum, preSums.get(currSum) - 1);
	}
}
