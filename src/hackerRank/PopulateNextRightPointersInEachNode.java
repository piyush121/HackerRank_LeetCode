/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 *
 */
public class PopulateNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) { //Most efficient recursive code.
	    if(root == null)
	        return;
	        
	    if(root.left != null){
	        root.left.next = root.right; //Connect left and right,
	        if(root.next != null) // go to next.
	            root.right.next = root.next.left; // connect right and next subtree.
	    }
	    
	    connect(root.left); // recurse on both child.
	    connect(root.right);
	}
	
	
	public void connect2(TreeLinkNode root) { //Highly efficient Iterative solution. O(n) time and O(1) space.
		if (root == null)
			return;
		TreeLinkNode last = root;
		TreeLinkNode curr = null;

		while (last.left != null) {
			curr = last;
			while (curr != null) {
				curr.left.next = curr.right;
				if (curr.next != null)
					curr.right.next = curr.next.left;
				curr = curr.next;
			}
			last = last.left;
		}
	}
	
	
	public void connect1(TreeLinkNode root) { //Recursive inefficient code.
		if (root == null)
			return;
		helper(root.left, root.right);
	}

	private void helper(TreeLinkNode node1, TreeLinkNode node2) {
		if (node1 == null)
			return;
		node1.next = node2;
		helper(node1.left, node1.right);
		helper(node1.right, node2.left);
		helper(node2.left, node2.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
