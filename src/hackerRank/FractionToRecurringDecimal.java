/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction 
 * in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 *
 */
public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";

		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
			left.append('-');

		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		if (num % den == 0)
			return left.toString() + String.valueOf(num / den);
		if (num > den) {
			left.append(num / den);
			num %= den;
		} else
			left.append("0");

		HashMap<Long, Integer> seen = new HashMap<>();
		while (num != 0) {
			num *= 10;
			if (seen.containsKey(num)) {
				int idx = seen.get(num);
				right.insert(idx, '(');
				right.append(')');
				return left + "." + right;
			}
			seen.put(num, right.length());
			right.append(num / den);
			Long mod = num % den;
			if (mod == 0) {
				return left + "." + right;
			}
			num = mod;
		}

		return "-1";

	}
}
