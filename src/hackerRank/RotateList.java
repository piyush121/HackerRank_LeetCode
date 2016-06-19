package hackerRank;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * @author Piyush Chaudhary
 *
 */
public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null)
            return null;
        int length = 0;
		ListNode front = head;
		while (front.next != null) {
			front = front.next;
			length++;
		}
		
		length++;
		k = k % length;

		ListNode rear = head;
		int cnt = length - (k % length);
		while (cnt > 1) { // Because we need rear.next as null.
			rear = rear.next;
			cnt--;
		}
		// Do the rotation.
		front.next = head;
		head = rear.next;
		rear.next = null;

		return head;
	}
}