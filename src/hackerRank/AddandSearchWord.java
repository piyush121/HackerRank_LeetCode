/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or '.'. A . means
 * it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true search(".ad") -> true search("b..") -> true Note: You
 * may assume that all words are consist of lowercase letters a-z.
 * 
 * You should be familiar with how a Trie works. If not, please work on this
 * problem: Implement Trie (Prefix Tree) first.
 *
 */
public class AddandSearchWord {
	TrieNode root = new TrieNode();

	// Class WordDicionary
	// Adds a word into the data structure.
	public void addWord(String word) { // Usual add word
		TrieNode node = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = node.children[ch - 'a'];
			if (child == null) {
				child = new TrieNode();
				child.ch = ch;
			}
			node = child;
		}
		node.isWord = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) { // Was a hard one for me.
		TrieNode node = root;
		return search(word.toCharArray(), 0, node);
	}

	private boolean search(char[] word, int idx, TrieNode node) {
		if (word.length == idx)
			return node.isWord;
		char ch = word[idx];
		if (ch != '.' && node.children[ch - 'a'] == null) // check whether we can go forward from here or not.
			return false;

		if (ch == '.') { // wildcard check.
			for (TrieNode child : node.children) {
				if (child != null && search(word, idx + 1, child))
					return true;
			}
		} else
			return search(word, idx + 1, node.children[ch - 'a']);
		return false;
	}

	public static void main(String[] args) {
		AddandSearchWord obj = new AddandSearchWord();
		obj.addWord("ab");
		obj.search("a.");
	}
	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");

}
