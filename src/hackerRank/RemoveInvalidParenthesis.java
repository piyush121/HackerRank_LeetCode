/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Examples: "()())()" -> ["()()()", "(())()"] "(a)())()" -> ["(a)()()",
 * "(a())()"] ")(" -> [""]
 *
 */
public class RemoveInvalidParenthesis {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s.length() == 0 || isValid(s)) {
			res.add(s);
			return res;
		}
		Queue<String> que = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		que.add(s);
		int len = 1;
		boolean found = false;
		while (!que.isEmpty()) {
			while (len > 0) {
				String str = que.poll();
				seen.add(str);
				if (isValid(str)) {
					res.add(str);
					found = true;
				} else if (!isValid(str) && !found) {
					que.addAll(addAll(new ArrayList<String>(), str, seen));
				}
				len--; // decrease size of current level.
			}
			len = que.size();
			if (res.size() > 0)
				break;
		}
		return res;
	}

	public boolean isValid(String str) { // Usual check valid parenthesis method.
		if (str.length() == 0)
			return true;
		int count = 0;
		for (char ch : str.toCharArray()) {
			if (ch == '(')
				count++;
			else if (ch == ')')
				count--;
			if (count < 0)
				return false;

		}
		return count == 0;
	}

	public List<String> addAll(List<String> res, String str, Set<String> set) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ')' && str.charAt(i) != '(')
				continue;
			String s = str.substring(0, i) + str.substring(i + 1);
			if (!set.contains(s)) {
				res.add(s);
				set.add(s);
			}
		}
		return res;
	}

}
