package hackerRank;

public class BinaryTreetoDoublyLL {
	static treeNode last = null; // previous node while traversing tree in an
									// in-order fashion.
	static treeNode head = null; // head pointer in LL.

	public static void binaryToLL(treeNode root) { // pretty hard to understand.
		if (root == null)
			return;
		binaryToLL(root.left);
		if (last == null) {
			head = root;
		} else {
			last.right = root;
		}
		root.left = last;
		last = root;
		binaryToLL(root.right);

	}

}
