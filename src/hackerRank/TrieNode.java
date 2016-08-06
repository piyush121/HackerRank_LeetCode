/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 */
public class TrieNode {
	// Initialize your data structure here.
	boolean isWord;
	TrieNode[] children;
	char ch;

	public TrieNode() {
		this.isWord = false;
		this.children = new TrieNode[26];
		this.ch = ' ';
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {

		TrieNode curr = root;
		for (char ch : word.toCharArray()) { // Always try to onvert string into char array for better performance.

			TrieNode node = curr.children[ch - 'a'];
			if (node == null) {
				curr.children[ch - 'a'] = new TrieNode();
				curr.children[ch - 'a'].ch = ch;
				node = curr.children[ch - 'a'];
			}
			curr = node;

		}
		curr.isWord = true;

	}

	// Returns if the word is in the trie.
	public boolean search(String word) {

		TrieNode curr = root;
		for (char ch : word.toCharArray()) {

			TrieNode node = curr.children[ch - 'a'];
			if (node == null)
				return false;
			curr = node;

		}
		return curr.isWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (char ch : prefix.toCharArray()) {

			TrieNode node = curr.children[ch - 'a'];
			if (node == null)
				return false;
			curr = node;
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
