/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
 *
 */
public class BasicCalculator_II {
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ')
				continue;
			if (Character.isDigit(ch)) {
				num = 10 * num + (ch - '0');
				if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
					if (sign == '+')
						stack.push(num);
					else if (sign == '-')
						stack.push(-num);
					else if (sign == '/') {
						stack.push(stack.pop() / num);
					} else if (sign == '*') {
						stack.push(stack.pop() * num);
					}
				}
			} else {
				sign = ch;
				num = 0;
			}
		}
		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(calculate("42"));
	}

}
