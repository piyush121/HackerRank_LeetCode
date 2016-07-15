/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 *
 */
public class ZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) { //Since I used 2 Stacks so it is not so efficient.
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			while (!s1.isEmpty()) {
				TreeNode temp = s1.pop();
				list1.add(temp.val);
				if (temp.left != null)
					s2.push(temp.left);
				if (temp.right != null)
					s2.push(temp.right);
			}
			if(list1.size() > 0) result.add(list1);
			while (!s2.isEmpty()) {
				TreeNode temp = s2.pop();
				list2.add(temp.val);
				if (temp.right != null)
					s1.push(temp.right);
				if (temp.left != null)
					s1.push(temp.left);
			}
			
			if(list2.size() > 0 ) result.add(list2);

		}
		
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
