/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 *
 */
public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		int low = 0;
		int high = s.length() - 1;
		char[] arr = s.toCharArray();
		while (low < high) {
			while (low < arr.length && !vowels.contains(arr[low]))
				low++;
			while (high >= 0 && !vowels.contains(arr[high]))
				high--;
			if (low < high) {
				char temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}

		}

		return String.valueOf(arr);
	}
}
