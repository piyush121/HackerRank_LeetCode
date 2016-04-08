package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 *         Given a LL, A1->A2->A3->...A(n-1)->And you need to rearrange it to
 *         A1->A(n-1)->A2->A(n-2)->...
 */
public class AlternateReverseLL {

	public static LinkNode reverseLL(LinkNode node) { // O(n)
		if (node == null || node.next == null)
			return node;
		LinkNode prev = null;
		LinkNode curr = node;
		LinkNode next = node.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null)
				next = next.next;
		}
		return prev;
	}

	public static void alternateReverseLL(LinkNode node) {
		int size = 0;
		LinkNode ptr = node;
		while (ptr != null) { // Find size of LL. O(n)
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
			size++;
		}
		int mid = size / 2;
		LinkNode first = node;
		LinkNode second = null;
		ptr = first;

		while (mid > 0) {
			ptr = ptr.next;
			mid--;
		}
		LinkNode temp = ptr.next;
		ptr.next = null;
		second = temp;
		second = reverseLL(second); // O(n)
		mergeList(first, second);
	}

	public static void mergeList(LinkNode first, LinkNode second) {
		if (first == null || second == null)
			return;
		LinkNode temp1 = first.next;
		LinkNode temp2 = second.next;

		while (first != null && second != null) {
			first.next = second;
			second.next = temp1;
			first = temp1;
			second = temp2;
			if (temp1 != null)
				temp1 = temp1.next;
			if (temp2 != null)
				temp2 = temp2.next;

		}
	}

	public static void main(String[] args) {
		LinkNode node = new LinkNode(1);
		node.next = new LinkNode(2);
		node.next.next = new LinkNode(3);
		node.next.next.next = new LinkNode(4);
		LinkNode last = new LinkNode(5);
		node.next.next.next.next = last;
		reverseLL(node);
		LinkNode ptr = last;
		while (ptr != null) {
			System.out.print(ptr.data + " -> ");
			ptr = ptr.next;
		}

	}
}
