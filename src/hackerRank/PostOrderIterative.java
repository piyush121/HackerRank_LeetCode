package hackerRank;

import java.util.Stack;

public class PostOrderIterative {
	
	public static void postOrder(treeNode root)
	{
		Stack <treeNode> st1=new Stack<>();
		Stack <Integer> st2=new Stack<>();

		st1.push(root);
		while(!st1.isEmpty())
		{
			treeNode node=st1.pop();
			if(node.left!=null)
				st1.push(node.left);
			if(node.right!=null)
				st1.push(node.right);
			st2.push(node.data);
		}
		while(!st2.isEmpty())

		System.out.println(st2.pop());
		
	}
	
public static void main(String[] args) {
		
		treeNode node1=new treeNode(4,null,null);
		treeNode node2=new treeNode(5,null,null);
		treeNode node3=new treeNode(2,null,null);
		treeNode node4=new treeNode(1,null,null);
		treeNode node5=new treeNode(3,null,null);
		treeNode node6=new treeNode(6,null,null);

		binaryTree mytree=new binaryTree();
		mytree.add(node1);
		mytree.add(node2);
		mytree.add(node3);
		mytree.add(node4);
		mytree.add(node5);
		mytree.add(node6);
		System.out.println("Post Order Traversal...");
		postOrder(mytree.root);
	}

}
