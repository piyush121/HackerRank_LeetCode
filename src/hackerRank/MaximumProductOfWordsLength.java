/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the 
 * two words do not share common letters. You may assume that each word will contain only lower case letters. 
 * If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 *
 */
public class MaximumProductOfWordsLength {
	public int maxProduct1(String[] words) {
        int[][] allWords = new int[words.length][26];
        
        for(int i = 0 ; i < words.length; i++) { // Preprocessing.
            for(char ch : words[i].toCharArray())
                allWords[i][ch - 'a'] = 1;
        }
        
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++){
                if(compareArr(allWords[i], allWords[j])){ // compare every processd string
                    max = Math.max(max, words[i].length() * words[j].length());
                    
                }
            }
        }
        return max;
    }
    
    public boolean compareArr(int[] arr1, int[] arr2) {
        
        for(int i = 0 ; i < 26; i++)
        	if(arr1[i] == 1 &&  arr2[i] == 1)
                return false;
        return true;
    }
    
    public int maxProduct(String[] words) { // Even faster with O(n) space.
        int[] bytes = new int[words.length];
        
        for(int i = 0 ; i < words.length; i++) { // preprocessing.
            for(char ch : words[i].toCharArray())
                bytes[i] |= 1 << (ch - 'a');
        }
        
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++){
                if((bytes[i] & bytes[j]) == 0){ // compare every processd string
                    max = Math.max(max, words[i].length() * words[j].length());
                    
                }
            }
        }
        return max;
    }
}
