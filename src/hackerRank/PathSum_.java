/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */
public class PathSum_ {
	public boolean hasPathSum(TreeNode root, int sum) { //Easy one.
		if (root == null) // base case.
			return false;
		if (root.val == sum && root.left == null && root.right == null) // The node should be the leaf node at which the sum is equal to its value.
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val); // keep reducing the sum during recursion until it is equal to the value of leaf node.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
