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

class Trie1 {
	boolean isWord;
	HashMap<Character, Trie1> map;

	public Trie1() {
		isWord = false;
		map = new HashMap<>();
	}
}

class Solution1 {
	public static int dfs(Trie1 node) {
		int count = 0;
		if (node.isWord)
			count++;
		for (char ch : node.map.keySet()) {
			Trie1 curr = node.map.get(ch);
			count += dfs(curr);
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Trie1 root = new Trie1();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			Trie1 node = root;
			if (op.equals("add")) {
				char[] name = contact.toCharArray();
				for (int i = 0; i < name.length; i++) {
					char ch = name[i];
					if (!node.map.containsKey(ch)) {
						node.map.put(ch, new Trie1());
					}
					node = node.map.get(ch);
					if (i == name.length - 1)
						node.isWord = true;
				}

			}
			if (op.equals("find")) {
				boolean flag = true;
				for (char ch : contact.toCharArray()) {
					if (node.map.containsKey(ch))
						node = node.map.get(ch);
					else {
						System.out.println(0);
						flag = false;
						break;
					}
				}
				if (flag) {
					int count = dfs(node);
					System.out.println(count);
				}
			}
		}
	}
}

public class Contacts_Tries {

}
