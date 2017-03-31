/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 *
 */
public class SerializeDeserializeBST {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder strb = new StringBuilder();
		serialize(root, strb);
		return strb.toString();
	}

	public void serialize(TreeNode root, StringBuilder strb) {
		if (root == null) {
			strb.append("n "); // encode null nodes as well.
			return;
		}
		strb.append(root.val + " ");
		serialize(root.left, strb);
		serialize(root.right, strb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) { // O(N) time and space.
		if (data.length() == 0)
			return null;
		String[] BST = data.split(" ");
		Queue<String> queue = new LinkedList<>(); // O(N) space.
		for (String str : BST)
			queue.offer(str);
		return deserialize(queue);
	}

	public TreeNode deserialize(Queue<String> queue) {
		String node = queue.poll();
		TreeNode root = makeNode(node);
		if (root == null)
			return root;
		root.left = deserialize(queue);
		root.right = deserialize(queue);
		return root;
	}

	public TreeNode makeNode(String val) {
		if (val.equals("n"))
			return null;
		return new TreeNode(Integer.parseInt(val));
	}
}
