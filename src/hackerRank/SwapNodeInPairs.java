package hackerRank;

public class SwapNodeInPairs {
	public ListNode swapPairs(ListNode head) { // O(n) time and O(1) space.

		if (head == null)
			return head;
		ListNode prev = head;
		ListNode curr = head.next;
		while (curr != null) {
			int val = curr.val;
			curr.val = prev.val;
			prev.val = val;
			prev = prev.next.next;
			if (prev != null)
				curr = curr.next;
			curr = curr.next;
		}
		return head;
	}
}
