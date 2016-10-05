/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 */
public class MergeKSortedLists {
	public ListNode mergeKLists1(ListNode[] lists) { // Brutefirce way. but
														// works well !
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		int nullCounter = 0;
		while (nullCounter != lists.length) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			ListNode minNode = null;
			nullCounter = 0;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] == null) {
					nullCounter++;
					continue;
				}
				if (lists[i].val < min) {
					min = lists[i].val;
					minIdx = i;
					minNode = lists[i];
				}
			}
			ptr.next = minNode;
			if (lists[minIdx] != null) {
				lists[minIdx] = minNode.next;
				minNode.next = null;
			}
			ptr = ptr.next;
		}

		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists) { // Priority Queue based
													// efficient solution. O(nklogk)

		PriorityQueue<ListNode> que = new PriorityQueue<>(new Comparator<ListNode>() {
			public int compare(ListNode obj1, ListNode obj2) {
				return obj1.val - obj2.val;
			}
		});

		for (ListNode node : lists) {
			if (node != null)
				que.add(node);
		}
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		while (!que.isEmpty()) {
			ListNode node = que.poll();
			ptr.next = node;
			ptr = ptr.next;
			if (node.next != null) // Don't add null into PQ.
				que.add(node.next);

		}
		return dummy.next;
	}
}
