package hackerRank;

public class TreeMirror {

	public static void treeMirror(treeNode root) {

		if (root == null) // base case
			return;
		treeNode temp = root.left; // swapping left node with right node.
		root.left = root.right;
		root.right = temp;
		treeMirror(root.left);
		treeMirror(root.right);

	}

	public static void inOrder(treeNode root) {
		treeNode ptr = root;
		if (root == null)
			return;
		inOrder(ptr.left);
		System.out.print(ptr.data);
		inOrder(ptr.right);
	}

	public static void main(String[] args) {
		treeNode node1 = new treeNode(4, null, null);
		treeNode node2 = new treeNode(5, null, null);
		treeNode node3 = new treeNode(2, null, null);
		treeNode node4 = new treeNode(1, null, null);
		treeNode node5 = new treeNode(3, null, null);
		treeNode node6 = new treeNode(3, null, null);

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
