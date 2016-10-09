/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.Scanner;

/**
 * @author Piyush Chaudhary
 *
 */

class Trie1 {
	boolean isWord;
	int count;
	Trie1[] map;

	public Trie1() {
		isWord = false;
		count = 0;
		map = new Trie1[26];
	}
}

class Solution1 {
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
					if (node.map[ch - 'a'] == null) {
						node.map[ch - 'a'] = new Trie1();
					}
					node = node.map[ch - 'a'];
					if (i == name.length - 1) {
						node.isWord = true;
					}
					node.count++;
				}

			}
			if (op.equals("find")) {
				boolean flag = true;
				for (char ch : contact.toCharArray()) {
					if (node.map[ch - 'a'] != null)
						node = node.map[ch - 'a'];
					else {
						System.out.println(0);
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println(node.count);
				}
			}
		}
	}
}

public class Contacts_Tries {

}
