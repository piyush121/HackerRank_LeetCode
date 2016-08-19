/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, 
size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a 
list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called 
on an empty queue).

 *
 */
public class MyQueue { // Basically all operations are Amortized O(1).
	// Push element x to the back of queue.
	Stack<Integer> st1 = new Stack<>();
	Stack<Integer> st2 = new Stack<>();

	public void push(int x) { // always push to 1st stack.
		st1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() { // pop from 2nd stack if not empty, because they are in order already.
		if (!st2.isEmpty()) {
			st2.pop();
			return;
		}
		while (!st1.isEmpty())
			st2.push(st1.pop());
		st2.pop();
	}

	// Get the front element.
	public int peek() { // peek from 2nd stack if not empty, because they are in order already.
		if (!st2.isEmpty())
			return st2.peek();
		while (!st1.isEmpty())
			st2.push(st1.pop());
		return st2.peek();

	}

	// Return whether the queue is empty.
	public boolean empty() {
		return st1.isEmpty() && st2.isEmpty();
	}
}