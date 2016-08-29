/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 *
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) { // Easy hashmap based
													// solution.
		if (s.length() == 0)
			return true;
		Set<Character> freq = new HashSet<>();

		for (char ch : s.toCharArray()) {
			if (freq.contains(ch)) {
				freq.remove(ch);
			} else
				freq.add(ch);
		}

		return freq.size() <= 1;

	}

	public boolean canPermutePalindrome1(String s) { // Easy hashmap based
														// solution.
		if (s.length() == 0)
			return true;
		Map<Character, Integer> freq = new HashMap<>();

		for (char ch : s.toCharArray()) {
			if (freq.containsKey(ch)) {
				freq.put(ch, freq.get(ch) + 1);
			} else
				freq.put(ch, 1);
		}
		int oddCount = 0;
		for (int count : freq.values()) {
			if (count % 2 != 0)
				oddCount++;
		}
		if (s.length() % 2 == 0) {
			return oddCount == 0;
		} else
			return oddCount == 1;

	}
}
