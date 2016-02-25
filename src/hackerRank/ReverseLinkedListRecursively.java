package hackerRank;

public class ReverseLinkedListRecursively {
	
	public static void reverse(ListNode head){
		if(head.next==null)
			return;
			
		reverse(head.next);
		ListNode curr=head.next;
		curr.next=head;
		head.next=null;
		
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(3);
		l1.next=new ListNode(7);
		l1.next.next=new ListNode(9);
		ListNode ptr=l1.next.next;
		
		reverse(l1);
		
		while(ptr!=null)
			{
				System.out.println(ptr.val);
				ptr=ptr.next;
			}
	}

}
