package hackerRank;

public class BinaryTreetoDoublyLL {
	static treeNode last = null; // previous node while traversing tree in an
									// in-order fashion.
	static treeNode head = null; // head pointer in LL.

	public static void binaryToDLL(treeNode root) { // pretty hard to
													// understand.
		if (root == null)
			return;
		binaryToDLL(root.left);
		if (last == null) {
			head = root;
		} else {
			last.right = root;
		}
		root.left = last;
		last = root;
		binaryToDLL(root.right);

	}

	public static treeNode binarytoCLL(treeNode node) { // A different
														// implementation.
		treeNode leftList = binarytoCLL(node.left);
		treeNode rightList = binarytoCLL(node.right);
		node = concat(leftList, node);
		node = concat(node, rightList);

		return node;

	}

	public static treeNode concat(treeNode a, treeNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		treeNode aEnd = concat(a, a.left);
		treeNode bEnd = concat(b, b.left);
		a.left = bEnd;
		aEnd.right = b;
		b.left = aEnd;

		return a;
	}

}
