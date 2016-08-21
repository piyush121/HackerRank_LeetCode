/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 *
 */
public class ShortestWordDistance_II {
	Map<String, List<Integer>> seen = new HashMap<>();

    public ShortestWordDistance_II(String[] words) {
        for (int i = 0 ; i < words.length; i++) {
            if(seen.containsKey(words[i])) {
                List<Integer> temp = seen.get(words[i]);
                temp.add(i);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                seen.put(words[i], temp);
            }
            
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> idx1 = seen.get(word1);
        List<Integer> idx2 = seen.get(word2);
        int min = Integer.MAX_VALUE;
        for(int id1 : idx1) {
            for (int id2 : idx2) {
                if(Math.abs(id1 - id2) < min)
                    min = Math.abs(id1 - id2);
            }
        }
        return min;
    }
}
