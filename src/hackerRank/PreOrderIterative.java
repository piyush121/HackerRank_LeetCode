package hackerRank;

import java.util.Stack;

public class PreOrderIterative {
	
	public static void preOrder(treeNode root)
	{
		Stack <treeNode> mystack=new Stack<>();
		mystack.push(root);
		

		
		while(!mystack.isEmpty())
		{
			treeNode mynode=mystack.pop();
			System.out.println(mynode.data);

			if(mynode.right!=null)
				mystack.push(mynode.right);
			
			if(mynode.left!=null)
				mystack.push(mynode.left);
								
		}
		
		
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
		System.out.println("Pre Order Traversal...");
		preOrder(mytree.root);
	}

}
