/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode p1 = dummy1;
		ListNode p2 = dummy2;

		ListNode runner = head;
		while (runner != null) {
			if (runner.val < x) {
				p1.next = runner;
				p1 = p1.next;
			} else {
				p2.next = runner;
				p2 = p2.next;
			}

		}

		p2.next = null;
		p1.next = dummy2.next;
		return dummy1.next;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
