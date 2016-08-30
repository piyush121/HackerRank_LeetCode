/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation could
 * be form.
 * 
 * For example:
 * 
 * Given s = "aabb", return ["abba", "baab"].
 * 
 * Given s = "abc", return [].
 *
 */
public class PalindromePermutation_II {
	public List<String> generatePalindromes(String s) { // Still incomplete. Will come back to it again.
		List<String> res = new ArrayList<>();
		if (s.length() == 0)
			return res;
		char[] chArr = s.toCharArray();
		Arrays.sort(chArr);
		if (canPermutePalindrome(s)) {
			for(List<Character> list : permuteUnique(chArr)) {
				String str = getStringRepresentation(list);
				if(str.length() % 2 == 0 || str.length() == 1) 
					res.add(str+reverse(str));
				else
					res.add(str + str.charAt(str.charAt(str.length() - 1))+ reverse(str));
			}
		}
		return res;

	}
	private String getStringRepresentation(List<Character> list)
	{    
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}

	private String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public boolean canPermutePalindrome(String s) { // Easy Hashset based
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

	public List<List<Character>> permuteUnique(char[] nums) {
		List<List<Character>> res = new ArrayList<>();
		Character[] nums1 = new Character[nums.length];
		for (int i = 0; i < nums.length; i++)
			nums1[i] = Character.valueOf(nums[i]);
		permute(nums1, 0, res);
		return res;
	}

	private void permute(Character[] nums, int start, List<List<Character>> res) {
		if (start == nums.length) {
			res.add(new ArrayList<>(Arrays.asList(nums)));
		}
		Set<Character> seen = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (seen.add(nums[i])) {
				swap(nums, start, i);
				permute(nums, start + 1, res);
				swap(nums, start, i);
			}
		}
	}

	private void swap(Character[] nums, int i, int j) {
		char temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
