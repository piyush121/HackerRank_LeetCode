/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * 
 * 
 */
public class SortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {// Good Recursive solution!
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (prev != null)
			prev.next = null;
		TreeNode node = new TreeNode(slow.val);

		node.left = sortedListToBST(head);
		node.right = sortedListToBST(slow.next);

		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
