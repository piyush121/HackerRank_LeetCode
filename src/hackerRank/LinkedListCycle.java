/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) { // Easy breezy.
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null || fast.next.next != null) { // if there is a
																// cycle then
																// slow and fast
																// has to meet.
																// No matter
																// what.
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
