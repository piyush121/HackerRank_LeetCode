/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * 
 */
public class SortList {
	public ListNode sortList(ListNode head) { // O(NLOGN) time and O(logN) space due to recursion.
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode rear = dummy;
		ListNode front = dummy;
		while (front != null && front.next != null) { // cutting in half.
			rear = rear.next;
			front = front.next.next;
		}
		front = rear.next;
		rear.next = null;

		ListNode left = sortList(dummy.next);
		ListNode right = sortList(front);
		head = merge(left, right);
		return head;

	}

	private ListNode merge(ListNode head, ListNode right) {// Regular merge method.
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left = dummy;
		while (left.next != null && right != null) {
			if (left.next.val > right.val) {
				ListNode next = left.next;
				left.next = right;
				right = right.next;
				left.next.next = next;
			} else {
				left = left.next;
			}

		}

		if (right != null)
			left.next = right;
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
