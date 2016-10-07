/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;

/**
 * @author Piyush Chaudhary
 *
 */
public class LongestSubstringWithMax2DistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 1;
		int i = 0;
		int j = 1;
		map.put(s.charAt(i), 1);
		int count = 1;
		while (j < s.length()) {
			char ch = s.charAt(j);
			if (map.containsKey(s.charAt(j))) {
				map.put(ch, map.get(ch) + 1);
			} else {
				if (count < 2) { // can be easily extended to k characters from here.
					map.put(ch, 1);
					count++;
				} else {
					while (i != j - 1) {
						char prev = s.charAt(i);
						int cnt = map.get(prev);
						cnt--;
						i++;
						if (cnt == 0) { // No more characters left.
							map.remove(prev); // So remove it.
							map.put(ch, 1);
							break;
						} else {
							map.put(prev, cnt);
						}
					}
				}

			}
			if (j - i + 1 > max)
				max = j - i + 1;
			j++;
		}
		return max;
	}
}
