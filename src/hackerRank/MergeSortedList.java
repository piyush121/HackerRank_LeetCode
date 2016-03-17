package hackerRank;

public class MergeSortedList {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        
	        ListNode dummy=new ListNode(0);
	        ListNode prev=dummy;
	        dummy.next=l1;
	        while(l1!=null && l2 !=null) {
	            if(l1.val>l2.val) {
	                prev.next=l2;
	                l2=l2.next;
	                prev=prev.next;
	            }
	            else {
	            	prev.next=l1;
	                prev=prev.next;
	                l1=l1.next;
	            }
	                
	        }
	        
	        if(l1!=null)
	            prev.next=l1;
	        if(l2!=null)
	            prev.next=l2;
	        return dummy.next;
	                
	    }

}
