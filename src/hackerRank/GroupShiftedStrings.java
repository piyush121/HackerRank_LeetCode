/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example:
 *  "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 *
 */
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) { // Easy long ques. 
		Set<String> seen = new HashSet<>();
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			if (seen.contains(strings[i]))
				continue;
			temp = new ArrayList<>();
			temp.add(strings[i]);
			seen.add(strings[i]);
			for (int j = i + 1; j < strings.length; j++) {
				if (checkGroup(strings[i], strings[j])) {
					temp.add(strings[j]);
					seen.add(strings[j]);
				}
			}
			res.add(temp);
		}
		return res;
	}

	private boolean checkGroup(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length() - 1; i++) {
			if ((s1.charAt(i) - s2.charAt(i) + 26) % 26 != (s1.charAt(i + 1) - s2.charAt(i + 1) + 26) % 26)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		GroupShiftedStrings obj = new GroupShiftedStrings();
		System.out.println(obj.checkGroup("az", "ba"));
	}
}
