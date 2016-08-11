package hackerRank;

import java.util.Stack;

public class PostOrderIterative {
	
	public static void postOrder(treeeNode root)
	{
		Stack <treeeNode> st1=new Stack<>();
		Stack <Integer> st2=new Stack<>();

		st1.push(root);
		while(!st1.isEmpty())
		{
			treeeNode node=st1.pop();
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
		
	treeeNode node1=new treeeNode(4,null,null);
	treeeNode node2=new treeeNode(5,null,null);
	treeeNode node3=new treeeNode(2,null,null);
	treeeNode node4=new treeeNode(1,null,null);
	treeeNode node5=new treeeNode(3,null,null);
	treeeNode node6=new treeeNode(6,null,null);

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
