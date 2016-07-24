/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 *
 */
public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(beginWord.equals(endWord))
			return 0;
        Queue<String> path = new LinkedList<String>();
		path.add(beginWord);
		wordList.remove(beginWord);
		int level = 1;
		
		while (!path.isEmpty()) {
		    int currSize = path.size();
			for(int j = 0; j < currSize; j++) { // Important step as we need to be aware of the current level. All words derived from a level are level + 1 away from current word.
			String str = path.poll();

			char[] charArray = str.toCharArray();

				for (int i = 0; i < charArray.length; i++) {
					charArray = str.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) { // Check every word in BFS.
						charArray[i] = ch;
						String word = new String(charArray);
						if (word.equals(endWord))
							return level + 1;
						if (wordList.remove(word)) { // As we have seen this word it is better to remove it from wordList.
							path.add(word);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}
	
	public static int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
		if(beginWord.equals(endWord))
			return 0;
        Queue<String> path = new LinkedList<String>();
		Set<String> visited = new HashSet<>(); // We can further optimize by getting rid of this set. But I didn't bother.
		path.add(beginWord);
		int level = 1;
		
		while (!path.isEmpty()) {
		    int currSize = path.size();
			for(int j = 0; j < currSize; j++) { // Important step as we need to be aware of the current level. All words derived from a level are level + 1 away from current word.
			String str = path.poll();
			visited.add(str);

			char[] charArray = str.toCharArray();

				for (int i = 0; i < charArray.length; i++) {
					charArray = str.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						charArray[i] = ch;
						String word = new String(charArray);
						if (word.equals(endWord))
							return level + 1;
						if (wordList.contains(word) && !visited.contains(word)) {
							path.add(word);
							visited.add(word);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static void main(String[] args) {
		String word1 = "hot";
		String word2 = "dog";
		Set<String> set = new HashSet<>();
		set.add("hot");set.add("dot"); set.add("dog");
		System.out.println(ladderLength(word1, word2, set));

	}

}
