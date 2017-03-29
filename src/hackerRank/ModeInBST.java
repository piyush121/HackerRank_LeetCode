/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 *
 */
public class ModeInBST {
	int maxMode = 0;
	int mode = 0;
	Integer prev = null;
	List<Integer> res = new ArrayList<>();

	public int[] findMode(TreeNode root) { // O(N) time and space.
		inorder(root);
		int[] modes = new int[res.size()];
		int i = 0;
		for (int val : res)
			modes[i++] = val;
		return modes;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev == null) {
			prev = root.val;
		}
		if (prev == root.val) {
			mode++;
		} else {
			mode = 1;
		}
		if (mode == maxMode)
			res.add(root.val);
		else if (mode > maxMode) {
			res.clear();
			res.add(root.val);
			maxMode = mode;
		}

		prev = root.val;

		inorder(root.right);
	}
}
