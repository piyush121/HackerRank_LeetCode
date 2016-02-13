package hackerRank;

import java.util.Stack;

public class PreOrderIterative {
	
	public static void preOrder(treeNode root)
	{
		Stack <treeNode> mystack=new Stack<>();
		mystack.push(root);
		treeNode node=mystack.peek();

		while(node!=null)
		{

			System.out.println(node.data);
			mystack.push(node.left);
			node=node.left;
						
		}
		
		while(!mystack.isEmpty())
		{
			treeNode mynode=mystack.pop();
			if(mynode.right!=null)
				{
					mynode=mynode.right;
					if(mynode.left!=null)
					while(mynode!=null)
					{
						System.out.println(mynode.data);
						mystack.push(mynode.left);
						mynode=mynode.left;
					}
				}
		}
		
		
	}
	public static void main(String[] args) {
		
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
		System.out.println("Pre Order Traversal...");
		preOrder(mytree.root);
	}

}
