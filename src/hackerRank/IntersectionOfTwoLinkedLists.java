/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

 *
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int lenA = 0;
		int lenB = 0;
		ListNode ptr1 = headA;
		ListNode ptr2 = headA;
		while (ptr1 != null) {
			ptr1 = ptr1.next;
			lenA++;
		}
		while (ptr2 != null) {
			ptr2 = ptr2.next;
			lenB++;
		}
		ptr1 = headA;
		ptr2 = headB;
		while (lenA > lenB) {
			ptr1 = ptr1.next;
			lenA--;
		}
		while (lenB > lenA) {
			ptr2 = ptr2.next;
			lenB--;
		}

		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		if (ptr1 == null)
			return null;
		return ptr1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
