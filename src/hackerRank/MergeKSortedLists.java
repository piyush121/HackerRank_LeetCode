/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) { // Brutefirce way. but works well !
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
}
