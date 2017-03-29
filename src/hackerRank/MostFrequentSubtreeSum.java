/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */
public class MostFrequentSubtreeSum {
	int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) { // O(N) time and space.
		Map<Integer, Integer> map = new HashMap<>();
		findFrequentTreeSum(root, map);
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> pair : map.entrySet())
			if (pair.getValue() == max)
				list.add(pair.getKey());
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = list.get(i);
		return res;
	}
	// Basically get left sum and right sum add them and add its count in the map.
	public int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> map) {
		if (root == null)
			return 0;
		int leftSum = findFrequentTreeSum(root.left, map);
		int rightSum = findFrequentTreeSum(root.right, map);
		int currSum = root.val + leftSum + rightSum;
		if (!map.containsKey(currSum))
			map.put(currSum, 0);
		int count = map.get(currSum);
		map.put(currSum, ++count);
		max = Math.max(max, count);
		return currSum;
	}
}
