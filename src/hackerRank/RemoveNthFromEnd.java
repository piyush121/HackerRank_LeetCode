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
	
	 public ListNode removeNthFromEnd1(ListNode head, int n) { //Another slightly  better solution.
	        
	      ListNode dummy=new ListNode(0);
	      dummy.next=head;
	      ListNode front=dummy;
	      ListNode back=dummy;
	      
	      for(int i=0;i<=n;i++) {
	          front=front.next;
	      }
	      while(front!=null) {
	          front=front.next;
	          back=back.next;
	      }
	    back.next=back.next.next;
	    return dummy.next;
	    }

}
