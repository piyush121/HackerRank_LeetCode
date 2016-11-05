/**
 * @author Piyush Chaudhary
 */
package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


 *
 */
public class SerializeDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			if (node == null) {
				list.add("null");
				continue;
			} else
				list.add(String.valueOf(node.val));
			que.offer(node.left);
			que.offer(node.right);
		}
		// System.out.println(list);
		return list.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String str1 = data.substring(1, data.length() - 1);
		String[] str = str1.split(", ");
		List<TreeNode> list = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("null"))
				list.add(null);
			else
				list.add(new TreeNode(Integer.valueOf(str[i])));
		}
		int j = 1;
		for (int i = 0; i < list.size(); i++) {
			TreeNode node = list.get(i);
			if (node != null) {
				node.left = list.get(j++);
				node.right = list.get(j++);
			}
		}
		return list.get(0);
	}
	
	public TreeNode deserialize1(String data) { // Slightly faster 1 pass approach.
        if(data.equals("null"))
            return null;
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        for(int i = 1 ; i < str.length;i++) {
            TreeNode parent = que.poll();
            if(!str[i].equals("null")) {
                parent.left = new TreeNode(Integer.valueOf(str[i]));
                que.add(parent.left);
            }

            if(!str[++i].equals("null")) {
                parent.right = new TreeNode(Integer.valueOf(str[i]));
                que.add(parent.right);
            }

            
        }
        return root;
    }
}
