/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		int a, b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if (s.equals("+")) {
				S.add(S.pop() + S.pop());
			} else if (s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b); // needed because we need a/b not b/a.S.pop()/S.pop() will give you b/a.
			} else if (s.equals("*")) {
				S.add(S.pop() * S.pop());
			} else if (s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			} else {
				S.add(Integer.parseInt(s));
			}
		}
		return S.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
