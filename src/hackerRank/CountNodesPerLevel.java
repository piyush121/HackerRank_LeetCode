package hackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Piyush Chaudhary
 *
 */
public class CountNodesPerLevel {
	
	public static void countNodesAtAllLevels(treeNode root){
		if(root==null)
			return;
		Queue<treeNode> Q1=new LinkedList<>();
		Queue<treeNode> Q2=new LinkedList<>();
		ArrayList<Integer> countArray=new ArrayList<>();
		int count=0;
		Q1.add(root);
		while(!Q1.isEmpty())
		{	
			treeNode node= Q1.poll();
			if(node.left!=null)
				Q2.add(node.left);
			if(node.right!=null)
				Q2.add(node.right);
			count++;
			if(Q1.isEmpty())
			{
				countArray.add(count);
				count=0;
				Q1=Q2;		//Flip queues when each level ends.
				Q2=new LinkedList<>();
				
				
			}
		}
		System.out.println(countArray);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		treeNode node1=new treeNode(4,null,null);
		treeNode node2=new treeNode(5,null,null);
		treeNode node3=new treeNode(2,null,null);
		treeNode node4=new treeNode(1,null,null);
		treeNode node5=new treeNode(3,null,null);
		treeNode node6=new treeNode(3,null,null);

		binaryTree mytree=new binaryTree();
		mytree.add(node1);
		mytree.add(node2);
		mytree.add(node3);
		mytree.add(node4);
		mytree.add(node5);
		mytree.add(node6);
		countNodesAtAllLevels(mytree.root);

	}

}
