package hackerRank;
/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list 
should become 1 -> 2 -> 4 after calling your function.
*/

public class DeleteNodeInLinkedList {
 public void deleteNode(ListNode node) { // Damn it was such a easy way. Didn't know why it didn't click me ! 
        node.val = node.next.val;
        node.next = node.next.next;
            
    }
 
 
 public void deleteNode1(ListNode node) { // Can be made more efficient.
        while(node !=null) {
                node.val = node.next.val;
            if(node.next.next == null) {
                node.val = node.next.val;
                node.next = null;
            }
             node = node.next;   
                
        }

}
