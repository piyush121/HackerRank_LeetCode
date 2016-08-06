/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Reverse a single linked list
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) { // Iterative way. O(n) time and O(1) space.
        if(head == null )
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }
	
	public ListNode reverseList1(ListNode head) { // Elegant recursive way with O(n) time and space.
        if(head == null || head.next == null )
            return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
