package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 *
 */
/**
 * @author Piyush Chaudhary
 *
 */
public class PathSum_II {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) { // List based recursive solution. Good one.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		helper(result, new ArrayList<Integer>(), root, sum);
		return result;
	}

	private static void helper(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
		if (node == null)
			return;
		if (node.left == null && node.right == null && node.val == sum) {
			list.add(node.val);
			res.add(new ArrayList<>(list));
			list.remove(list.size() - 1); //remove the last element and return so that you dont add the last element again.
			return;
		}
		list.add(node.val);

		if (node.left != null)
			helper(res, list, node.left, sum - node.val);

		if (node.right != null)
			helper(res, list, node.right, sum - node.val);

		list.remove(list.size() - 1); //remove last element when done searching both the sides.

	}
	
	
	
	static List<List<Integer>> res = new ArrayList<>();

	public static List<List<Integer>> pathSum1(treeeNode root, int sum) {
		ArrayList<Integer> mylist = new ArrayList<>();

		recurPathSum(root, sum, mylist);
		return res;

	}

	public static void recurPathSum(treeeNode root, int sum, ArrayList<Integer> list1) {

		if (root == null)
			return;
		list1.add(root.data);

		if (root.left == null && root.right == null) {

			if (sum == root.data) {
				res.add(new ArrayList<Integer>(list1));

			}
		} else {
			recurPathSum(root.left, sum - root.data, list1);
			recurPathSum(root.right, sum - root.data, list1);
		}
		list1.remove(list1.size() - 1);

	}

	public static void main(String[] args) {
		treeeNode node1 = new treeeNode(4, null, null);
		treeeNode node2 = new treeeNode(5, null, null);
		treeeNode node3 = new treeeNode(2, null, null);
		treeeNode node4 = new treeeNode(1, null, null);
		treeeNode node5 = new treeeNode(3, null, null);
		treeeNode node6 = new treeeNode(0, null, null);

		binaryTree mytree = new binaryTree();
		mytree.add(node1);
		mytree.add(node2);
		mytree.add(node3);
		mytree.add(node4);
		mytree.add(node5);
		mytree.add(node6);

		pathSum1(mytree.root, 9);
		System.out.println(res);
	}

}
