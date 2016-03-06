package hackerRank;

public class RevLL {
	
	public static void reverse(ListNode node){
		if(node.next==null)
			return;
		
		reverse(node.next);
		ListNode curr=node.next;
		curr.next=node;
		node.next=null;
		
	
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
