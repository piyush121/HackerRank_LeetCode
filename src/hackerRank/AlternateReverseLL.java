package hackerRank;

/**
 * @author Piyush Chaudhary
 *
 *	Given a LL, A1->A2->A3->...A(n-1)->And you need to rearrange it to A1->A(n-1)->A2->A(n-2)->...
 */
public class AlternateReverseLL {
	
	public static void reverseLL(LinkNode node) { //O(n)
		if(node == null || node.next == null)
			return ;
		LinkNode prev = null;
		LinkNode curr = node;
		LinkNode next = node.next;
		while(curr.next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if(next != null)
				next = next.next;
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
		while(ptr != null) {
			System.out.println(last.data + " -> ");
			ptr = ptr.next;
		}
		
		
	}
}
