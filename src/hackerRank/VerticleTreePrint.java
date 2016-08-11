package hackerRank;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Piyush Chaudhary
 *
 */
public class VerticleTreePrint {
	static TreeMap<Integer, ArrayList<Integer>> hash = new TreeMap<>();

	public static void fillHash(treeeNode root, int val) {
		if (root == null)
			return;
		if (hash.containsKey(val))
			hash.get(val).add(root.data);
		else {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(root.data);
			hash.put(val, arr);
		}
		fillHash(root.left, val - 1);
		fillHash(root.right, val + 1);

	}

	public static void print(treeeNode root) {
		fillHash(root, 0);
		for (Entry<Integer, ArrayList<Integer>> entr : hash.entrySet()) {
			System.out.println(entr.getValue());
		}
	}

	public static void main(String[] args) {
		treeeNode node1 = new treeeNode(4, null, null);
		treeeNode node2 = new treeeNode(5, null, null);
		treeeNode node3 = new treeeNode(2, null, null);
		treeeNode node4 = new treeeNode(1, null, null);
		treeeNode node5 = new treeeNode(3, null, null);
		treeeNode node6 = new treeeNode(3, null, null);

		binaryTree mytree = new binaryTree();
		mytree.add(node1);
		mytree.add(node2);
		mytree.add(node3);
		mytree.add(node4);
		mytree.add(node5);
		mytree.add(node6);
		print(mytree.root);
	}

}
