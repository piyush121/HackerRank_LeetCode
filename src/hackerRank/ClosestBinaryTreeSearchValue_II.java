/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note: Given target value is a floating point. You may assume k is always
 * valid, that is: k ≤ total nodes. You are guaranteed to have only one unique
 * set of k values in the BST that are closest to the target. Follow up: Assume
 * that the BST is balanced, could you solve it in less than O(n) runtime (where
 * n = total nodes)?
 * 
 * Hint:
 * 
 * Consider implement these two helper functions: getPredecessor(N), which
 * returns the next smaller node to N. getSuccessor(N), which returns the next
 * larger node to N. Try to assume that each node has a parent pointer, it makes
 * the problem much easier. Without parent pointer we just need to keep track of
 * the path from the root to the current node using a stack. You would need two
 * stacks to track the path in finding predecessor and successor node
 * separately.
 *
 */
public class ClosestBinaryTreeSearchValue_II {
	public List<Integer> closestKValues(TreeNode root, double target, int k) { // Most
																				// elegant
																				// and
																				// efficient
																				// solution.
		List<Integer> res = new ArrayList<Integer>();
		helper(root, target, k, res);
		return res;
	}

	private void helper(TreeNode root, double target, int k, List<Integer> res) {
		if (root == null)
			return;
		helper(root.left, target, k, res);

		if (res.size() == k) { // keep the window of size `k`.
			if (Math.abs(target - res.get(0)) > Math.abs(target - root.val)) {
				res.remove(0);
				res.add(root.val);
			} else
				return; // No need to go forward as target - higher number will
						// always be more.

		}
		helper(root.right, target, k, res);

	}

	public List<Integer> closestKValues1(TreeNode root, double target, int k) {
		Stack<Integer> smaller = new Stack<>();
		Stack<Integer> bigger = new Stack<>();
		inorder(root, false, target, smaller); // Predecessors.
		inorder(root, true, target, bigger); // Sucecessors.
		List<Integer> res = new ArrayList<>();

		while (res.size() < k) {
			if (bigger.isEmpty())
				res.add(smaller.pop());
			else if (smaller.isEmpty())
				res.add(bigger.pop());

			else if (target - smaller.peek() <= bigger.peek() - target)
				res.add(smaller.pop());
			else if (target - smaller.peek() > bigger.peek() - target)
				res.add(bigger.pop());

		}

		return res;
	}
	// We are essential trying to build two stack one with all smaller nodes than target and one with bigger ones.
	private void inorder(TreeNode node, boolean reverse, double target, Stack<Integer> stk) {
		if (node == null)
			return;
		inorder(reverse ? node.right : node.left, reverse, target, stk);
		// No need to go forward.
		if (!reverse && node.val > target || reverse && node.val <= target)
			return;
		stk.push(node.val);
		inorder(reverse ? node.left : node.right, reverse, target, stk);
	}
}
