/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words,
 * reversing the lists is not allowed.
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 *
 */
public class AddTwoNumbers_II {
	int borrow = 0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) { //O(N) time and space.
		int n1 = 0, n2 = 0;
		ListNode ptr = l1;
		while (ptr != null) {
			ptr = ptr.next;
			n1++;
		}
		ptr = l2;
		while (ptr != null) {
			ptr = ptr.next;
			n2++;
		}
		ListNode head = null;
		ListNode dummy = null;
		if (n1 > n2)
			head = addTwoNumbers(l1, l2, n1 - n2);
		else
			head = addTwoNumbers(l2, l1, n2 - n1);
		if (borrow == 1) {
			dummy = new ListNode(borrow);
			dummy.next = head;
			return dummy;
		}
		return head;
	}
	// Find difference in length and move 1st list to that value and then keep adding.
	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int diff) {
		if (l1 == null && l2 == null)
			return null;
		ListNode next = null;
		if (diff > 0)
			next = addTwoNumbers(l1.next, l2, diff - 1);
		else
			next = addTwoNumbers(l1.next, l2.next, diff);
		int val = 0;
		val += l1 == null ? 0 : l1.val;
		if (diff == 0)
			val += l2 == null ? 0 : l2.val;
		val += borrow;
		borrow = val / 10;
		val = val % 10;
		ListNode curr = new ListNode(val);
		curr.next = next;
		return curr;
	}
}
