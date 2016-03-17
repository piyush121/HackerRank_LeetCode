package hackerRank;

public class MergeSortedList {
	
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) { //O(n).
	        
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
	        
	        if(l1!=null) //Housekeeping stuff at the end.
	            prev.next=l1;
	        if(l2!=null)
	            prev.next=l2;
	        return dummy.next;
	                
	    }
	 
	 public ListNode mergeTwoListsR(ListNode l1, ListNode l2) { // Recursive implementation.
		 if(l1==null)
			 return l2;
		 if(l2==null)
			return l1;
		 ListNode start=null;
		 if(l1.val<l2.val) {
			 start=l1;
			 start.next=mergeTwoListsR(start.next, l2);
		 }
		 else {
			 start=l2;
			 start.next=mergeTwoListsR(l1, start.next);
		 }
			
		 return start;
			
	 }
}
