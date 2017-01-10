/**
 * @author Piyush Chaudhary
 */
package hackerRank;
import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 *
 */
public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Integer> cols = new LinkedList<>(); // add node and its column together in separe queues.
		Queue<TreeNode> nodes = new LinkedList<>();

		nodes.add(root);
		cols.add(0);
		int min = 0, max = 0;

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			int col = cols.poll();
			if (!map.containsKey(col))
				map.put(col, new ArrayList<>()); // track buckets of every column.

			map.get(col).add(node.val);

			if (node.left != null) {
				min = Math.min(min, col - 1);
				cols.add(col - 1);
				nodes.add(node.left);
			}
			if (node.right != null) {
				max = Math.max(max, col + 1);
				cols.add(col + 1);
				nodes.add(node.right);
			}
		}

		for (int i = min; i <= max; i++)
			res.add(map.get(i));

		return res;
	}
}
