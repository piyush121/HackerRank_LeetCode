package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Piyush Chaudhary
 *
 */
public class CountNodesPerLevel {

	public static void countNodesAtAllLevels(treeeNode root) {
		if (root == null) // base case.
			return;
		Queue<treeeNode> Q1 = new LinkedList<>();
		Queue<treeeNode> Q2 = new LinkedList<>();
		ArrayList<Integer> countArray = new ArrayList<>();
		int count = 0;
		Q1.add(root);
		while (!Q1.isEmpty()) {
			treeeNode node = Q1.poll();
			if (node.left != null)
				Q2.add(node.left);
			if (node.right != null)
				Q2.add(node.right);
			count++;
			if (Q1.isEmpty()) {
				countArray.add(count);
				count = 0;
				Q1 = Q2; // Flip queues when each level ends.
				Q2 = new LinkedList<>();

			}
		}
		System.out.println(countArray);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		countNodesAtAllLevels(mytree.root);

	}

}
