/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add 
 * binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 *
 */
public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		if (num.length() == 0)
			return res;
		dfs(num, target, 0, "", res, Long.valueOf(0), Long.valueOf(0));
		return res;

	}

	private void dfs(String nums, int target, int start, String path, List<String> res, Long prev, Long val) {
		if (start == nums.length()) { // base case.
			if (val == target)
				res.add(path);
			return;
		}

		for (int i = start; i < nums.length(); i++) {
			if (i != start && nums.charAt(start) == '0')
				break;
			Long curr = Long.parseLong(nums.substring(start, i + 1)); // current number. Can be more than 1 digit.

			if (start == 0) {
				dfs(nums, target, i + 1, path + curr, res, curr, curr);
				continue; // if this i the very first call. skip totally.
			}

			dfs(nums, target, i + 1, path + "+" + curr, res, curr, val + curr);
			dfs(nums, target, i + 1, path + "-" + curr, res, -curr, val - curr);
			dfs(nums, target, i + 1, path + "*" + curr, res, prev * curr, val - prev + curr * prev); // here we are separating previous added value and multiplying prev with current value,
																									 // because the rule says multiply first than add/subtract it.
		}
	}
}
