/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
 *
 */
public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) { // O(n) time and space.
		if (head == null)
			return null;
		int extra = plusOne(head, 0);
		if (extra == 1) {
			ListNode newHead = new ListNode(extra);
			newHead.next = head;
			return newHead;
		}
		return head;

	}

	public int plusOne(ListNode head, int borrow) {
		if (head == null)
			return 1;

		int next = plusOne(head.next, borrow);
		int total = head.val + next;
		head.val = total % 10;
		return total / 10;
	}
}
