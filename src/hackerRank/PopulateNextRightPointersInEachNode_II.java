/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 *
 */
public class PopulateNextRightPointersInEachNode_II {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode curr = dummy;
		while(root != null) {
			if(root.left !=null) {
				curr.next = root.left;
				curr = curr.next;
			}
			if (root.right != null) {
				curr.next = root.right;
				curr = curr.next;
				
			}
			root = root.next;
			if(root == null) {
				root = dummy.next;
				curr = dummy;
				dummy.next = null;
			}
		}
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
