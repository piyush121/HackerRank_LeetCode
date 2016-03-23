package hackerRank;

public class BinaryTreetoDoublyLL {
	static treeNode last = null; // previous node while traversing tree in an
									// in-order fashion.
	static treeNode head = null; // head pointer in LL.

	public static void binaryToDLL(treeNode root) { // pretty hard to understand.
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
	
	public static void binarytoCLL(treeNode node) { // A different implementation.
		binarytoCLL(node.left);
		binarytoCLL(node.right);
		
	}
	
	public static treeNode concat(treeNode a,treeNode b) {
		
	}
	

}
