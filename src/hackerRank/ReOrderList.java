/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */
public class ReOrderList {
	public void reorderList(ListNode head) { //works well but crazy though.
		if (head == null || head.next == null)
			return;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = slow;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow;
		while (fast.next != null)
			fast = fast.next;
		reverse(slow.next);
		slow.next = null;
		slow = head;

		while (slow != null && fast != null) {
			ListNode Snext = slow.next;
			ListNode Fnext = fast.next;
			slow.next = fast;
			slow = Snext;
			fast.next = Snext;
			fast = Fnext;

		}

	}

	private void reverse(ListNode head) { // fancy way to reverse a linked list.
											// O(N) space though.
		if (head == null || head.next == null)
			return;
		reverse(head.next);
		head.next.next = head;
		head.next = null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
