/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class SortByFrequency {
	public String frequencySort(String s) {
		if (s.length() < 3)
			return s;
		int max = 0;
		int[] map = new int[256];
		for (char ch : s.toCharArray())
			map[ch]++;
		for (int num : map) // find max.
			if (num > max)
				max = num;
		String[] buckets = new String[max + 1]; // create max buckets
		for (int i = 0; i < 256; i++) { // join chars in the same bucket
			String str = buckets[map[i]];
			if (map[i] > 0)
				buckets[map[i]] = (str == null) ? "" + (char) i : (str + (char) i);
		}
		StringBuilder strb = new StringBuilder();
		for (int i = max; i >= 0; i--) { // create string for each bucket.
			if (buckets[i] != null)
				for (char ch : buckets[i].toCharArray())
					for (int j = 0; j < i; j++)
						strb.append(ch);
		}
		return strb.toString();
	}
}
