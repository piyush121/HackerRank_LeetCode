/**
 * @author Piyush Chaudhary
 */
package hackerRank;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
 *
 */
public class VerifyPreorderSerialization {
	public boolean isValidSerialization(String preorder) {
		if (preorder.length() == 0)
			return true;
		String[] strArr = preorder.split(",");
		int val = dfs(strArr, 0);
		if (val < strArr.length)
			return false;
		return true;
	}

	public int dfs(String[] preorder, int idx) {
		if (idx < 0)
			return -1;
		if (idx == preorder.length)
			return idx;
		String str = preorder[idx];
		int next = -1;
		if (str.equals("#"))
			return idx + 1;
		else {
			int right = dfs(preorder, idx + 1);
			if (right == preorder.length)
				return -1;
			next = dfs(preorder, right);
		}

		return next;
	}
}
