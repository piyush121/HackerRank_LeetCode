/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 *
 */
public class LongestSubstringWithKDistonctCharacters {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) { // not a hard one to understand.
		if (k == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>(); // You can use char Array instead of map to speed up the process.
		int j = 0, count = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, i); // track the last occurence of this character.
			} else {
				if (count < k) {
					map.put(ch, i);
					count++;
				} else {
					while (count >= k) {
						if (map.get(s.charAt(j)) == j) {// Is this last occurence of this character.?
							map.remove(s.charAt(j));
							count--;
						}
						j++;
					}
					map.put(ch, i);
					count++;
				}
			}
			if (i - j + 1 > max)
				max = i - j + 1;
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstringKDistinct("abcabc", 2));
	}

}
