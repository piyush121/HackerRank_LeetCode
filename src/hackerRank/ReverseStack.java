package hackerRank;

import java.util.Stack;

public class ReverseStack { //Recursive implementation without using any data structure.

	public static void reverse(Stack<Integer> stack) { //O (n^2) time O (n) space.
		if (stack.isEmpty())
			return;
		int temp = stack.pop();
		reverse(stack);
		insertAtBottom(stack, temp);
	}

	public static void insertAtBottom(Stack<Integer> stack, int val) { //O(n) time. O(n) space.
		if (stack.isEmpty()) {
			stack.push(val);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, val);
		stack.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);

		reverse(stack);
		System.out.println(stack);
	}
}
