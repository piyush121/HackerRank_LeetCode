/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Piyush Chaudhary
 *
 */

class Trie {
	boolean isWord;
	HashMap<Character, Trie> map;

	public Trie() {
		isWord = false;
		map = new HashMap<>();
	}
}

class Solution {
	public static int dfs(Trie node) {
		int count = 0;
		if (node.isWord)
			count++;
		for (char ch : node.map.keySet()) {
			Trie curr = node.map.get(ch);
			count += dfs(curr);
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie root = new Trie();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			Trie node = root;
			if (op.equals("add")) {
				for (char ch : contact.toCharArray()) {
					if (!node.map.containsKey(ch)) {
						node.map.put(ch, new Trie());
					}
					node = node.map.get(ch);
				}
			}
			if (op.equals("find")) {
				for (char ch : contact.toCharArray()) {
					if (node.map.containsKey(ch))
						node = node.map.get(ch);
					else {
						System.out.println(0);
						continue;
					}
				}
				int count = dfs(node);
				System.out.println(count);
			}
		}
	}
}

public class Contacts_Tries {

}
