package hackerRank;

public class BinaryTreetoDoublyLL {
	static treeeNode last = null; // previous node while traversing tree in an
									// in-order fashion.
	static treeeNode head = null; // head pointer in LL.

	public static void binaryToDLL(treeeNode root) { // pretty hard to
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

	public static treeeNode binarytoCLL(treeeNode node) { // A different
														// implementation.
		treeeNode leftList = binarytoCLL(node.left);
		treeeNode rightList = binarytoCLL(node.right);
		node = concat(leftList, node);
		node = concat(node, rightList);

		return node;

	}

	public static treeeNode concat(treeeNode a, treeeNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		treeeNode aEnd = concat(a, a.left);
		treeeNode bEnd = concat(b, b.left);
		a.left = bEnd;
		aEnd.right = b;
		b.left = aEnd;

		return a;
	}

}
