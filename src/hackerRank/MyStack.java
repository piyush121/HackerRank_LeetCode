/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, 
size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list
 or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an
 empty stack).
 *
 */
public class MyStack { // push is O(N) rest is O(1).
	// Push element x onto stack.
	Queue<Integer> que = new LinkedList<Integer>();
	public void push(int x) {
		que.add(x);
		for (int i = 0; i < que.size() - 1; i++)
			que.add(que.poll());

	}

    // Removes the element on top of the stack.
    public void pop() {
        que.poll();
    }

    // Get the top element.
    public int top() {
        return que.peek();
        }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.isEmpty();
    }

}
