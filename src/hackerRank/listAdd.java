package hackerRank;

/**
  Definition for singly-linked list.*/
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class listAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int borrow=0;
    	ListNode node=new ListNode(l1.val+l2.val);
        ListNode ptr=node;
        	if(ptr.val>9)
      			{
      				ptr.val=ptr.val%10;
      				borrow=1;
      			}
       	
      	l1=l1.next;
      	l2=l2.next;
      	while (l1!=null && l2!=null)
      	{
      		ptr.next=new ListNode(l1.val+l2.val+borrow);
      		borrow=0;
      		ptr=ptr.next;
      		if(ptr.val>9)
      			{
      				ptr.val=ptr.val%10;
      				borrow=1;
      			}
      		l1=l1.next;
          	l2=l2.next;
      		
      	}
      	while(l1!=null)
      	{
      		ptr.next=new ListNode(l1.val+borrow);
      		ptr=ptr.next;
      		l1=l1.next;
      		borrow=0;
      		if(ptr.val>9)
  			{
  				ptr.val=ptr.val%10;
  				borrow=1;
  			}
      	}
      	while(l2!=null)
      	{
      		ptr.next=new ListNode(l2.val+borrow);
      		ptr=ptr.next;
      		l2=l2.next;
      		borrow=0;
      		if(ptr.val>9)
  			{
  				ptr.val=ptr.val%10;
  				borrow=1;
  			}
      	}
      	if(borrow==1)
      		ptr.next=new ListNode(1);
          
      	return node;
          
    }
    
    public static void main(String[] args) {
    	ListNode l1=new ListNode(3);
		l1.next=new ListNode(7);
		ListNode l2=new ListNode(9);
		l2.next=new ListNode(2);
		System.out.println(addTwoNumbers(l1,l2).val);
	}
}