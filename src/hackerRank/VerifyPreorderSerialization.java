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
	public boolean isValidSerialization(String preorder) { // Recursive.
		if (preorder.length() == 0)
			return true;
		String[] strArr = preorder.split(",");
		int val = dfs(strArr, 0);
		if (val < strArr.length) // 'Val' can also be -1. It should be strArr.length in ideal scenario.
			return false;
		return true;
	}

	public int dfs(String[] preorder, int idx) {
		if (idx < 0) // Some violation found.
			return -1;
		if (idx == preorder.length) // reached end. Base case.
			return idx;
		String str = preorder[idx];
		int next = -1;
		if (str.equals("#")) // Time to go to next node.
			return idx + 1;
		else {
			int right = dfs(preorder, idx + 1); // get pointer to right child.
			if (right == preorder.length)
				return -1;
			next = dfs(preorder, right);
		}

		return next;
	}
	
	public boolean isValidSerialization1(String preorder) { // Another sexy way to approach his porblem.
		if (preorder.length() == 0)
			return true;
		String[] strArr = preorder.split(",");
		int diff = 1;
		for(int i = 0; i < strArr.length; i++) { // Every null has an indegree of 1 and out degree of 0.
		    if(--diff < 0)
		        return false;
		    if(!strArr[i].equals("#"))diff += 2;// Every non-null node has an indegree of 1 and outdegree of 2
		}
		
		return diff == 0;
   }
}
