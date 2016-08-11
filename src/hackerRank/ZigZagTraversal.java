package hackerRank;

import java.util.Stack;

public class ZigZagTraversal {
	static Stack<treeeNode> st1=new Stack<>();
	static Stack<treeeNode> st2=new Stack<>();
	public static void zigZag(treeeNode root)
	{
		if(root==null)
			return;
		
		st1.push(root);
		while(!st1.isEmpty())
		{
			treeeNode node=st1.pop();
			if(node.left!=null)
				st2.push(node.left);
			if(node.right!=null)
				st2.push(node.right);
	 		System.out.print(" "+node.data);

		}
 		System.out.println();

		while(!st2.isEmpty())
		{
			treeeNode node=st2.pop();
			if(node.right!=null)
				st1.push(node.right);
			if(node.left!=null)
				st1.push(node.left);
	 		System.out.print(" "+node.data);

		}
 		System.out.println();
 		if(!st1.isEmpty())
 			zigZag(st1.pop());
 		
	}
	
	public static void zigZagEfficient(treeeNode root) //O(n)
	{	
		 Stack<treeeNode> st1=new Stack<>();
		 Stack<treeeNode> st2=new Stack<>();
		boolean leftToRight=true;
		st1.push(root);
		while(!st1.isEmpty())
		{	
			treeeNode node=st1.pop();
 			System.out.print(node.data+" ");

			if(leftToRight)
			{
				if(node.left!=null)
					st2.push(node.left);
				if(node.right!=null)
					st2.push(node.right);
			}
			else
			{
				if(node.right!=null)
					st2.push(node.right);
				if(node.left!=null)
					st2.push(node.left);
			}
			if(st1.isEmpty())
			{
				Stack<treeeNode> temp=st1;
				st1=st2;
				st2=temp;
		 		System.out.println("");
		 		leftToRight=!leftToRight;

			}
			
			
		}
		
	}

	 public static void main(String[] args) {
 		treeeNode node1=new treeeNode(4,null,null);
 		treeeNode node2=new treeeNode(5,null,null);
 		treeeNode node3=new treeeNode(2,null,null);
 		treeeNode node4=new treeeNode(1,null,null);
 		treeeNode node5=new treeeNode(3,null,null);
 		treeeNode node6=new treeeNode(0,null,null);
 		
 		binaryTree mytree=new binaryTree();
 		mytree.add(node1);
 		mytree.add(node2);
 		mytree.add(node3);
 		mytree.add(node4);
 		mytree.add(node5);
 		mytree.add(node6);
 		zigZag(mytree.root);

 		zigZagEfficient(mytree.root);
 		}
}
