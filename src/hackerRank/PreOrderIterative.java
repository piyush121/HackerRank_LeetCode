package hackerRank;

import java.util.Stack;

public class PreOrderIterative {
	
	public static void preOrder(treeeNode root)
	{
		Stack <treeeNode> mystack=new Stack<>();
		mystack.push(root);
		

		
		while(!mystack.isEmpty())
		{
			treeeNode mynode=mystack.pop();
			System.out.println(mynode.data);

			if(mynode.right!=null)
				mystack.push(mynode.right);
			
			if(mynode.left!=null)
				mystack.push(mynode.left);
								
		}
		
		
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
		System.out.println("Pre Order Traversal...");
		preOrder(mytree.root);
	}

}
