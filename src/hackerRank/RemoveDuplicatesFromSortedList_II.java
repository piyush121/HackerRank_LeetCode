/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 *
 */
/**
 * Definition for singly-linked list. 
 * public class ListNode
 * 	{ 
 *   int val;
 *   ListNode * next; 
 *   ListNode(int x)
 *   { val = x; }
 *   }
 */
public class RemoveDuplicatesFromSortedList_II {

	public ListNode deleteDuplicates1(ListNode head) { // Works pretty well ! nOt too hard but a bit messy.
		 if (head == null || head.next == null)
				return head;
			ListNode rear = new ListNode(0);
			ListNode dummy = rear;
			ListNode front = head;
			ListNode rep = null;
			while (front != null) {
				if (front.next != null && front.val == front.next.val) {
					rep = front;
				} else {
					if (rep == null ||front.val != rep.val) { // key idea.
						rear.next = front;
						rear = rear.next;
					}
				}
				front = front.next;
			}
			rear.next = null;
			return dummy.next;
        
    }
	
	public ListNode deleteDuplicates(ListNode head) { // Works pretty well and space efficient as well.
		if (head == null || head.next == null)
			return head;
		ListNode rear = new ListNode(0);
		ListNode dummy = rear;
		ListNode front = head;
		while (front != null) {
			while (front.next != null && front.val == front.next.val) {
				front = front.next;
			}
			if (rear.next != front) {
				rear.next = front.next;
			} else {
				rear = rear.next;
			}

			front = front.next;
		}
		return dummy.next;
       
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
