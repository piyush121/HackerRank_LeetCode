package hackerRank;

public class RevLL {
	
	public static void reverse(ListNode node){ // amazing recursive approach. O(n) space O(n) time
		if(node.next==null)
			return;
		
		reverse(node.next);
		ListNode curr=node.next;
		curr.next=node;
		node.next=null;
		
	}
	public static void reverseitr(ListNode node) // iterative approach. O(1) space O(n) time.
	{
		ListNode prev=null;
		ListNode curr=node;
		ListNode next=curr.next;
		while(curr!=null){
			curr.next=prev;
			prev=curr;
			curr=next;
			if(curr!=null) // boundary case when curr reaches end.
				next=curr.next;
			
		}
	}
	public static void main(String[] args) {
		ListNode l1=new ListNode(3);
		l1.next=new ListNode(7);
		l1.next.next=new ListNode(9);
		ListNode ptr=l1.next.next;
		reverseitr(l1);
		
		while(ptr!=null)
			{
				System.out.println(ptr.val);
				ptr=ptr.next;
			}
	
	}

}
