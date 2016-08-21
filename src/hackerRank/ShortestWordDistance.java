/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int w1 = -1;
		int w2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (word1.equals(words[i]))
				w1 = i;
			if (word2.equals(words[i]))
				w2 = i;
			if (w1 != -1 && w2 != -1) { // keep track of latest word location and keep checking dist. b/w them.
				if (Math.abs(w1 - w2) < min)
					min = Math.abs(w1 - w2);
			}
		}
		return min;
    }
}
