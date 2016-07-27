/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */
public class LinkedListCycle_II {
	public ListNode detectCycle(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy;
		ListNode fast = slow;
		slow.next = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}

		if (slow == fast) { // When slow and fast will meet, they will be equidistant from the head.
			slow = dummy;
			while (fast != slow) {
				slow = slow.next;
				fast = fast.next;
			}

			return slow;

		}

		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
