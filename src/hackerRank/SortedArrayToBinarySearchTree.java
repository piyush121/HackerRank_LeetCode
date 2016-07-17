/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 *
 * 
 * 
 */
public class SortedArrayToBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {//Pretty good Recursive solution.

		if (nums.length == 0)
			return null;
		return helper(0, nums.length - 1, nums);
	}

	private TreeNode helper(int start, int end, int[] nums) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(nums[mid]);

		node.left = helper(start, mid - 1, nums);
		node.right = helper(mid + 1, end, nums);

		return node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
