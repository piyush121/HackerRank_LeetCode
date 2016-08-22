/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
 *
 */
public class ShortestWordDistance_III {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int idx1 = -1;
		int idx2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				idx1 = i;
				if (idx2 != -1)
					min = Math.min(min, i - idx2);
			}
			if (words[i].equals(word2)) {
				idx2 = i;
				if (!word1.equals(word2) && idx1 != -1) // Don't find min if word1 is equal to word1 because then min would be 0;
					min = Math.min(min, i - idx1);
			}

		}
		return min;
    }
}
