/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class AddStrings {
	public String addStrings(String num1, String num2) { // easy peezy!
		int borrow = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		StringBuilder strb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			int first = i >= 0 ? num1.charAt(i--) - '0' : 0;
			int sec = j >= 0 ? num2.charAt(j--) - '0' : 0;
			int total = first + sec + borrow;
			borrow = total / 10;
			total = total % 10;
			strb.append(total);
		}
		if (borrow != 0)
			strb.append(borrow);
		return strb.reverse().toString();
	}
}
