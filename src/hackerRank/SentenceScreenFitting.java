/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output: 
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output: 
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
 *
 */
public class SentenceScreenFitting { // Hard ques. asked at Google. Took a long time to get it.
	public int wordsTyping(String[] sentence, int rows, int cols) {
		if (sentence.length == 0)
			return 0;
		String str = String.join(" ", sentence) + " ";
		int len = str.length();
		int start = 0;
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (str.charAt(start % len) == ' ')
				start++;
			else {
				while (start > 0 && str.charAt((start - 1) % (len)) != ' ')
					start--;
			}
		}
		return start / len;
	}
	
	public int wordsTyping1(String[] sentence, int rows, int cols) { // O(m + n) DP based solution.
		if (sentence.length == 0)
			return 0;
		String str = String.join(" ", sentence) + " ";
		int len = str.length();
		int[] DP = new int[len];
		int count = 0;
		for (int i = 1; i < len; i++) {
			if (str.charAt(i) == ' ') // store the length to go backwards to fit as many words on screen.
				DP[i] = -1;
			else
				DP[i] = DP[i - 1] + 1; // add tp previous char count.
		}

		for (int i = 0; i < rows; i++) {
			count += cols;
			count -= DP[count % len]; // remove extra characters.
		}
		return count / len; // count number of times this sentence appeared.
	}
	
	/*
	 * Explanation:
	 * 
	 * Say sentence=["abc", "de", "f], rows=4, and cols=6.
The screen should look like

"abc de"
"f abc "
"de f  "
"abc de"
Consider the following repeating sentence string, with positions of the start character of each row on the screen.

"abc de f abc de f abc de f ..."
 ^      ^     ^    ^      ^
 0      7     13   18     25
Our goal is to find the start position of the row next to the last row on the screen, which is 25 here. Since actually it's the length of everything earlier, we can get the answer by dividing this number by the length of (non-repeated) sentence string. Note that the non-repeated sentence string has a space at the end; it is "abc de f " in this example.

Here is how we find that position. In each iteration, we need to adjust start based on spaces either added or removed.

"abc de f abc de f abc de f ..." // start=0
 012345                          // start=start+cols+adjustment=0+6+1=7 (1 space removed in screen string)
        012345                   // start=7+6+0=13
              012345             // start=13+6-1=18 (1 space added)
                   012345        // start=18+6+1=25 (1 space added)
                          012345
	 */

}
