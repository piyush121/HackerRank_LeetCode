package hackerRank;
/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

public class PalindromeLinkedList {
      public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        int length = 0;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode last = reverse(slow);
        
        while(last!=null && head !=null) {
            if(head.val != last.val)
                return  false;
            last = last.next;
            head = head.next;
        }
        
        return true;
        
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = curr.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(nxt!=null)
                nxt = nxt.next;
        }
        return prev;
    }

}
