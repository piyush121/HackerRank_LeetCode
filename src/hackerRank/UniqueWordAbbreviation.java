/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. 
 * Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 *
 */
public class UniqueWordAbbreviation {
	Map<String, String> map = new HashMap<>();

	public UniqueWordAbbreviation(String[] dictionary) { // Easy but tedious ques.
		for (String str : dictionary) {
			String str1 = getAbbrv(str);
			if (!map.containsKey(str1))
				map.put(str1, str);
			else
				map.put(str1, "#");
		}
	}

	public boolean isUnique(String word) {
		if (word.length() < 3)
			return true;
		String word1 = getAbbrv(word);
		if (map.containsKey(word1) && map.get(word1).equals(word) || !map.containsKey(word1))
			return true;
		return false;
	}

	private String getAbbrv(String str) {
		if (str.length() < 3)
			return str;
		int len = str.length();
		String res = str.charAt(0) + Integer.toString((len - 2)) + str.charAt(len - 1);
		return res;
	}
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");