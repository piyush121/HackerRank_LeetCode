/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Could you do it in-place without allocating extra space?
 * 
 * Related problem: Rotate Array
 *
 */
public class ReverseWordsInString {
	public void reverseWords(char[] s) { // Great solution. O(n) time and O(1) space.
		if (s.length == 0)
			return;
		for (int i = 0; i < s.length;) {
			int end = nextSpace(s, i);
			if (end == -1)
				break;
			reverse(s, i, end); // reverse individual words.
			i = end + 2;
		}
		reverse(s, 0, s.length - 1); // reverse complete set of chars.
	}

	private void reverse(char[] str, int start, int end) { // usual reverse function.
		if (start >= end)
			return;
		for (int i = start; i <= (start + end )/ 2; i++) {
			char temp = str[i];
			str[i] = str[end - i + start];
			str[end - i + start] = temp;
		}
	}

	private int nextSpace(char[] str, int start) { // Find next character before space.
		if (start >= str.length)
			return -1;

		for (int i = start; i < str.length; i++) {
			if (str[i] == ' ') {
				return i - 1;
			}
			if (i == str.length - 1)
				return i;
		}

		return -1;
	}
	public static void main(String[] args) {
		ReverseWordsInString obj = new ReverseWordsInString();
		String str = "hello world!";
		char[] s = str.toCharArray();
		obj.reverseWords(s);
		System.out.println(s);
	}
}
