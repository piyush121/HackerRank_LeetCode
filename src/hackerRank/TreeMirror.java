package hackerRank;

public class TreeMirror {

	public static void treeMirror(treeeNode root) {

		if (root == null) // base case
			return;
		treeeNode temp = root.left; // swapping left node with right node.
		root.left = root.right;
		root.right = temp;
		treeMirror(root.left);
		treeMirror(root.right);

	}

	public static void inOrder(treeeNode root) {
		treeeNode ptr = root;
		if (root == null)
			return;
		inOrder(ptr.left);
		System.out.print(ptr.data);
		inOrder(ptr.right);
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
		treeMirror(mytree.root);
		System.out.println("In Order Traversal");
		inOrder(mytree.root);

	}

}
