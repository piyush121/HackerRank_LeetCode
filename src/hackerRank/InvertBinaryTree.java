/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew),
 but you can’t invert a binary tree on a whiteboard so fuck off.
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) { // easy recursive implementation.
        if (root == null)
            return null;
            
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        root.left = right;
        root.right = left;
        return root;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
