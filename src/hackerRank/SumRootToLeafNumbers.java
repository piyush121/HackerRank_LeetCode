/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 *
 */
public class SumRootToLeafNumbers {
	int sum;

	public int sumNumbers(TreeNode root) { // Efficient. O(N) time O(N) space.
		if (root == null)
			return 0;
		DFS(root, 0);
		return sum;
	}

	private void DFS(TreeNode root, int val) {
		if (root.left == null && root.right == null) {

			sum += val * 10 + root.val;
			return;
		}
		if (root.left != null) // go left only if its not null
			DFS(root.left, val * 10 + root.val);
		if (root.right != null)
			DFS(root.right, val * 10 + root.val);
	}

	public int sumNumbers1(TreeNode root) { // Works but not very efficient. We
											// can do it without the list part
		if (root == null)
			return 0;
		List<Integer> nums = new ArrayList<Integer>();
		DFS(root, nums);
		return sum;
	}

	private void DFS(TreeNode root, List<Integer> nums) {
		if (root.left == null && root.right == null) {
			nums.add(root.val);
			int temp = 0;
			for (int i = 0; i < nums.size(); i++) {
				temp = temp * 10 + nums.get(i);
			}
			sum += temp;
			nums.remove(nums.size() - 1);
			return;
		}
		nums.add(root.val);
		if (root.left != null)
			DFS(root.left, nums);
		if (root.right != null)
			DFS(root.right, nums);
		nums.remove(nums.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
