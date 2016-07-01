/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 *
 */
public class RemoveDuplicatesFromSOrtedList {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode front = head;

		while (front != null) {
			if (front.next == null)
				break;
			if (front.next.val == front.val) {
				front.next = front.next.next;
			} else {
				front = front.next;
			}

		}

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
