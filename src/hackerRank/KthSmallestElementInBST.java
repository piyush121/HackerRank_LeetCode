/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * Hint:
 * 
 * 1. Try to utilize the property of a BST. 2. What if you could modify the BST
 * node's structure? 3. The optimal runtime complexity is O(height of BST).
 *
 */
public class KthSmallestElementInBST {
	int rank = 1;
	Integer res = null;

	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return Integer.MIN_VALUE;
		int left = kthSmallest(root.left, k);
		if (left != Integer.MIN_VALUE)
			return left;
		if (k == 1)
			return root.val;
		int right = kthSmallest(root.right, k - 1);
		if (right != Integer.MIN_VALUE)
			return right;
		return Integer.MIN_VALUE;

	}
}
