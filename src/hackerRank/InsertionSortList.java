/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Sort a linked list using insertion sort.
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) { //Pretty efficient.
		if (head == null || head.next == null)
			return head;
		ListNode curr = head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;

		while (curr.next != null) {
			if (curr.val > curr.next.val) {
				while (first.next.val < curr.next.val) // All messy stuff but make complete sense if you can think.
					first = first.next;
				ListNode node = curr.next;
				curr.next = node.next;
				node.next = first.next;
				first.next = node;
				first = dummy;

			} else
				curr = curr.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
