/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 *
 */
public class ReverseWordsInAString {
	public static String reverseWords(String s) { 
		StringBuilder strb = new StringBuilder();
		int end = s.length() - 1;
		
		for(int i = s.length() - 1; i >= 0 ; i--) {
			if(s.charAt(i) == ' ') {
				continue;
			}
			else {
				end = i;
				while(i >=0 && s.charAt(i) != ' ' ) 
					i--;
				strb.append(s.substring(i + 1, end + 1) + " ");
			}
		}
		
		return strb.toString().trim();
	}
	
	
	public static String reverseWords1(String s) { // Works well but not too efficient as I made it very complex.
		s = s.trim().replaceAll("\\s+"," ");

		if (s.length() == 0)
			return s;
		char[] words = s.toCharArray();
		int start = 0;
		for (int i = start; i < words.length; i++) {
			if (words[i] == ' ') {
				reverse(words, start, i - 1);
				start = i + 1;
			}
			else if (i == words.length - 1) {
				reverse(words, start, i);
				start = i + 1;
			}
		}
		reverse(words, 0, words.length - 1);
		return new String(words);
	}

	private static void reverse(char[] word, int start, int end) {
		if (word.length == 0 || word.length == 1)
			return;
		int mid = (start + end) / 2;
		for (int i = start; i <= mid; i++) {
			char temp = word[i];
			word[i] = word[end - i + start];
			word[end - i + start] = temp;
		}

	}



	public static void main(String[] args) {
		
		char [] arr = {'b','l','u','e'};
		reverse(arr, 1, 3);
		//System.out.println(arr);
		System.out.println(reverseWords(" the sky is blue"));

	}

}
