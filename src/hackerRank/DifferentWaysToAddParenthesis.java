/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the 
 * different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
 *
 */
public class DifferentWaysToAddParenthesis {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		diffWaysToCompute(input, res);
		return res;
	}

	private void diffWaysToCompute(String input, List<Integer> res) {
		if (input.length() == 1) {
			res.add(Integer.parseInt(input));
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isDigit(ch))
				continue;
			int left = input.charAt(i - 1) - '0';
			int right = input.charAt(i + 1) - '0';

			if (ch == '+') {
				String str = String.valueOf(left + right);
				diffWaysToCompute(input.substring(0, i - 1) + str + input.substring(i + 2), res);
			}
			else if (ch == '-') {
				String str = String.valueOf(left - right);
				diffWaysToCompute(input.substring(0, i - 1) + str + input.substring(i + 2), res);
			}
			else if (ch == '*') {
				String str = String.valueOf(left * right);
				diffWaysToCompute(input.substring(0, i - 1) + str + input.substring(i + 2), res);
			}
		}
	}
	
	public static void main(String[] args) {
		DifferentWaysToAddParenthesis obj = new DifferentWaysToAddParenthesis();
		System.out.println(obj.diffWaysToCompute("2-1-1"));
	}
}
