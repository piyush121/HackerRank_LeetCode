/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
 *
 */
public class BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		int number = 0;
		int sign = 1;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch))
				number = 10 * number + (int) (ch - '0');
			else if (ch == '+') {
				result += number * sign; // calculate previous result and store new sign info.
				number = 0;
				sign = 1;
			} else if (ch == '-') {
				result += number * sign;
				number = 0;
				sign = -1;
			}

			else if (ch == '(') {//Time to store previous info into stack because new operation is about to get performed.
				stack.push(result); 
				stack.push(sign);
				number = 0;
				sign = 1;
				result = 0;
			}

			else if (ch == ')') { // Finish off the current operation and take out previous state.
				result += number * sign;
				sign = stack.pop();
				result *= sign;
				number = stack.pop();
				sign = 1;
			}

		}
		if (number != 0)
			result += sign * number;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
