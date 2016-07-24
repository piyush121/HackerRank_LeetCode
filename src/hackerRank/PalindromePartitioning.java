/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 *
 */
public class PalindromePartitioning {
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s.length() == 0)
			return result;
		DFS(s, 0, s.length() - 1, new ArrayList<>(), result);
		return result;

	}

	private static void DFS(String str, int start, int end, List<String> list, List<List<String>> result) {
		if (start > end) { // base case. When we reach the length of string basically.
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= end; i++) {
			if (isPalindrome(str.substring(start, i + 1))) { // only Palindromic substring taken to next level of recursion.
				list.add(str.substring(start, i + 1));
				DFS(str, i + 1, end, list, result);
				list.remove(list.size() - 1); // Gotta remove what's been added to keep things going. 
			}

		}
	}

	private static boolean isPalindrome(String str) { // usual Palindromic check method.
		if (str.length() == 0)
			return true;

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(partition("aab"));

	}

}
