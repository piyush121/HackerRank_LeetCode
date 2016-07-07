/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *
 */
public class UniqueBinarySearchTrees_II {
	public List<TreeNode> generateTrees(int n) {
		if (n < 1)
			return new ArrayList<TreeNode>();
		return Recursion(1, n);
	}

	private List<TreeNode> Recursion(int start, int end) { //Good one. Takes you into deep thinking !
		List<TreeNode> result = new ArrayList<>();
		if (start > end)
			result.add(null);

		for (int idx = start; idx <= end; idx++) {
			List<TreeNode> left = Recursion(start, idx - 1); //Take a deep breathe of recursion !
			List<TreeNode> right = Recursion(idx + 1, end);

			for (TreeNode leftNode : left) // Generate every combination.
				for (TreeNode rightNode : right) {
					TreeNode node = new TreeNode(idx);
					node.left = leftNode;
					node.right = rightNode;
					result.add(node);
				}

		}

		return result;
	}
}
