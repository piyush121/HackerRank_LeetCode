/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) { //Recursive approach.
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		TreeNode right = root.right;

		if (root.left != null) {
			root.right = root.left;
			root.left = null;

		}
		while (root.right != null)
			root = root.right;

		root.right = right;

	}
	
	
	
	public void flatten1(TreeNode root) { // Kind of hard to understand. A lot
											// going here.In-place non recursive solution.
		if (root == null)
			return;

		TreeNode curr = root;

		while (curr != null) {
			TreeNode prev = curr.left;
			if (prev != null) {
				while (prev.right != null)
					prev = prev.right;

				prev.right = curr.right; //Sort of Morris traversal.
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;

		}
		
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}