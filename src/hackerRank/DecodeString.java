/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside 
the square brackets is being repeated exactly k times. Note that k is guaranteed 
to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, 

square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits 
and that digits are only for those repeat numbers, k. For example, there won't 
be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 */
public class DecodeString {
	public static String decodeString(String s) {
		if (s.length() == 0)
			return "";

		Stack<String> chars = new Stack<>();
		Stack<Integer> count = new Stack<>();
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				num = num * 10 + ch - '0';
				continue;
			}
			if (num > 0) {
				count.push(num);
				num = 0;
			}

			if (ch == ']') {
				int times = count.pop();
				StringBuilder strb = new StringBuilder();
				String ch1 = chars.pop();
				while (!ch1.equals("[")) {
					strb.insert(0, ch1);
					ch1 = chars.pop();
				}
				String str = strb.toString();
				while (times-- > 1)
					strb.append(str);
				chars.push(strb.toString());

			} else
				chars.push(String.valueOf(ch));
		}
		StringBuilder strb = new StringBuilder();
		while (!chars.isEmpty()) {
			strb.insert(0, chars.pop());
		}

		return strb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));

	}

}
