package hackerRank;

import java.util.Stack;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class ReverseStack {

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int temp = stack.pop();
		reverse(stack);
		insertAtBottom(stack, temp);
	}

	public static void insertAtBottom(Stack<Integer> stack, int val) {
		if (stack.isEmpty())
			stack.push(val);
		int temp = stack.pop();
		insertAtBottom(stack, val);
		stack.push(temp);
	}
}
