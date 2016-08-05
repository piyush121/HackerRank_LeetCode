/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5


 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		ptr.next = head;
		while (ptr.next != null) {
			if (ptr.next.val == val) {
				ListNode temp = ptr.next.next;
				ptr.next.next = null;
				ptr.next = temp;
			} else
				ptr = ptr.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
