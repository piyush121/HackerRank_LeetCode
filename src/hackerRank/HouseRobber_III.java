package hackerRank;

/*
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 *  called the "root." Besides the root, each house has one and only one parent house. After a tour, the 
 *  smart thief realized that "all houses in this place forms a binary tree". It will automatically contact 
 *  the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobber_III {
	public int rob(TreeNode root) { // Super efficient DP based solution.
		int[] res = dfs(root);
		return Math.max(res[0], res[1]);
	}

	private int[] dfs(TreeNode root) {
		if (root == null)
			return new int[] { 0, 0 };
		int[] res = new int[2];
		int[] left = dfs(root.left); // Tricky part.
		int[] right = dfs(root.right);

		res[0] = root.val + left[1] + right[1]; // By robbing current house.
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // Without robbing current house.
		return res;
	}

	public int rob1(TreeNode root) { // Naive DFS solution.
		if (root == null)
			return 0;

		int withRoot = root.val;
		int withoutRoot = 0;
		if (root.left != null)
			withRoot = root.val + rob1(root.left.left) + rob1(root.left.right);
		if (root.right != null)
			withRoot += rob1(root.right.left) + rob1(root.right.right);
		withoutRoot += rob1(root.left) + rob1(root.right);

		return Math.max(withRoot, withoutRoot);
	}
}
