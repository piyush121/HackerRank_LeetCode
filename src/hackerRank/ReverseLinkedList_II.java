/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 *
 */
public class ReverseLinkedList_II {
	public static ListNode reverseBetween(ListNode head, int m, int n) { // Was
																			// a
																			// hard
																			// one.
																			// Don't
																			// know
																			// why.
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		for (int i = 0; i < m - 1; i++)
			prev = prev.next;
		ListNode curr = prev.next;

		for (int i = 0; i < n - 1; i++) {
			ListNode next = curr.next;
			curr.next = next.next;
			next.next = prev.next;
			prev.next = next;
		}

		return dummy.next;

	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(3);
		ListNode list2 = new ListNode(5);
		list1.next = list2;
		list2.next = null;

		reverseBetween(list1, 1, 2);
	}

}
