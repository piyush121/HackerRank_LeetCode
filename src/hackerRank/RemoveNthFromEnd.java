package hackerRank;

public class RemoveNthFromEnd {// O(n) solution

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode front = head;
		ListNode back = head;
		ListNode prev = null;
		int count = 0;
		while (front != null) {
			front = front.next;
			count++;
			if (count > n) {
				prev = back;
				back = back.next;
			}

		}
		if (prev != null) {
			prev.next = back.next;
			return head;
		}
		return head.next;
	}

}
