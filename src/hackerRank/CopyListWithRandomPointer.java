/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 *
 */
public class CopyListWithRandomPointer {
	Map<RandomListNode, RandomListNode> visited = new HashMap<>();

	public RandomListNode copyRandomList(RandomListNode head) { // Easy one but deep thoughts required.
		if (head == null)
			return null;
		if (visited.containsKey(head))
			return visited.get(head); // Don't create copy if its already visited.
		RandomListNode node = new RandomListNode(head.label);
		visited.put(head, node);
		node.next = copyRandomList(head.next);
		node.random = copyRandomList(head.random);

		return node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
